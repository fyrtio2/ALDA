import java.util.LinkedList;
import java.util.List;

/**
 *@Author Oscar Törnquist   -osta3589
 *@Author Emil Rosell       -emro9957
 *u
 */

public class MySkipList<T extends Comparable<T>> {

    private int size;
    private Node<T> head, tail;

    public boolean add(T data) {
        return addLast(data);
    }

    public boolean contains(T data) {
        return find(data) != null;
    }

    public boolean addFirst(T data) {
        return false;
    }

    public boolean remove(T data) {
        return poll(data) != null;
    }

    public Node<T> poll(T data) {
        return null;
    }

    public Node<T> getHead(){ return head; }
    public Node<T> getTail() { return tail; }

    private Node<T> find(T data) {
        return null;
    }

    private boolean addLast(T data) {
        return false;
    }

    private class Node<T> {
        T data;
        List<T> nextNodes = new LinkedList<>();

    }

}

