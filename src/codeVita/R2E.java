package codeVita;
import java.util.*;

public class R2E {

    static int N, M;
    static int[][] grid;
    static int target;
    static Map<Integer, Integer> pieceValues;
    static Map<Integer, List<int[]>> pieceCells;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            N = sc.nextInt();
            M = sc.nextInt();
        } else {
            return;
        }

        grid = new int[N][M];
        pieceValues = new HashMap<>();
        pieceCells = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
                if (!pieceCells.containsKey(grid[i][j])) {
                    pieceCells.put(grid[i][j], new ArrayList<>());
                    pieceValues.put(grid[i][j], grid[i][j]);
                }
                pieceCells.get(grid[i][j]).add(new int[]{i, j});
            }
        }
        target = sc.nextInt();

        long minCost = Long.MAX_VALUE;
        String bestSide = "";

        long costDown = calculateCost("down");
        if (costDown < minCost) {
            minCost = costDown;
            bestSide = "down";
        }

        long costUp = calculateCost("up");
        if (costUp < minCost) {
            minCost = costUp;
            bestSide = "up";
        }

        long costLeft = calculateCost("left");
        if (costLeft < minCost) {
            minCost = costLeft;
            bestSide = "left";
        }

        long costRight = calculateCost("right");
        if (costRight < minCost) {
            minCost = costRight;
            bestSide = "right";
        }

        System.out.println(minCost + " via " + bestSide);
    }

    static long calculateCost(String direction) {
        Set<Integer> removed = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        removed.add(target);

        addImmediateBlockers(target, direction, removed, queue);

        long currentCost = 0;

        while (!queue.isEmpty()) {
            int currentPiece = queue.poll();

            currentCost += pieceValues.get(currentPiece);

            addImmediateBlockers(currentPiece, direction, removed, queue);

            if (direction.equals("left") || direction.equals("right")) {
                addGravityBlockers(currentPiece, removed, queue);
            }
        }

        return currentCost;
    }

    static void addImmediateBlockers(int pieceId, String direction, Set<Integer> removed, Queue<Integer> queue) {
        List<int[]> cells = pieceCells.get(pieceId);
        if (cells == null) return;

        for (int[] cell : cells) {
            int r = cell[0];
            int c = cell[1];
            int nr = -1, nc = -1;

            if (direction.equals("up")) {
                nr = r - 1; nc = c;
            } else if (direction.equals("down")) {
                nr = r + 1; nc = c;
            } else if (direction.equals("left")) {
                nr = r; nc = c - 1;
            } else if (direction.equals("right")) {
                nr = r; nc = c + 1;
            }

            if (isValid(nr, nc)) {
                int neighborId = grid[nr][nc];
                if (neighborId != pieceId && !removed.contains(neighborId)) {
                    removed.add(neighborId);
                    queue.add(neighborId);
                }
            }
        }
    }

    static void addGravityBlockers(int pieceId, Set<Integer> removed, Queue<Integer> queue) {
        List<int[]> cells = pieceCells.get(pieceId);
        if (cells == null) return;

        for (int[] cell : cells) {
            int r = cell[0];
            int c = cell[1];
            int nr = r - 1;
            int nc = c;

            if (isValid(nr, nc)) {
                int neighborId = grid[nr][nc];
                if (neighborId != pieceId && !removed.contains(neighborId)) {
                    removed.add(neighborId);
                    queue.add(neighborId);
                }
            }
        }
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < M;
    }
}