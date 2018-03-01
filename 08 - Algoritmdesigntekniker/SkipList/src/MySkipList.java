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
        if (contains(data))
            return false;

        int lvl = generateLvl();
        Node<T> newNode = new Node<T>(data, lvl);



        return false;
    }

    public boolean contains(T data) {
        return find(data) != null;
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



    protected int generateLvl() {
        Random rand = new Random();
        int lvl = 1;
        while(rand.nextBoolean() && lvl <= MAXLVL) {
            lvl++;
        }
        return lvl;
    }

    private static class Node<T> {
        T data;
        int level;
        Node<T> up,
                down,
                next,
                previous;

        public Node(T data, int level) {}

        public String toString() {
            return "Node: " + data;
        }

    }



}

