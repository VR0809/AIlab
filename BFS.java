import java.util.*;

public class BFS {
    public static void main(String[] args) {
        int n = 8; // Change this to the desired board size
        class NQueens {
            static class State {
                int[] queens;
                int row;

                public State(int n) {
                    queens = new int[n];
                    row = 0;
                }

                public State(State prevState, int col) {
                    queens = Arrays.copyOf(prevState.queens, prevState.queens.length);
                    queens[prevState.row] = col;
                    row = prevState.row + 1;
                }

                public boolean isValid(int col) {
                    for (int i = 0; i < row; i++) {
                        if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                            return false;
                        }
                    }
                    return true;
                }

                public boolean isComplete() {
                    return row == queens.length;
                }
            }

            static List<int[]> solveNQueens(int n) {
                List<int[]> result = new ArrayList<>();
                Queue<State> queue = new LinkedList<>();
                queue.offer(new State(n));

                while (!queue.isEmpty()) {
                    State currentState = queue.poll();

                    if (currentState.isComplete()) {
                        result.add(currentState.queens.clone());
                    } else {
                        for (int col = 0; col < n; col++) {
                            if (currentState.isValid(col)) {
                                queue.offer(new State(currentState, col));
                            }
                        }
                    }
                }

                return result;
            }

            List<int[]> solutions = solveNQueens(n);

        for(
            int[] solution :solutions)

            {
                System.out.println(Arrays.toString(solution));
            }
        }
    }
}
