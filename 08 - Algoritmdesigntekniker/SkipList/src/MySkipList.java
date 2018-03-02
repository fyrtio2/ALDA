import java.util.ArrayList;
import java.util.Random;

/**
 * Implementation av en generisk skiplist i Java med funktionaliteten att lägga till, ta bort och söka efter objekt i en skiplist.
 * Listan tillåter ej dubbleter.
 *
 *@Author Oscar Törnquist   -osta3589
 *@Author Emil Rosell       -emro9957
 *
 */

public class MySkipList<T extends Comparable<T>> {

    private int MAXLVL;
    private int size = 0;
    private Node<T> head, tail;

    public MySkipList(int maxLevel) {
        this.MAXLVL = maxLevel;
    }

    public boolean insert(T data) {
        if (contains(data))
            return false;

        /*
        Om storleken på listan är mindre än 2 så ska det första elementet som sätts in sättas till head,
        om head inte är null ska elementet som sätts in sättas till tail och länkas ihop med head.
        Båda skall vara MAXLVL för att garantera att första och sista elementet är  största storleken.
         */

        int lvl = generateLvl();
        Node<T> newNode = new Node<>(data, lvl);



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

