package mazes.generators.carvers;

import datastructures.graphs.Edge;
import datastructures.graphs.Graph;
import datastructures.sets.ChainedHashSet;
import datastructures.sets.ISet;
import mazes.entities.Maze;
import mazes.entities.Room;
import mazes.entities.Wall;
import java.util.Random;


/**
 * Carves out a maze based on Kruskal's algorithm.
 *
 * See the spec for more details.
 */
public class KruskalMazeCarver implements MazeCarver {
    /**
     * A helper method for constructing a new `Graph`.
     */
    protected Graph<Room, Wall> makeGraph() {
        /*
        Do not change this method; it only exists so that we can override it during grading to test
        your code using our correct version of `Graph`.

        Make sure to use this instead of calling the `Graph` constructor yourself; otherwise, you
        may end up losing extra points if your `Graph` does not behave correctly.
         */
        return new Graph<>();
    }

    @Override
    public ISet<Wall> returnWallsToRemove(Maze maze) {
        Random rand = new Random();

        Graph<Room, Wall> graph = makeGraph();
        ISet<Wall> toRemove = new ChainedHashSet<>();

        for (Wall wall: maze.getRemovableWalls()) {
            Double random = rand.nextDouble();
            //set random weight to wall
            graph.addVertex(wall.getRoom1());
            graph.addVertex(wall.getRoom2());
            graph.addEdge(wall.getRoom1(), wall.getRoom2(), random);
        }

        ISet<Edge<Room, Wall>> mst = graph.findMinimumSpanningTree();

        for (Wall w: maze.getRemovableWalls()) { //go through each removable wall
            for (Edge<Room, Wall> m: mst) { //go through each edge in mst
                if ((w.getRoom1() == m.getVertex1()) && (w.getRoom2() == m.getVertex2())) { //if the walls are the same
                    toRemove.add(w); //add it to the list of walls we can remove
                }
            }
        }
        return toRemove;
    }
}