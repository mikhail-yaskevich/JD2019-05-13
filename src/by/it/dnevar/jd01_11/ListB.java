package by.it.dnevar.jd01_11;

import java.util.*;

public class ListB <E> implements List <E> {

    private E[] elements = (E[]) new Object[]{};
    private int size = 0;

    @Override
    public boolean add(E element) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements,size*3/2+1);
        }
        elements[size++] = element;
        return true;
    }

    @Override
    public E get(int index) {
        return elements[index];
    }

    @Override
    public E remove(int index) {
        E del = elements[index];
        System.arraycopy(elements,index+1,elements,index,size-1-index);
        size--;
        return del;
    }

    @Override
    public E set(int index, E element) {
        E del = elements[index];
        elements[index] = element;
        return del;
    }

    @Override
    public void add(int index, E element) {
        if(size == elements.length){
            elements = Arrays.copyOf(elements,size*3/2+1);
        }
        System.arraycopy(elements,index,elements,index+1,size-index);
        elements[index] = element;
        size++;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] o = c.toArray();
        int colLength = o.length;
        elements = Arrays.copyOf(elements,size+colLength);
        System.arraycopy(o,0,elements,size,colLength);
        size += colLength;
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        String delimiter = "";
        for (int i = 0; i < size; i++) {
            sb.append(delimiter).append(elements[i]);
            delimiter = ", ";

        }
        sb.append("]");
        return sb.toString();
    }

    //---------------------------------------------------------------------

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }


    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }
}
