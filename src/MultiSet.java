/**
 * Abstract class representing a MultiSet ADT.
 */
public abstract class MultiSet {

    /**
     * Add the given item to this multiset.
     *
     * @param item the item to add
     */
    abstract void add(Integer item);

    // finish adding abstract methods to fully describe what it means to be a MultiSet.
    abstract void remove(Integer item);
    abstract void contains(Integer item);
    abstract boolean is_empty();
    abstract int count(Integer item);
    abstract int size();
}
