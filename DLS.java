import java.util.LinkedList;
import java.util.Stack;

public class DLS {
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

        int depthLimit = 2; // Set the depth limit

        // Perform Depth-Limited Search starting from vertex 0
        boolean[] visited = new boolean[vertices];
        Stack<Node> stack = new Stack<>();

        // Mark the starting vertex as visited and push it to the stack with depth 0
        int startVertex = 0;
        visited[startVertex] = true;
        stack.push(new Node(startVertex, 0));

        // Depth-Limited Search traversal
        System.out.print("Depth-Limited Search (Depth Limit: " + depthLimit + "): ");
        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            int currentVertex = currentNode.vertex;
            int currentDepth = currentNode.depth;

            System.out.print(currentVertex + " ");

            // If the current depth is within the limit, continue exploring neighbors
            if (currentDepth < depthLimit) {
                // Get all adjacent vertices of the popped vertex
                // If an adjacent vertex has not been visited, mark it visited and push it to the stack with increased depth
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

