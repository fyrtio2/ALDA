package alda.linear;

/**
 *  Emil Rosell      - emro9957@student.su.se
 *  Oscar Törqnuist  - osta3589@student.su.se
 */

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class MyALDAList<E> implements ALDAList<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;


    public void add(E element) {
        if (head == null) {
            head = new Node<>(element);
            tail = head;
            size++;

        } else {
            tail.next = new Node<E>(element);
            tail = tail.next;
            size++;
        }
    }

    public void add(int index, E element) {
        if (head == null && size == 0 && index == 0) {
            head = new Node<>(element);
            tail = head;
            size++;
        } else if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        } else if (index == 0 && size > 0) {
            Node<E> current = head;
            Node<E> newNode = new Node<>(element);
            newNode.next = current;
            head = newNode;
            size++;
        } else if (index == size) {
            Node<E> newNode = new Node<>(element);
            tail.next = newNode;
            tail = newNode;
            size++;


        } else {
            Node<E> current = head;
            int nodeCount = 0;

            while (current != null) {
                if (nodeCount == index - 1) {
                    Node<E> newNode = new Node<>(element);
                    newNode.next = current.next;
                    current.next = newNode;
                    size++;
                    return;
                }
                current = current.next;
                nodeCount++;
            }

        }
    }

    public E remove(int index) {
        Node<E> temp = head;
        Node<E> prev;
        int count = 0;
        if (size == 0 || index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = temp.next;
            size--;
            return temp.data;
        }
        while (temp != null) {
            if (count == index - 1) {
                prev = temp;
                temp = prev.next;
                prev.next = temp.next;
                if (index + 1 == size) {
                    tail = prev;
                }
                size--;
                return temp.data;
            }
            temp = temp.next;
            count++;
        }


        return temp.data;
    }

    public boolean remove(E element) {
        if (size == 0) {
            return false;
        }
        Node<E> current;
        Node<E> prev = null;
        for (current = head; current != null; current = current.next) {
            if (current.data == element || current.data.equals(element)) {
                if (prev == null) {
                    current = current.next;
                    head = current;
                    size--;
                    return true;
                } else if (current.next == null) {
                    prev.next = null;
                    tail = prev;
                    size--;
                    return true;
                } else {
                    prev.next = current.next;
                    size--;
                    return true;
                }
            }
            prev = current;
        }

        return false;
    }

    public E get(int index) {
        if (index > size - 1 || size == 0 || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Node<E> current = head;
        int nodeIndex = 0;

        while (current != null) {
            if (nodeIndex == index) {
                return current.data;
            }

            current = current.next;
            nodeIndex++;
        }
        return null;

    }

    public boolean contains(E element) {
        Node<E> current = head;

        while (current != null) {
            if (current.data == element || current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(E element) {
        int count = 0;

        for (Node<E> temp = head; temp != null; temp = temp.next, count++) {
            if (temp.data == element || temp.data.equals(element)) {
                return count;
            }
        }

        return -1;
    }

    public void clear() {
        head = null;
        tail = null;
        size = 0;

    }

    public int size() {
        return size;
    }

    public Iterator<E> iterator() {
        return new MyALDAListIterator();
    }

    public String toString() {
        String[] temp = new String[size];
        Node<E> current = head;
        int count = 0;
        while (current != null) {
            temp[count] = (String) current.data;
            current = current.next;
            count++;

        }

        return Arrays.toString(temp);
    }

    private static class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    private class MyALDAListIterator implements Iterator<E> {
        Node<E> current = head;
        Node<E> prev;
        boolean remove = false;


        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E next = current.data;
            prev = current;
            current = current.next;
            remove = true;
            return next;
        }

        @Override
        public void remove() {
            if (!remove) {
                throw new IllegalStateException();
            }
            MyALDAList.this.remove(prev.data);
            remove = false;
        }
    }
}
