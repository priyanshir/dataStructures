package datastructures.sets;

import datastructures.dictionaries.ChainedHashDictionary;
import datastructures.dictionaries.IDictionary;
import datastructures.dictionaries.KVPair;

import java.util.Iterator;

/**
 * @see ISet for more details on what each method is supposed to do.
 */
public class ChainedHashSet<T> implements ISet<T> {
    // This should be the only field you need
    private IDictionary<T, Boolean> map;

    public ChainedHashSet() {
        // No need to change this method
        this.map = new ChainedHashDictionary<>();
    }

    @Override
    public boolean add(T item) {
        if (!map.containsKey(item)) { //if it didnt have the key, but now it does
            map.put(item, true); //put and now boolean = true
            return true;
        }
        else {
            return false;
        }

    }

    @Override
    public boolean remove(T item) {
        if ((map.containsKey(item))) {
            map.remove(item);
            return true;
        }
        else { //if key not in the set
            return false;
        }
    }

    @Override
    public boolean contains(T item) {
        return map.containsKey(item);
    }

    @Override
    public int size() { //DONE
        return map.size();
    }

    @Override
    public Iterator<T> iterator() {
        return new SetIterator<>(this.map.iterator());
    }

    @Override
    public String toString() {
        // return super.toString();

        /*
        After you've implemented the iterator, comment out the line above and uncomment the line
        below to get a better string representation for objects in assertion errors and in the
        debugger.
        */

        return ISet.toString(this);
    }

    private static class SetIterator<T> implements Iterator<T> {
        // This should be the only field you need
        private Iterator<KVPair<T, Boolean>> iter;

        public SetIterator(Iterator<KVPair<T, Boolean>> iter) { //DONE
            // No need to change this method.
            this.iter = iter;
        }

        @Override
        public boolean hasNext() { //DONE
            return iter.hasNext();
        }

        @Override
        public T next() { //DONE
            return iter.next().getKey();
        }
    }
}