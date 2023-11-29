import java.util.LinkedList;
import java.util.Stack;

public class Iterative {
    public static void main(String[] args) {
        int vertices = 6;
        LinkedList<Integer>[] adjacencyList = new LinkedList[vertices];

        for (int i = 0; i < vertices; ++i)
            adjacencyList[i] = new LinkedList();

        // Add edges to the graph
        adjacencyList[0].add(1);
        adjacencyList[0].add(2);
        adjacencyList[1].add(3);
        adjacencyList[1].add(4);
        adjacencyList[2].add(4);
        adjacencyList[3].add(4);
        adjacencyList[3].add(5);
        adjacencyList[4].add(5);

        int maxDepth = 3; // Set the maximum depth limit

        // Perform Iterative Deepening Search starting from vertex 0
        for (int depthLimit = 0; depthLimit <= maxDepth; depthLimit++) {
            System.out.print("Depth-Limited Search (Depth Limit: " + depthLimit + "): ");
            iterativeDeepeningSearch(adjacencyList, 0, depthLimit);
            System.out.println();
        }
    }

    static void iterativeDeepeningSearch(LinkedList<Integer>[] adjacencyList, int startVertex, int depthLimit) {
        boolean[] visited = new boolean[adjacencyList.length];
        Stack<Node> stack = new Stack<>();
        visited[startVertex] = true;
        stack.push(new Node(startVertex, 0));

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            int currentVertex = currentNode.vertex;
            int currentDepth = currentNode.depth;

            System.out.print(currentVertex + " ");

            // If the current depth is within the limit, continue exploring neighbors
            if (currentDepth < depthLimit) {
                for (Integer neighbor : adjacencyList[currentVertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        stack.push(new Node(neighbor, currentDepth + 1));
                    }
                }
            }
        }
    }

    static class Node {
        int vertex;
        int depth;

        public Node(int vertex, int depth) {
            this.vertex = vertex;
            this.depth = depth;
        }
    }
}
