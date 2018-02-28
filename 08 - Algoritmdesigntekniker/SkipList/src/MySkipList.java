import java.util.LinkedList;
import java.util.List;

/**
 *@Author Oscar Törnquist   -osta3589
 *@Author Emil Rosell       -emro9957
 *u
 */

public class MySkipList<T extends Comparable<T>> {

    private int maxLevel;
    private int size;
    private Node<T> head, tail;

    public MySkipList(int maxLevel) {
        this.maxLevel = maxLevel;
        this.head = null;
        tail = head;
    }

    public boolean add(T data) {
        return contains(data) && addLast(data);
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


    public int getSize() {return size;}
    public Node<T> getHead(){ return head; }
    public Node<T> getTail() { return tail; }

    private Node<T> find(T data) {
        return null;
    }

    private boolean addLast(T data) {
        return false;
    }

    protected int randInt() {
        return 0;
    }

    private class Node<T> {
        T data;
        List<T> nextNodes = new LinkedList<>();

        public Node(T data, int level) {}

    }

}

