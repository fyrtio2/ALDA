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


/**
 * Klass som representerar en nod i ett binärt sökträd. Klassen använder sig av generiska typer.
 *
 * @param <T>
 * @author Emil Rosell      - emro9957
 * @author Oscar Törnquist  - osta3589
 */
public class BinarySearchTreeNode<T extends Comparable<T>> {

    private T data; //indatan
    private BinarySearchTreeNode<T> left;  // "next"
    private BinarySearchTreeNode<T> right;  // "next"

    public BinarySearchTreeNode(T data) {
        this.data = data;
    }


    /**
     * Metoden lägger till indatat i trädet som antingen ett höger eller vänsterbarn.
     *
     * @param data, indata som sparas i varje nod.
     * @return true om det läggs till en ny nod, annars false om indatans värde är lika mycket som den aktuell nod.
     */

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

    /**
     *
     * @return returnerar returvärdet från privat metod.
     */

    private T findMin() {
        return findMin(this);
    }

    /**
     * Jobbar sig nedåt till vänster i trädet via rekursiva anrop.
     *
     * @param n aktuell nod som skall jämföras.
     * @return det minsta värdet i trädet om indatan hittas, annars null om indatan är null eller inte finns.
     */

    private T findMin(BinarySearchTreeNode<T> n) {
        if(n == null)
            return null;
        else if(n.left == null)
            return n.data;
        return findMin(n.left);
    }

    public BinarySearchTreeNode<T> remove(T data) {
        return remove(this, data);

    }

    /**
     * Tar bort element ur trädet
     * @param n noden som jämförs
     * @param data värdet på elentet som ska tas bort
     * @return noden som tas bort. Returnerar null om noden inte finns seller om indatan är null.
     */

    private BinarySearchTreeNode<T> remove(BinarySearchTreeNode<T> n, T data) {
        if (n == null) {
            return null;
        }

        int compare = n.data.compareTo(data);

        if (compare > 0) {
            n.left = remove(n.left, data);
        } else if (compare < 0) {
            n.right = remove(n.right, data);
        } else if (n.left != null && n.right != null) {
            n.data = findMin(n.right);
            n.right = remove(n.right, n.data);
        } else {
            n = (n.left != null) ? n.left : n.right;
        }
        return n;
    }

    /**
     * kontroller om trädet innehåller ett viss data
     * @param data
     * @return true om indatan finns, annars false om den är null eller inte finns.
     */

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
        return str.toString().substring(0, str.length()-2);
    }

    private String toString(StringBuilder str, BinarySearchTreeNode<T> n) {
        if (n == null) {
            return "";
        }
        str.append(toString(str, n.left));
        str.append(n.data + ", ");
        str.append(toString(str, n.right));
        return "";


    }
}