package alda.graph;

public class Edge<T> {
    private Node<T> first, second;
    private int cost;

    public Edge(Node<T> first, Node<T> second, int cost) {
        this.first = first;
        this.second = second;
        this.cost = cost;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public boolean hasNode(Node<T> node) {
        if (node.getData().equals(first.getData()) || node.getData().equals(second.getData())) {
            return true;
        }
        return false;
    }
}
