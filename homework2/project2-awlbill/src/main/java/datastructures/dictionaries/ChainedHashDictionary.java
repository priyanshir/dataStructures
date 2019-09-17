package datastructures.dictionaries;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @see IDictionary and the assignment page for more details on what each method should do
 */
public class ChainedHashDictionary<K, V> implements IDictionary<K, V> {
    // You'll need to define reasonable default values for each of the following three fields
    private static final double DEFAULT_RESIZING_LOAD_FACTOR_THRESHOLD = 0.5; // load factor
    private static final int DEFAULT_INITIAL_CHAIN_COUNT = 10; // initial bucket/chain size
    private static final int DEFAULT_INITIAL_CHAIN_CAPACITY = 15; // initial arrayDict size

    private double resizingLoadFactorThreshold;
    private int initialChainCount;
    private int chainInitialCapacity;
    private int size; // total number of arrayDictionary Pairs

    /*
    Warning:
    You may not rename this field or change its type.
    We will be inspecting it in our secret tests.

    Note: The field below intentionally omits the "private" keyword. By leaving off a specific
    access modifier like "public" or "private" it becomes package-private, which means anything in
    the same package can access it. Since our tests are in the same package, they will be able
    to test this property directly.
     */
    IDictionary<K, V>[] chains;

    // You're encouraged to add extra fields (and helper methods) though!

    public ChainedHashDictionary() {
        this(DEFAULT_RESIZING_LOAD_FACTOR_THRESHOLD, DEFAULT_INITIAL_CHAIN_COUNT, DEFAULT_INITIAL_CHAIN_CAPACITY);
    }

    public ChainedHashDictionary(double resizingLoadFactorThreshold, int initialChainCount, int chainInitialCapacity) {
        this.resizingLoadFactorThreshold = resizingLoadFactorThreshold;
        this.initialChainCount = initialChainCount;
        this.chainInitialCapacity = chainInitialCapacity;
        this.size = 0;
        this.chains = makeArrayOfChains(initialChainCount);
    }

    /**
     * This method will return a new, empty array of the given size that can contain
     * `IDictionary<K, V>` objects.
     *
     * Note that each element in the array will initially be null.
     */
    @SuppressWarnings("unchecked")
    private IDictionary<K, V>[] makeArrayOfChains(int arraySize) {
        return (IDictionary<K, V>[]) new IDictionary[arraySize];
    }

    @Override
    public V get(K key) {
        int keyHash = createHashCode(key, this.chains.length);

        if (this.chains[keyHash] == null || !this.chains[keyHash].containsKey(key)) {
            throw new NoSuchKeyException();
        }
        else {
            return this.chains[keyHash].get(key);
        }
    }

    @Override
    public V put(K key, V value) {

        int keyHash = createHashCode(key, this.chains.length);

        if (this.chains[keyHash] == null) { // make new arrayDict if the spot is null
            this.chains[keyHash] = new ArrayDictionary<K, V>();
        }

        boolean keyAlreadyPresent = false;
        V oldValue = null;
        if (this.chains[keyHash].containsKey(key)) { //if the key is already present, return old value
            oldValue = this.chains[keyHash].get(key);
            keyAlreadyPresent = true;
        }
        this.chains[keyHash].put(key, value); // puts key into the bucket

        if ((((double) this.size) / ((double) this.chains.length)) >= this.resizingLoadFactorThreshold) {
            this.chains = resize();
        }

        if (keyAlreadyPresent) { // if it was a duplicate key, return the replaced value
            return oldValue;
        } else {
            this.size++;
            return null;
        }
    }

    private IDictionary<K, V>[] resize() {
        int newTableSize = this.chains.length * 2;
        IDictionary<K, V>[] newTable = makeArrayOfChains(newTableSize);

        for (int i = 0; i < this.chains.length; i++) { // for each bucket in current hash table

            if (this.chains[i] != null) { // if there's an array dictionary there
                for (KVPair<K, V> pair : this.chains[i]) { //for each key-value pair in that dictionary
                    int keyHash = createHashCode(pair.getKey(), newTableSize); //rehash the key

                    if (newTable[keyHash] == null) {
                        newTable[keyHash] = new ArrayDictionary<K, V>(); //create bucket if necessary
                    }

                    newTable[keyHash].put(pair.getKey(), pair.getValue()); //put the rehashed key+value into new table
                }
            }
        }
        return newTable;
    }

    @Override
    public V remove(K key) {
        int keyHash = createHashCode(key, this.chains.length);
        if (this.chains[keyHash] != null) { //if there is a bucket
            if (this.chains[keyHash].containsKey(key)) { //if the key is not present, throw exception
                this.size--;
                return this.chains[keyHash].remove(key); //returns removed value
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        int keyHash = createHashCode(key, this.chains.length);
        if (this.chains[keyHash] != null) {
            return (this.chains[keyHash].containsKey(key));
        }
        else { // if it is null
            return false;
        }
    }

    @Override
    public int size() {
        return this.size;
    }

    // Create a hash code for a given key for a given table size
    private int createHashCode(K key, int tableSize) {
        int keyHash = 0;
        if (key == null) { // null case
            keyHash = 0;
        }
        if (key != null) { // creating hashKey
            keyHash = Math.abs(key.hashCode());
        }
        if (keyHash >= tableSize) { // if it's greater than
            keyHash %= tableSize;
        }
        return keyHash;
    }

    @Override
    public Iterator<KVPair<K, V>> iterator() {
        return new ChainedIterator<>(this.chains, this.size);
    }

    @Override
    public String toString() {
        // return super.toString();

        /*
        After you've implemented the iterator, comment out the line above and uncomment the line
        below to get a better string representation for objects in assertion errors and in the
        debugger.
        */

        return IDictionary.toString(this);
    }
    /*
    See the assignment webpage for tips and restrictions on implementing this iterator.
     */
    private static class ChainedIterator<K, V> implements Iterator<KVPair<K, V>> {
        private IDictionary<K, V>[] chains;
        private int currentBucket; // index of current bucket in table
        private Iterator<KVPair<K, V>> bucketIterator; // iterator for current bucket
        private int i;
        private int numKeys;

        // You may add more fields and constructor parameters

        public ChainedIterator(IDictionary<K, V>[] chains, int tableSize) {
            this.chains = chains;
            this.currentBucket = 0; // index of current bucket
            this.bucketIterator = null;
            this.i = 0; // How many keys have been iterated over
            this.numKeys = tableSize; // the number of keys in the whole hash table
        }

        // Invariants:
        // As long as iterator has more values, next() is not null.
        // When iterator has no more values, next() is null.

        // Order does not matter.

        @Override
        public boolean hasNext() {
            return (this.i < this.numKeys); // if i == number of keys, everything has been looked at
        }

        @Override
        public KVPair<K, V> next() {

            if (this.i == this.numKeys) { // if all elements have been looked at or if there is nothing in the table
                throw new NoSuchElementException(); // iteration over
            }

            if (this.bucketIterator == null) {  // when iterator is first created, need to find first bucket
                lookAhead();
            }

            if (!this.bucketIterator.hasNext()) { // if the current bucket is exhausted
                this.currentBucket++; // get off of current bucket
                lookAhead();
            }

            this.i++; // made it to an actual key
            return this.bucketIterator.next();
        }

        // get pointer to the next bucket with keys and make an iterator for that bucket
        private void lookAhead() {
            while (this.chains[this.currentBucket] == null || this.chains[this.currentBucket].isEmpty()) {
                this.currentBucket++;
            }
            this.bucketIterator = this.chains[this.currentBucket].iterator();
        }
    }
}
