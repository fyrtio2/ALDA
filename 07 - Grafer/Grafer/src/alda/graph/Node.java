package alda.graph;

public class Node<T> {
    private T data;
    boolean visited = false;

    public Node(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public boolean isVisited() {
        return visited;
    }
}
