package iterador;


public class ArrayIterator<T> implements Iterator<T> {

    T []array;
    int index;

    public ArrayIterator(T []arr) {
        array = arr;
        index = 0;
    }

    
    @Override
    public boolean hasNext() {
        return array.length > index;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        
        return array[index++];
    }

}
