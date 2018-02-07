// Klassen i denna fil måste döpas om till DHeap för att testerna ska fungera. 
package alda.heap;

/**
 *
 * DHeap
 * @author Oscar Törnquist  - osta3589
 * @author Emil Rosell      - emro9957
 */

//DHeap class
//
//CONSTRUCTION: with optional capacity (that defaults to 100)
//            or an array containing initial items
//
//******************PUBLIC OPERATIONS*********************
//void insert( x )       --> Insert x
//Comparable deleteMin( )--> Return and remove smallest item
//Comparable findMin( )  --> Return smallest item
//boolean isEmpty( )     --> Return true if empty; else false
//void makeEmpty( )      --> Remove all items
//******************E
// RRORS********************************
//Throws UnderflowException as appropriate

import java.util.Arrays;

/**
 * Implements a binary heap.
 * Note that all "matching" is based on the compareTo method.
 *
 * @author Mark Allen Weiss
 */
public class DHeap<AnyType extends Comparable<? super AnyType>> {
    private static final int DEFAULT_CAPACITY = 10;
    private static final int DEFAULT_NUMBER_OF_CHILDRENS = 2;
    private int currentSize;      // Number of elements in heap
    private AnyType[] array; // The heap array
    private int noOfChildren;

    /**
     * Construct the binary heap.
     */
    public DHeap() {
        this(DEFAULT_NUMBER_OF_CHILDRENS);
    }


    /**
     * Returnerar IllegalArgumentException om children < 2.
     * Annars sätts storleken till 0 och noOfChildren till argumentet children i konstruktorn
     */
    public DHeap(int children) {
        if (children < DEFAULT_NUMBER_OF_CHILDRENS) {
            throw new IllegalArgumentException("heap to small");
        }
        noOfChildren = children;
        currentSize = 0;
        array = (AnyType[]) new Comparable[DEFAULT_CAPACITY + 1];
    }


    /**
     * Insert into the priority queue, maintaining heap order.
     * Duplicates are allowed.
     *
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        if (currentSize == array.length - 1)
            enlargeArray(array.length * 2 + 1);
        if (currentSize == 0) {
            array[1] = x;
            currentSize++;
        } else {
            // Percolate up
            int hole = ++currentSize;
            for (;x.compareTo(array[parentIndex(hole)]) < 0; hole = parentIndex(hole)) {
                array[hole] = array[parentIndex(hole)];
                if (parentIndex(hole) == 1) {
                    array[1] = x;
                    return;
                }
            }
            array[hole] = x;
        }
    }

    private void enlargeArray(int newSize) {
        AnyType[] old = array;
        array = (AnyType[]) new Comparable[newSize];
        for (int i = 0; i < old.length; i++)
            array[i] = old[i];
    }

    /**
     * Find the smallest item in the priority queue.
     *
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType findMin() {
        if (isEmpty())
            throw new UnderflowException();
        return array[1];
    }

    /**
     * Remove the smallest item from the priority queue.
     *
     * @return the smallest item, or throw an UnderflowException if empty.
     */
    public AnyType deleteMin() {
        if (isEmpty())
            throw new UnderflowException();

        AnyType minItem = findMin();
        array[1] = array[currentSize--];
        percolateDown(1);

        return minItem;
    }

    /**
     * Establish heap order property from an arbitrary
     * arrangement of items. Runs in linear time.
     */
    private void buildHeap() {
        for (int i = currentSize / 2; i > 0; i--)
            percolateDown(i);
    }

    /**
     * Test if the priority queue is logically empty.
     *
     * @return true if empty, false otherwise.
     */
    public boolean isEmpty() {
        return currentSize == 0;
    }

    /**
     * Make the priority queue logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
        array =  (AnyType[]) new Comparable[DEFAULT_CAPACITY + 1];
    }

    /**
     * Internal method to percolate down in the heap.
     *
     * @param hole the index at which the percolate begins.
     */
    private void percolateDown(int hole) {
        int child;
        AnyType tmp = array[hole];

        for (; firstChildIndex(hole) <= currentSize; hole = child) {


            child = indexOfSmallestChild(hole);

            if (array[child].compareTo(tmp) < 0)
                array[hole] = array[child];
            else
                break;
        }
        array[hole] = tmp;
    }

    private int indexOfSmallestChild(int hole) {
        int firstChild = firstChildIndex(hole);
        int limit = firstChild + noOfChildren -1;
        int min = firstChild;

        if (limit > currentSize)
            limit = currentSize;

        for (int i = firstChild; i < limit; i++) {

            if (array[i + 1].compareTo(array[min]) < 0) {
                min = i + 1;
            }
        }
        return min;

    }



    int parentIndex(int i) {
        if (i < 2) {
            throw new IllegalArgumentException();
        }
        //return (i + noOfChildren -2) / noOfChildren;
        return (i - 2) / noOfChildren + 1;
    }

    int firstChildIndex(int i) {
        if (i < 1) {
            throw new IllegalArgumentException();
        }
        //return (i -1) * noOfChildren + 2;
        return i * noOfChildren - (noOfChildren - 2);

    }

    public int size() {
        return currentSize;
    }
    public AnyType get(int index){
        return array[index];
    }

    public static void main(String[] args) {
        DHeap<Integer> heap = new DHeap<>(3);
        heap.insert(10);
      //  System.out.println(Arrays.toString(heap.array));
        heap.insert(20);
        //System.out.println(Arrays.toString(heap.array));
        heap.insert(15);
        //System.out.println(Arrays.toString(heap.array));
        heap.insert(59);
        //System.out.println(Arrays.toString(heap.array));
        heap.insert(13);
        //System.out.println(Arrays.toString(heap.array));
        heap.deleteMin();
        //System.out.println(Arrays.toString(heap.array));
        heap.deleteMin();
        //System.out.println(Arrays.toString(heap.array));
    }
}