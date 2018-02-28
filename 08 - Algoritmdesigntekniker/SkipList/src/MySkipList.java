import java.util.LinkedList;
import java.util.List;

/**
 *@Author Oscar Törnquist   -osta3589
 *@Author Emil Rosell       -emro9957
 */

public class MySkipList<T extends Comparable<T>> {

    private class Node<E> {
        private E data;
        private List<E> nextNodes = new LinkedList<>();

    }

}

