package codeVita;

import java.util.*;

public class R2F {

    static int R, C, M, N, K;
    static char[][] grid;
    static Map<Character, Integer> pointsMap;
    static int totalBonusPoints = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt()) return;

        R = sc.nextInt();
        C = sc.nextInt();
        M = sc.nextInt();

        grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(grid[i], '.');
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < C; j++) {
                if (sc.hasNext()) {
                    String s = sc.next();
                    grid[i][j] = s.charAt(0);
                }
            }
        }

        // Robust line reading to skip empty lines between grid and configuration
        String colorLine = "";
        while (sc.hasNextLine()) {
            colorLine = sc.nextLine().trim();
            if (!colorLine.isEmpty()) break;
        }

        String pointLine = "";
        while (sc.hasNextLine()) {
            pointLine = sc.nextLine().trim();
            if (!pointLine.isEmpty()) break;
        }

        String[] colorTokens = colorLine.split("\\s+");
        String[] pointTokens = pointLine.split("\\s+");

        pointsMap = new HashMap<>();
        for(int i = 0; i < colorTokens.length; i++) {
            if (i < pointTokens.length) {
                pointsMap.put(colorTokens[i].charAt(0), Integer.parseInt(pointTokens[i]));
            }
        }

        if (sc.hasNextInt()) N = sc.nextInt();
        if (sc.hasNextInt()) K = sc.nextInt();

        simulate();
        System.out.println(totalBonusPoints);
    }

    static void simulate() {
        int currR = R - 1;
        int currC = N;
        int dr = -1;
        int dc = -1;

        int bounces = 0;

        while (bounces < K && hasBubbles()) {
            int nextR = currR + dr;
            int nextC = currC + dc;
            boolean wallHit = false;

            if (nextC < 0 || nextC >= C) {
                dc = -dc;
                nextC = currC;
                wallHit = true;
            }

            if (nextR < 0) {
                dr = -dr;
                nextR = currR;
                wallHit = true;
            }

            if (wallHit) {
                currR = nextR;
                currC = nextC;
                continue;
            }

            boolean hitV = isValid(nextR, currC) && grid[nextR][currC] != '.';
            boolean hitH = isValid(currR, nextC) && grid[currR][nextC] != '.';
            boolean hitD = isValid(nextR, nextC) && grid[nextR][nextC] != '.';

            if (!hitV && !hitH && !hitD) {
                currR = nextR;
                currC = nextC;
            } else {
                bounces++;

                if (hitV && hitH) {
                    dr = -dr;
                    dc = -dc;
                    burst(nextR, currC);
                    burst(currR, nextC);
                } else if (hitV) {
                    dr = -dr;
                    burst(nextR, currC);
                } else if (hitH) {
                    dc = -dc;
                    burst(currR, nextC);
                } else {
                    dr = -dr;
                    dc = -dc;
                    burst(nextR, nextC);
                }

                processFallingBubbles();
            }
        }
    }

    static boolean isValid(int r, int c) {
        return r >= 0 && r < R && c >= 0 && c < C;
    }

    static boolean hasBubbles() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != '.') return true;
            }
        }
        return false;
    }

    static void burst(int r, int c) {
        if (!isValid(r, c) || grid[r][c] == '.') return;

        char color = grid[r][c];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r, c});
        grid[r][c] = '.';

        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!q.isEmpty()) {
            int[] curr = q.poll();

            for (int[] d : dirs) {
                int nr = curr[0] + d[0];
                int nc = curr[1] + d[1];

                if (isValid(nr, nc) && grid[nr][nc] == color) {
                    grid[nr][nc] = '.';
                    q.add(new int[]{nr, nc});
                }
            }
        }
    }

    static void processFallingBubbles() {
        boolean[][] stable = new boolean[R][C];
        Queue<int[]> q = new LinkedList<>();

        for (int c = 0; c < C; c++) {
            if (grid[0][c] != '.') {
                stable[0][c] = true;
                q.add(new int[]{0, c});
            }
        }

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            char color = grid[r][c];

            if (isValid(r + 1, c) && grid[r + 1][c] != '.' && !stable[r + 1][c]) {
                stable[r + 1][c] = true;
                q.add(new int[]{r + 1, c});
            }

            if (isValid(r, c - 1) && grid[r][c - 1] != '.' && !stable[r][c - 1]) {
                if (grid[r][c - 1] == color) {
                    stable[r][c - 1] = true;
                    q.add(new int[]{r, c - 1});
                }
            }

            if (isValid(r, c + 1) && grid[r][c + 1] != '.' && !stable[r][c + 1]) {
                if (grid[r][c + 1] == color) {
                    stable[r][c + 1] = true;
                    q.add(new int[]{r, c + 1});
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (grid[i][j] != '.' && !stable[i][j]) {
                    if (pointsMap.containsKey(grid[i][j])) {
                        totalBonusPoints += pointsMap.get(grid[i][j]);
                    }
                    grid[i][j] = '.';
                }
            }
        }
    }
}