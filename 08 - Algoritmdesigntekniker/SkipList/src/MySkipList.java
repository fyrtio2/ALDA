import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Implementation av skiplist i Java med funktionaliteten att lägga till, ta bort och söka efter objekt i en skiplist.
 * Listan tillåter ej dubbleter.
 *
 *@Author Oscar Törnquist   -osta3589
 *@Author Emil Rosell       -emro9957
 *
 */

public class MySkipList<T extends Comparable<T>> {

    private final int MAXLVL;
    private int size;
    private Node<T> head, tail;

    public MySkipList(int maxLevel) {
        this.MAXLVL = maxLevel;
        this.head = null;
        tail = head;
    }

    public boolean add(T data) {
        return !contains(data) && addLast(data);
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

    public T poll(T data) {
        return null;
    }


    public int getSize() { return size; }
    public Node<T> getHead(){ return head; }
    public Node<T> getTail() { return tail; }

    private T find(T data) {
        if (data == null)
            throw new IllegalArgumentException();
        return null;
    }

    private boolean addLast(T data) {
        return false;
    }

    protected int generateLvl() {
        Random rand = new Random();
        int lvl = 0;
        while(rand.nextBoolean() && lvl <= MAXLVL) {
            lvl++;
        }
        return lvl;
    }

    private static class Node<T> {
        T data;
        List<T> nextNodes = new LinkedList<>();

        public Node(T data) {}

        public String toString() {
            return "Node: " + data;
        }

    }



}

