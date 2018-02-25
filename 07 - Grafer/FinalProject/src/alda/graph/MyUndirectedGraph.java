package alda.graph;

import java.util.*;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {
    private Map<T, Node<T>> nodes = new HashMap<>();
    private List<Edge<T>> edges = new ArrayList<>();

    @Override
    public int getNumberOfNodes() {
        return nodes.size();
    }

    @Override
    public int getNumberOfEdges() {
        return edges.size();
    }

    @Override
    public boolean add(T newNode) {
        if (nodes.containsKey(newNode)) {
            return false;
        }
        Node<T> node = new Node<>(newNode);
        nodes.put(node.data, node);
        return true;
    }

    @Override
    public boolean connect(T node1, T node2, int cost) {
        if (!nodes.containsKey(node1) || !nodes.containsKey(node2)) {
            return false;
        }
        if (cost < 1) {
            return false;
        }
        if (node1 != null && node2 != null) {
            if (isConnected(node1, node2)) {
                for (Edge<T> edge: edges) {
                    if ((edge.first.data == node1 && edge.second.data.equals(node2)) || (edge.first.data.equals(node2) && edge.second.data.equals(node1))) {
                        edge.cost = cost;
                        return true;
                    }
                }

            } else {
                Edge<T> e = new Edge<>(nodes.get(node1), nodes.get(node2), cost);
                edges.add(e);
                nodes.get(node1).neighbours.add(nodes.get(node2));
                nodes.get(node2).neighbours.add(nodes.get(node1));
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isConnected(T node1, T node2) {
        if (!nodes.containsKey(node1) || !nodes.containsKey(node2)) {
            return false;
        }
        if (nodes.get(node1).neighbours.contains(nodes.get(node2)) && nodes.get(node2).neighbours.contains(nodes.get(node1))) {
            return true;
        }
        return false;
    }

    @Override
    public int getCost(T node1, T node2) {
        for (Edge<T> edge: edges) {
            if ((edge.first.data == node1 && edge.second.data.equals(node2)) || (edge.first.data.equals(node2) && edge.second.data.equals(node1))) {
                return edge.cost;
            }

        }
        return -1;
    }

    @Override
    public List<T> depthFirstSearch(T start, T end) {
        resetNodesStatus();
        if (!nodes.containsKey(start) && !nodes.containsKey(end)){
            return null;
        }

        Stack<T> stack = new Stack<>();
        LinkedList<T> list = new LinkedList<>();
        stack.push(start);
        T current = start;
        nodes.get(start).visited = true;

        if(start.equals(end)) {
            list.addFirst(stack.pop());
            return list;
        }

        while(!stack.isEmpty()) {
            if(neigboursIsVisited(stack.peek()) && !stack.peek().equals(end)) {
                stack.pop();
            } else {
                for (Node<T> n: nodes.get(current).neighbours) {
                    if(!n.visited && isConnected(n.data, current)) {
                        n.visited = true;
                        stack.push(n.data);
                    }
                    current = stack.peek();
                }
            }
            if (stack.peek().equals(end)) {
                break;
            }
        }

        while(!stack.isEmpty()) {
            list.addFirst(stack.pop());
        }
        return list;
    }

    private boolean neigboursIsVisited(T t) { {
        for (Node<T> n: nodes.get(t).neighbours) {
            if (!n.visited) {
                return false;
            }
        }
        return true;
    }

    }

    private void resetNodesStatus() {
        for (Node<T> node: nodes.values()) {
            node.visited = false;
        }
    }

    @Override
    public List<T> breadthFirstSearch(T start, T end) {
        resetNodesStatus();

        if (!nodes.containsKey(start) && !nodes.containsKey(end)) {
            return null;
        }

        LinkedList<T> queue = new LinkedList<>();
        LinkedList<T> list = new LinkedList<>();
        queue.addLast(start);
        nodes.get(start).visited = true;

        if (start.equals(end)) {
            list.addFirst(queue.poll());
            return list;
        }

        return null;
    }

    @Override
    public UndirectedGraph<T> minimumSpanningTree() {
        return null;
    }

    private static class Edge<T> {
        Node<T> first, second;
        int cost;

        public Edge(Node<T> first, Node<T> second, int cost) {
            this.first = first;
            this.second = second;
            this.cost = cost;
        }

    }

    private static class Node<T> {
        T data;
        boolean visited;
        Set<Node<T>> neighbours = new HashSet<>();

        public Node(T data) {
            this.data = data;
        }

        public String toString() {
            return (String) data;
        }
    }
}
