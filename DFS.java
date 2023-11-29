zimport java.util.LinkedList;
import java.util.Stack;

public class DFS {
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

        // Perform DFS starting from vertex 0
        boolean[] visited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();

        // Mark the starting vertex as visited and push it to the stack
        int startVertex = 0;
        visited[startVertex] = true;
        stack.push(startVertex);

        // DFS traversal
        System.out.print("Depth-First Traversal: ");
        while (!stack.isEmpty()) {
            startVertex = stack.pop();
            System.out.print(startVertex + " ");

            // Get all adjacent vertices of the popped vertex
            // If an adjacent vertex has not been visited, mark it visited and push it to the stack
            for (Integer neighbor : adjacencyList[startVertex]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    stack.push(neighbor);
                }
            }
        }
    }
}

