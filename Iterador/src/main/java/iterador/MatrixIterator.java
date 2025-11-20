package iterador;

public class MatrixIterator<T> implements Iterator<T>{

    int indexN;
    int indexM;
    T [][]matrix;
    
    public MatrixIterator(T [][]m) {
        matrix = m;
        indexN = 0;
        indexM = 0;
    }
    
    @Override
    public boolean hasNext() {
        return matrix[0].length > indexM && matrix.length > indexN;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            return null;
        }
        
        T element = matrix[indexN][indexM];
        
        indexM++;
        if (indexM >= matrix[0].length) {
            indexM = 0;
            indexN++;
        }
        return element;
    }

}
