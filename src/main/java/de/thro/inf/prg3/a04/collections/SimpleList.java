package de.thro.inf.prg3.a04.collections;

import java.util.function.Function;

public interface SimpleList<T> extends Iterable<T> {
	/**
	 * Add a given object to the back of the list.
	 */
	void add(T o);

	/**
	 * @return current size of the list
	 */
	int size();

    /**
     * @return current Item T of the List
     */
	T getItem();

	/**
     * @return next Element
	 */
	T getNext();

    /**
     * Get a new SimpleList instance with all items of this list which match the given filter
     * @param filter SimpleFilter instance
     * @return new SimpleList instance
     */
	default SimpleList<T> filter(SimpleFilter<T> filter){
        SimpleList<T> result = new SimpleListImpl<T>();
        for(T o : this){
            if(filter.include(o)){
                result.add(o);
            }
        }
        return result;
    }

	default SimpleList<T> addDefault(){
	    return new SimpleListImpl<>();
    }

	default <R> SimpleList<R> map(Function<T, R> transform){

	    SimpleList<R> result = new SimpleListImpl<>();

        for (T o: this) {
            R tmp = transform.apply(o);
            result.add(tmp);
        }

        return result;
    }
}
