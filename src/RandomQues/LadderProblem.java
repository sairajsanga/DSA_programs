package RandomQues;

import java.util.*;

class LadderProblem {
    static class State {
        int x, y, steps;
        boolean isHorizontal;

        State(int x, int y, boolean isHorizontal, int steps) {
            this.x = x;
            this.y = y;
            this.isHorizontal = isHorizontal;
            this.steps = steps;
        }
    }

    public static int findMinSteps(char[][] grid, int m, int n) {
        int startX = -1, startY = -1, endX = -1, endY = -1;
        boolean isHorizontal = true;
        int ladderLength = 0;

        // Locate the ladder's starting position and determine its length
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'l') {
                    if (startX == -1) {
                        startX = i;
                        startY = j;
                    }
                    if (j + 1 < n && grid[i][j + 1] == 'l') {
                        isHorizontal = true;
                    }
                    ladderLength++;
                } else if (grid[i][j] == 'L') {
                    if (endX == -1) {
                        endX = i;
                        endY = j;
                    }
                }
            }
        }

        // BFS setup
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(startX, startY, isHorizontal, 0));
        Set<String> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            State current = queue.poll();
            int x = current.x, y = current.y, steps = current.steps;
            boolean horizontal = current.isHorizontal;

            // Check if we reached the destination
            if (isAtDestination(x, y, horizontal, endX, endY, ladderLength)) {
                return steps;
            }

            // Mark the current state as visited
            String stateKey = x + "," + y + "," + horizontal;
            if (visited.contains(stateKey)) continue;
            visited.add(stateKey);

            // Explore possible moves
            for (int[] dir : new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}) { // right, down, left, up
                int newX = x + dir[0], newY = y + dir[1];
                if (isValidMove(newX, newY, horizontal, ladderLength, grid)) {
                    queue.add(new State(newX, newY, horizontal, steps + 1));
                }
            }

            // Try rotating the ladder
            if (canRotate(x, y, horizontal, ladderLength, grid)) {
                queue.add(new State(x, y, !horizontal, steps + 1));
            }
        }

        // If no solution found
        return -1;
    }

    private static boolean isValidMove(int x, int y, boolean horizontal, int ladderLength, char[][] grid) {
        int m = grid.length, n = grid[0].length;

        for (int i = 0; i < ladderLength; i++) {
            int nx = horizontal ? x : x + i;
            int ny = horizontal ? y + i : y;

            if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] == 'B') {
                return false;
            }
        }
        return true;
    }

    private static boolean canRotate(int x, int y, boolean horizontal, int ladderLength, char[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (horizontal) {
            // Check if we can rotate to vertical
            for (int i = 0; i < ladderLength; i++) {
                int nx = x + i; // Vertical position (x changes)
                int ny = y;     // Same column (y stays constant)

                // Ensure the new cells are within bounds and empty
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 'E') {
                    return false;
                }
            }
        } else {
            // Check if we can rotate to horizontal
            for (int i = 0; i < ladderLength; i++) {
                int nx = x;     // Same row (x stays constant)
                int ny = y + i; // Horizontal position (y changes)

                // Ensure the new cells are within bounds and empty
                if (nx < 0 || ny < 0 || nx >= m || ny >= n || grid[nx][ny] != 'E') {
                    return false;
                }
            }
        }
        return true; // Rotation is possible
    }

    private static boolean isAtDestination(int x, int y, boolean horizontal, int endX, int endY, int ladderLength) {
        if (horizontal) {
            return x == endX && y == endY;
        } else {
            return x == endX && y == endY;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) {
            grid[i] = sc.next().toCharArray();
        }

        int result = findMinSteps(grid, m, n);
        System.out.println(result == -1 ? "Impossible" : result);
    }
}