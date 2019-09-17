package datastructures.dictionaries;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @see IDictionary
 */
public class ArrayDictionary<K, V> implements IDictionary<K, V> {
    /*
    Warning:
    You may not rename this field or change its type.
    We will be inspecting it in our secret tests.

    Note: The field below intentionally omits the "private" keyword. By leaving off a specific
    access modifier like "public" or "private" it becomes package-private, which means anything in
    the same package can access it. Since our tests are in the same package, they will be able
    to test this property directly.
     */
    Pair<K, V>[] pairs;
    private int size; //created a field named size to keep track of size

    // You may add extra fields or helper methods though!
    //DONE
    public ArrayDictionary() {
        this.pairs = makeArrayOfPairs(1);
        this.size = 0;
    }

    /**
     * This method will return a new, empty array of the given size that can contain `Pair<K, V>`
     * objects.
     *
     * Note that each element in the array will initially be null.
     */
    @SuppressWarnings("unchecked")
    private Pair<K, V>[] makeArrayOfPairs(int arraySize) {
        /*
        It turns out that creating arrays of generic objects in Java is complicated due to something
        known as "type erasure."

        We've given you this helper method to help simplify this part of your assignment. Use this
        helper method as appropriate when implementing the rest of this class.

        You are not required to understand how this method works, what type erasure is, or how
         arrays and generics interact. Do not modify this method in any way.
        */
        return (Pair<K, V>[]) (new Pair[arraySize]);
    }

    public ArrayDictionary(int initialCapacity) { //new constructor
        this.pairs = makeArrayOfPairs(initialCapacity);
        this.size = 0;
    }

    @Override
    public V get(K key) {
        if (!this.containsKey(key)) {
            throw new NoSuchKeyException();
        }
        int index = indexOf(key);
        return this.pairs[index].value;
    }

    @Override
    public V put(K key, V value) {
        int index = indexOf(key);
        if (index != -1) { //if key does exist within the arrayDict
            V oldValue = this.pairs[index].value;
            this.pairs[index].value = value;
            return oldValue;
        }
        else { //doesn't contain key
            if (this.pairs.length == this.size) {//if array is full
                int doubledSize = this.pairs.length * 2;
                Pair<K, V>[] newDict = this.makeArrayOfPairs(doubledSize);
                for (int i = 0; i < this.pairs.length; i++) {
                    newDict[i] = this.pairs[i];
                }
                this.pairs = newDict; //setting to current pair
            }
            this.pairs[this.size] = new Pair<K, V>(key, value); //add new pair sat the end
            size++; //increment size
            return null; //since key wasn't there in the first place
        }
    }

    @Override
    public V remove(K key) {
        if (!this.containsKey(key)) {
            return null;
        }
        else { //if it contains the key
            int index = indexOf(key);
            V deletedValue = this.pairs[index].value; //save old value
            this.pairs[index] = this.pairs[this.size() - 1]; //set it equal to the last pair
            this.pairs[this.size() - 1] = null; //make last element equal null
            size--;
            return deletedValue;
        }
    }
    @Override
    public V getOrDefault(K key, V defaultValue) {
        if (this.indexOf(key) != -1) {
            return this.get(key);
        } else {
            return defaultValue;
        }
    }

    @Override
    public boolean containsKey(K key) {
        return (indexOf(key) != -1); //if it's not -1 it contains the key, if == -1 then it's false and doesn't contain
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public Iterator<KVPair<K, V>> iterator() {
        return new ArrayDictionaryIterator<>(this.pairs, this.size);
    }

    @Override
    public String toString() {
        //return super.toString();

        /*
        After you've implemented the iterator, comment out the line above and uncomment the line
        below to get a better string representation for objects in assertion errors and in the
        debugger.
        */

        return IDictionary.toString(this);
    }
    //private method to find index of passed in key and return -1 if not found
    private int indexOf(K key) {
        for (int i = 0; i < this.size; i++) {
            if ((key == null && this.pairs[i].key == null) || (this.pairs[i].key != null &&
                    this.pairs[i].key.equals(key))) { //special case if key = null and comparing 2 objects
                return i;
            }
        }
        return -1;
    }

    private static class Pair<K, V> {
        public K key;
        public V value;

        // You may add constructors and methods to this class as necessary.
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("%s=%s", this.key, this.value);
        }
    }

    private static class ArrayDictionaryIterator<K, V> implements Iterator<KVPair<K, V>> {
        private Pair<K, V>[] pairs; //overall arrayDict to iterate through
        private int i; //will keep track of indeces
        private int size; //the entire size of the arrayDict

        public ArrayDictionaryIterator(Pair<K, V>[] pairs, int size) {
            this.pairs = pairs;
            this.i = 0;
            this.size = size;
        }

        @Override
        public boolean hasNext() { //returns true if there is still a next element to look at
            return (i <= this.size - 1);
        }

        @Override
        public KVPair<K, V> next() {
            if (!this.hasNext()) {
                throw new NoSuchElementException();
            }
            else {
                KVPair<K, V> curr = new KVPair<>(this.pairs[i].key, this.pairs[i].value);
                i++;
                return curr;
            }
        }
    }
}