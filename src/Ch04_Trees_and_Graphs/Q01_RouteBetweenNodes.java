package Ch04_Trees_and_Graphs;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q01_RouteBetweenNodes {
    public enum State {
        Unvisited, Visited, Visiting;
    }
    static class Node {
        private final Node[] adjacent;
        public int adjacentCount;
        private final String vertex;
        public State state;
        public Node(String vertex, int adjacentLength) {
            this.vertex = vertex;
            adjacentCount = 0;
            adjacent = new Node[adjacentLength];
            state = State.Unvisited;
        }

        public void addAdjacent(Node x) {
            if (adjacentCount < adjacent.length) {
                this.adjacent[adjacentCount] = x;
                adjacentCount++;
            } else {
                System.out.print("No more adjacent can be added");
            }
        }
        public Node[] getAdjacent() {
            return adjacent;
        }
        public String getVertex() {
            return vertex;
        }
    }
    static class Graph {
        public static int MAX_VERTICES = 6;
        private final Node[] vertices;
        public int count;
        public Graph() {
            vertices = new Node[MAX_VERTICES];
            count = 0;
        }

        public void addNode(Node x) {
            if (count < vertices.length) {
                vertices[count] = x;
                count++;
            } else {
                System.out.print("Graph full");
            }
        }

        public Node[] getNodes() {
            return vertices;
        }
    }

    public static void main(String[] a)
    {
        Graph g = createNewGraph();
        Node[] n = g.getNodes();
        Node start = n[3];
        Node end = n[5];
        System.out.println(search(g, start, end));
    }

    private static boolean search(Graph g, Node start, Node end) {
        Queue<Node> queue = new LinkedList<>();
        start.state = State.Visited;
        queue.add(start);

        while (!queue.isEmpty()){
            Node cur = queue.remove();
            if (cur == end){
                return true;
            }

            for ( Node n : cur.getAdjacent()){
                if (n.state == State.Unvisited){
                    n.state = State.Visited;
                    queue.add(n);
                }
            }
        }

        return false;
    }

    public static Graph createNewGraph()
    {
        Graph g = new Graph();
        Node[] temp = new Node[6];

        temp[0] = new Node("a", 3);
        temp[1] = new Node("b", 0);
        temp[2] = new Node("c", 0);
        temp[3] = new Node("d", 1);
        temp[4] = new Node("e", 1);
        temp[5] = new Node("f", 0);

        temp[0].addAdjacent(temp[1]);
        temp[0].addAdjacent(temp[2]);
        temp[0].addAdjacent(temp[3]);
        temp[3].addAdjacent(temp[4]);
        temp[4].addAdjacent(temp[5]);
        for (int i = 0; i < 6; i++) {
            g.addNode(temp[i]);
        }
        return g;
    }
}
