package alda.graph;

public class Edge<T> {
    private Node<T> firstNode;
    private Node<T> secondNode;
    private int cost;

    public Edge(Node<T> firstNode, Node<T> secondNode, int cost) {
        this.firstNode = firstNode;
        this.secondNode = secondNode;
        this.cost = cost;
    }


    public boolean hasNode(T node) {
        if (node == firstNode.getData() || node.equals(firstNode.getData())) {
            return true;
        }
        if (node == secondNode.getData() || node.equals(secondNode.getData())) {
            return true;
        }
        return false;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }
}
