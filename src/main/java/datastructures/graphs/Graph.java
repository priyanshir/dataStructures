package datastructures.graphs;

import datastructures.dictionaries.ChainedHashDictionary;
import datastructures.dictionaries.IDictionary;
import datastructures.dictionaries.KVPair;
import datastructures.disjointsets.ArrayDisjointSets;
import datastructures.disjointsets.IDisjointSets;
import datastructures.lists.DoubleLinkedList;
import datastructures.lists.IList;
import datastructures.sets.ChainedHashSet;
import datastructures.sets.ISet;
import misc.Sorter;
import datastructures.priorityqueues.ArrayHeapPriorityQueue;
import datastructures.priorityqueues.IPriorityQueue;

/**
 * Represents an undirected, weighted graph, possibly containing self-loops, parallel edges,
 * and unconnected components.
 *
 * @param <V> the type of the vertices
 * @param <E> the type of the additional data contained in edges
 *
 * Note: This class is not meant to be a full-featured way of representing a graph.
 * We stick with supporting just a few, core set of operations needed for the
 * remainder of the project.
 */
public class Graph<V, E> {
    /*
    Feel free to add as many fields, private helper methods, and private inner classes as you want.

    And of course, as always, you may also use any of the data structures and algorithms we've
    implemented so far.

    Note: If you plan on adding a new class, please be sure to make it a private static inner class
    contained within this file. Our testing infrastructure works by copying specific files from your
    project to ours, and if you add new files, they won't be copied and your code will not compile.
    */
    private IDictionary<V, ISet<Edge<V, E>>> graph;
    private IList<Edge<V, E>> edges;
    private IList<V> vertices;
    private int totalEdges;
    private int totalVertices;
    /**
     * Constructs a new empty graph.
     */
    public Graph() {
        this.graph = new ChainedHashDictionary<>();
        this.totalEdges = 0;
        this.totalVertices = 0;
        this.vertices = new DoubleLinkedList<>();
        this.edges = new DoubleLinkedList<>();
    }

    /**
     * Adds a vertex to this graph. If the vertex is already in the graph, does nothing.
     */
    public void addVertex(V vertex) {
        if (!graph.containsKey(vertex)) {
            graph.put(vertex, new ChainedHashSet<>());
            vertices.add(vertex);
        }
        totalVertices +=1;
    }

    /**
     * Adds a new edge to the graph, with null data.
     *
     * Every time this method is (successfully) called, a unique edge is added to the graph; even if
     * another edge between the same vertices and with the same weight and data already exists, a
     * new edge will be created and added (where `newEdge.equals(oldEdge)` is false).
     *
     * @throws IllegalArgumentException  if `weight` is null
     * @throws IllegalArgumentException  if either vertex is not contained in the graph
     */
    public void addEdge(V vertex1, V vertex2, double weight) {
        this.addEdge(vertex1, vertex2, weight, null);
    }

    /**
     * Adds a new edge to the graph with the given data.
     *
     * Every time this method is (successfully) called, a unique edge is added to the graph; even if
     * another edge between the same vertices and with the same weight and data already exists, a
     * new edge will be created and added (where `newEdge.equals(oldEdge)` is false).
     *
     * @throws IllegalArgumentException  if `weight` is null
     * @throws IllegalArgumentException  if either vertex is not contained in the graph
     */
    public void addEdge(V vertex1, V vertex2, double weight, E data) {
        if (weight < 0 || !graph.containsKey(vertex1) || !graph.containsKey(vertex2)) {
            throw new IllegalArgumentException();
        }
        Edge<V, E> addedEdge = new Edge<>(vertex1, vertex2, weight, data);
        graph.get(vertex1).add(addedEdge);
        graph.get(vertex2).add(addedEdge);
        edges.add(addedEdge);
        totalEdges += 1;
    }

    /**
     * Returns the number of vertices contained within this graph.
     */
    public int numVertices() {
        return totalVertices;
    }

    /**
     * Returns the number of edges contained within this graph.
     */
    public int numEdges() {
        return totalEdges;
    }

    /**
     * Returns the set of all edges that make up the minimum spanning tree of this graph.
     *
     * If there exists multiple valid MSTs, returns any one of them.
     *
     * Precondition: the graph does not contain any unconnected components.
     */
    public ISet<Edge<V, E>> findMinimumSpanningTree() {
        IDisjointSets<V> mst = new ArrayDisjointSets<>();
        ISet<Edge<V, E>> resultingSet = new ChainedHashSet<>();

        for (KVPair<V, ISet<Edge<V, E>>> pair : this.graph) {
            mst.makeSet(pair.getKey());
        }

        IList<Edge<V, E>> sortedEdges = Sorter.topKSort(this.totalEdges, this.edges); // list of sorted number of edges

        for (Edge e: sortedEdges) {
            V vertex1 = (V) e.getVertex1();
            V vertex2 = (V) e.getVertex2();
            if (mst.findSet(vertex1) != mst.findSet(vertex2)) {
                mst.union(vertex1, vertex2);
                resultingSet.add(e);
            }
        }
        return resultingSet;
    }

    /**
     * Returns the edges that make up the shortest path from `start` to `end`.
     *
     * The first edge in the output list will be the edge leading out of the `start` node; the last
     * edge in the output list will be the edge connecting to the `end` node.
     *
     * Returns an empty list if the start and end vertices are the same.
     *
     * @throws NoPathExistsException  if there does not exist a path from `start` to `end`
     * @throws IllegalArgumentException if `start` or `end` is null or not in the graph
     */
    public IList<Edge<V, E>> findShortestPathBetween(V start, V end) {
        IList<Edge<V, E>> path = new DoubleLinkedList<>();

        if (start == null || end == null || !graph.containsKey(start) || !graph.containsKey(end)) {
            throw new IllegalArgumentException();
        }
        if (start == end) {
            return path; // empty list if start and end are same
        }

        IDictionary<V, ComparableVertex<V, E>> dict = new ChainedHashDictionary<>();
        IPriorityQueue<ComparableVertex<V, E>> minHeap = new ArrayHeapPriorityQueue<>();

        for (V vertex : this.vertices) { // add every vertex with a weight of infinity
            dict.put(vertex, new ComparableVertex<>(false, null, vertex, Double.POSITIVE_INFINITY));
        }
        ComparableVertex<V, E> source = new ComparableVertex<V, E>(false, null, start, 0.0);
        minHeap.add(source); // adds the source with 0.0
        dict.put(start, source); // update dict with that source

        // Dijkstra's algorithm
        while (!minHeap.isEmpty()) {
            ComparableVertex<V, E> u = dict.get(minHeap.removeMin().currentVertex);

            for (Edge e : graph.get(u.currentVertex)) { // For every outgoing edge of this vertex
                if (!dict.get((V) e.getOtherVertex(u.currentVertex)).processed) {
                    // The vertex at the end of this edge
                    ComparableVertex<V, E> v = dict.get((V) e.getOtherVertex(u.currentVertex));
                    // Keep track of old cost and new cost
                    double oldCost = v.cost;
                    double newCost = u.cost + e.getWeight();
                    // If this path is shorter than previously known paths to this outgoing vertex
                    if (newCost < oldCost) {
                        ComparableVertex<V, E> updated = new ComparableVertex<V, E>(false,
                                u.currentVertex, v.currentVertex, newCost);
                        dict.put(v.currentVertex, updated);
                        if (oldCost == Double.POSITIVE_INFINITY) { // Vertex not seen before
                            minHeap.add(updated);
                        } else { // Vertex seen before
                            // ComparableVertex<V, E> newV = // Update priority of vertex since its new cost is lower
                            //         new ComparableVertex<>(false, u.currentVertex, v.currentVertex, newCost);
                            minHeap.replace(v, updated);
                        }
                    }
                }
            }
            ComparableVertex<V, E> oldVertex = dict.get(u.currentVertex);
            dict.put(u.currentVertex, new ComparableVertex<V, E>(true,
                    oldVertex.predecessor, oldVertex.currentVertex, oldVertex.cost));
        }

        // Get the shortest path between the two vertices by following back-pointers
        V v1 = end;
        V v2 = dict.get(end).predecessor;
        if (v2 == null) { // Dijkstra's never got here. There is no path.
            throw new NoPathExistsException();
        }
        Edge<V, E> e = new Edge<V, E>(v1, v2, dict.get(v1).cost - dict.get(v2).cost);
        path.add(e);
        if (v2 != start) { // If there is more than one edge in the path
            while (v2 != start) { // Until we reach the start
                v1 = v2;
                v2 = dict.get(v1).predecessor;
                e = new Edge<V, E>(v1, v2, dict.get(v1).cost - dict.get(v2).cost);
                path.add(e);
            }
            // Reverse the list
            IList<Edge<V, E>> truePath = new DoubleLinkedList<>();
            for (int i = path.size() - 1; i >= 0; i--) {
                truePath.add(path.get(i));
            }
            path = truePath;
        }

        return path;

    }

    private class ComparableVertex<V, E> implements Comparable<ComparableVertex<V, E>> {
        private double cost;
        private boolean processed;
        private V predecessor;
        private V currentVertex;

        public ComparableVertex(boolean processed, V predecessor, V vertex, double cost) {
            this.processed = processed;
            this.predecessor = predecessor;
            this.currentVertex = vertex;
            this.cost = cost;
        }
        public V getPredecessor() {
            return this.predecessor;
        }
        public V getCurrentVertex() {
            return this.currentVertex;
        }
        public double getCost() {
            return this.cost;
        }
        public int compareTo(ComparableVertex<V, E> other) {
            double result = this.cost - other.cost;
            if (result > 0) {
                return 1;
            } else if (result == 0) {
                return 0;
            } else {
                return -1;
            }
        }
    }
}
