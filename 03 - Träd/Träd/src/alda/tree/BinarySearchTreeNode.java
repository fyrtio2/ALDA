package alda.tree;

/**
 * Detta är den enda av de tre klasserna ni ska göra några ändringar i. (Om ni
 * inte vill lägga till fler testfall.) De ändringar som är tillåtna är dock
 * begränsade av följande:
 * <ul>
 * <li>Ni får INTE lägga till några fler instansvariabler.
 * <li>Ni får INTE lägga till några statiska variabler.
 * <li>Ni får INTE använda några loopar någonstans.
 * <li>Ni FÅR lägga till fler metoder, dessa ska då vara privata.
 * </ul>
 *
 * @param <T>
 * @author henrikbe
 */
@SuppressWarnings("unused") // Denna rad ska plockas bort. Den finns här
// tillfälligt för att vi inte ska tro att det är
// fel i koden. Varningar ska normalt inte döljas på
// detta sätt, de är (oftast) fel som ska fixas.
public class BinarySearchTreeNode<T extends Comparable<T>> {

    private T data;
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;

    public BinarySearchTreeNode(T data) {
        this.data = data;
    }

    public boolean add(T data) {
        if (data != null && data.compareTo(this.data) > 0) {
            if (right == null) {
            right = new BinarySearchTreeNode<>(data);
            return true;
            }
            return right.add(data);
        } else if (data != null && data.compareTo(this.data) < 0) {
            if (left == null) {
                left = new BinarySearchTreeNode<>(data);
                return true;
            }
            return left.add(data);
        }

        return false;
    }

    private T findMin() {
        return null;
    }

    public BinarySearchTreeNode<T> remove(T data) {
        return null;
    }

    public boolean contains(T data) {
       if (data == null) {
           return false;
       }

       if (data.compareTo(this.data) == 0) {
           return true;
       } else if (right != null && data.compareTo(this.data) > 0) {
           return right.contains(data);
       } else if (left != null && data.compareTo(this.data) < 0) {
           return left.contains(data);
       }
       return false;
    }

    public int size() {
        return size(this);
    }

    private int size(BinarySearchTreeNode<T> n) {
        if (n == null) {
            return 0;
        } else {
            return size(n.left) + size(n.right) + 1;
        }
    }
    public int depth() {
        return depth(this) -1;
    }

    private int depth(BinarySearchTreeNode<T> n) {
        if (n == null) {
            return 0;

        } else {
            return Math.max(depth(n.left), depth(n.right)) + 1;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        toString(str,this);
        return str.toString();
    }

    private String toString(StringBuilder str, BinarySearchTreeNode<T> n) {
        if (n == null) {
            return "";
        }
        str.append(toString(str, n.left));
        str.append(n.data);
        str.append(toString(str, n.right));
        return "";


    }
}