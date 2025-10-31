package RandomQues;

import java.util.*;

public class LadderMover {
    static class State {
        int r, c;
        boolean horizontal;
       // State(int r, int c, boolean h) { r = this.r; c = this.c; horizontal = this.horizontal;}
        State(int r, int c, boolean horizontal) { this.r = r; this.c = c; this.horizontal = horizontal; }
        @Override
        public boolean equals(Object o) {
            if (!(o instanceof State)) return false;
            State s = (State) o;
            return r == s.r && c == s.c && horizontal == s.horizontal;
        }
        @Override
        public int hashCode() {
            return Objects.hash(r, c, horizontal);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt(), N = sc.nextInt();
        char[][] grid = new char[M][N];
        for (int i = 0; i < M; i++) {
            String row = sc.next();
            for (int j = 0; j < N; j++)
                grid[i][j] = row.charAt(j);
        }
        System.out.println(solve(grid));
    }

    static String solve(char[][] grid) {
        int M = grid.length, N = grid[0].length;
        List<int[]> src = new ArrayList<>(), dst = new ArrayList<>();
        for (int i = 0; i < M; i++)
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 'l') src.add(new int[]{i, j});
                if (grid[i][j] == 'L') dst.add(new int[]{i, j});
            }
        if (src.isEmpty() || dst.isEmpty() || src.size() != dst.size())
            return "Impossible";
        int len = src.size();
        boolean horizSrc = isHorizontal(src), horizDst = isHorizontal(dst);

        int[] srcTL = topLeft(src), dstTL = topLeft(dst);
        State start = new State(srcTL[0], srcTL[1], horizSrc);
        State goal = new State(dstTL[0], dstTL[1], horizDst);

        Queue<State> queue = new ArrayDeque<>();
        Map<State, Integer> dist = new HashMap<>();
        queue.add(start);
        dist.put(start, 0);

        while (!queue.isEmpty()) {
            State cur = queue.poll();
            int d = dist.get(cur);
            if (cur.equals(goal)) return String.valueOf(d);

            int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };
            for (int[] dir : dirs) {
                State nx = new State(cur.r + dir[0], cur.c + dir[1], cur.horizontal);
                if (canPlace(grid, nx, len) && !dist.containsKey(nx)) {
                    dist.put(nx, d + 1);
                    queue.add(nx);
                }
            }
            State rot = new State(cur.r, cur.c, !cur.horizontal);
            if (canRotate(grid, cur, len) && !dist.containsKey(rot)) {
                dist.put(rot, d + 1);
                queue.add(rot);
            }
        }
        return "Impossible";
    }

    static boolean isHorizontal(List<int[]> cells) {
        cells.sort(Comparator.comparing((int[] a) -> a[0]).thenComparingInt(a -> a[1]));
        return cells.get(0)[0] == cells.get(cells.size()-1)[0];
    }

    static int[] topLeft(List<int[]> cells) {
        int r = Integer.MAX_VALUE, c = Integer.MAX_VALUE;
        for (int[] p : cells) {
            if (p[0] < r || (p[0] == r && p[1] < c)) { r = p[0]; c = p[1]; }
        }
        return new int[]{r, c};
    }

    static boolean canPlace(char[][] g, State s, int len) {
        int M = g.length, N = g[0].length;
        if (s.horizontal) {
            if (s.r < 0 || s.r >= M || s.c < 0 || s.c + len - 1 >= N) return false;
            for (int j = 0; j < len; j++) if (g[s.r][s.c + j] == 'B') return false;
        } else {
            if (s.r < 0 || s.r + len - 1 >= M || s.c < 0 || s.c >= N) return false;
            for (int i = 0; i < len; i++) if (g[s.r + i][s.c] == 'B') return false;
        }
        return true;
    }

    static boolean canRotate(char[][] g, State s, int len) {
        int M = g.length, N = g[0].length;
        int r = s.r, c = s.c;
        if (r < 0 || c < 0 || r + len - 1 >= M || c + len - 1 >= N) return false;
        for (int i = r; i < r + len; i++)
            for (int j = c; j < c + len; j++)
                if (g[i][j] == 'B') return false;
        return true;
    }
}
