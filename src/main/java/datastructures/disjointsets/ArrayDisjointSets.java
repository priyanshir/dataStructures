package datastructures.disjointsets;

import datastructures.dictionaries.ChainedHashDictionary;
import datastructures.dictionaries.IDictionary;

/**
 * @see IDisjointSets for more details.
 */
public class ArrayDisjointSets<T> implements IDisjointSets<T> {
    // Do NOT rename or delete this field. We will be inspecting it directly in our private tests.
    int[] pointers;
    private IDictionary<T, Integer> dictionary; //dictionary of item -> set ID/rep (value)
    private static final int CAPACITY = 50;
    private int value;
    /*
    However, feel free to add more fields and private helper methods. You will probably need to
    add one or two more fields in order to successfully implement this class.
    */

    public ArrayDisjointSets() {
        pointers = new int[CAPACITY]; //initialize pointer dictionary with capacity
        dictionary = new ChainedHashDictionary<>(); //dictionary that points to each node
        value = 0; //rank
    }

    @Override
    public void makeSet(T item) {
        if (dictionary.containsKey(item)) { //if `item` is already contained in one of these sets
            throw new IllegalArgumentException();
        } //otherwise
        if (this.value >= this.pointers.length) { //need to resize: double the size of the array and copy elements over
            int[] doubled = new int[this.pointers.length * 2];
            for (int i = 0; i < this.pointers.length; i++) {
                doubled[i] = this.pointers[i];
            }
            this.pointers = doubled;
        }
        pointers[value] = -1; //setting all roots with rank of -1
        dictionary.put(item, value); //item -> 0, secondItem -> 1 etc.
        value++; //update value
    }

    @Override
    public int findSet(T item) {
        if (!dictionary.containsKey(item)) {
            throw new IllegalArgumentException();
        }
        int index = this.dictionary.get(item);
        while (this.pointers[index] >= 0) { //repeat until you reach a negative index (which is the root's ID)
            index = this.pointers[index];
        }
        return index;
    }
    @Override
    public boolean union(T item1, T item2) {
        if (!this.dictionary.containsKey(item1) || !this.dictionary.containsKey(item2)) {
            throw new IllegalArgumentException();
        }
        int item1ID = findSet(item1);
        int item2ID = findSet(item2);

        if (item1ID != item2ID) { //making sure they're not in the same set and if so return true
            int rank1 = this.pointers[item1ID];
            int rank2 = this.pointers[item2ID];
            if (rank1 > rank2) {
                this.pointers[item1ID] = item2ID;
            }
            else {
                this.pointers[item2ID] = item1ID;
            }
            return true;
        }
        else {
            return false;
        }
    }
}
