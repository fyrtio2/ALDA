import java.util.ArrayList;
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
    private static final Node<T> HEAD = "_HEAD";
    private static final Node<T> TAIL = "_TAIL";

    public MySkipList(int maxLevel) {
        this.MAXLVL = maxLevel;


    }

    public boolean insert(T data) {
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
        ArrayList<Node<T>> nextNodes;
        ArrayList<Node<T>> previousNodes;

        public Node(T data, int level) {
            this.data = data;
            this.level = level;
        }

        public String toString() {
            return "Node: " + data;
        }

    }



}

