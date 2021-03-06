package alda.graph;


import java.util.*;

public class MyUndirectedGraph<T> implements UndirectedGraph<T> {

    private Map<T, Node<T>> nodes = new HashMap<>();
    private List<Edge<T>> edges = new ArrayList<>();

    public int getNumberOfNodes() {
        return nodes.size();
    }

    public int getNumberOfEdges() {
        return edges.size();
    }


    public boolean add(T newNode) {
        if (nodes.containsKey(newNode)) {
            return false;
        }
        Node<T> node = new Node<>(newNode);
        nodes.put(newNode, node);
        return true;
    }

    public boolean connect(T node1, T node2, int cost) {
        if (cost <= 0) {
            return false;
        }
        if (!nodes.containsKey(node1) || !nodes.containsKey(node2)) {
            return false;
        }
        try {
            getEdge(node1, node2).setCost(cost);
            return true;
        } catch (NullPointerException e) {

            Edge<T> newEdge = new Edge<>(nodes.get(node1), nodes.get(node2), cost);
            nodes.get(node1).addNeighbour(nodes.get(node2));
            nodes.get(node2).addNeighbour(nodes.get(node1));
            edges.add(newEdge);
            return true;
        }


    }

    public boolean isConnected(T node1, T node2) {
        if (!(nodes.containsKey(node1) || nodes.containsKey(node2))) {
            return false;
        }
        if (getEdge(node1, node2) != null) {
            return true;
        }
        return false;
    }

    private Edge<T> getEdge(T node1, T node2) {
        for (Edge<T> edge : edges) {
            if ((edge.hasNode(node1) && edge.hasNode(node2))) {
                return edge;
            }
        }
        return null; //Returnerar null om det inte finns någon båge mellan de två noderna.
    }

    public int getCost(T node1, T node2) {
        try{
            return getEdge(node1, node2).getCost();
        } catch (NullPointerException n) {
            return -1;
        }
    }

    public List<T> depthFirstSearch(T start, T end) {

        if (!nodes.containsKey(start) || !nodes.containsKey(end)) {
            return new ArrayList<>();
        }
        unvisitNodes();

        Node<T> currentNode = nodes.get(start);
        Stack<Node<T>> stack = new Stack<>();
        List<T> path = new LinkedList<>();
        stack.push(currentNode);

        nodes.get(start).setVisited(true);



        while(!stack.isEmpty()) {
            if (currentNode.getData().equals(end)) {
                for (int i = stack.size(); i > 0; i--) {
                    path.add(0, stack.pop().getData());
                }
                return path;
            }

            Node<T> nextNode = getNextNeighbour(currentNode);
            if (nextNode != null) {
                currentNode = nextNode;
                stack.push(currentNode);
            } else {
                currentNode = stack.pop();
            }



            /*
            Node<T> next = getNextNeighbour(currentNode);
            if (next != null) {
                stack.push(next);
                currentNode = next;
            } else {
                currentNode = stack.pop();
            }

            System.out.println(stack);
*/
        }
        return null;
    }

    private Node<T> getNextNeighbour(Node<T> node) {
        for (Node<T> n: node.getNeighbours()) {
            if (!n.isVisited()) {
                n.setVisited(true);
                return n;
            }
        }
        return null;
    }


    private void unvisitNodes() {
        for (T t: nodes.keySet()) {
            nodes.get(t).setVisited(false);
        }
    }


    public List<T> breadthFirstSearch(T start, T end) {
        if (!nodes.containsKey(start) || !nodes.containsKey(end)) {
            return new ArrayList<>();
        }
        unvisitNodes();

        LinkedList<T> queue = new LinkedList<>();
        LinkedList<T> result = new LinkedList<>();
        T currentNode = start;

        queue.add(start);

        nodes.get(start).setVisited(true);

        while (!queue.isEmpty()){

            start = queue.poll();
            //for(T neighbourNodes : nodes.get(start)........

        }

        return result;
    }


    public UndirectedGraph<T> minimumSpanningTree() {
        return null;
    }
}
