import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int M, N;
    static int len;
    static char[][] grid;

    static int startR, startC, startOrient;
    static int targetR, targetC, targetOrient;

    static boolean[][][] visited;

    static class State {
        int r, c, orient, steps;

        State(int r, int c, int orient, int steps) {
            this.r = r;
            this.c = c;
            this.orient = orient;
            this.steps = steps;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        grid = new char[M][N];
        visited = new boolean[M][N][2];

        int r1 = -1, c1 = -1, r2 = -1, c2 = -1;
        int tr1 = -1, tc1 = -1, tr2 = -1, tc2 = -1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = st.nextToken().charAt(0);
                if (grid[i][j] == 'l') {
                    if (r1 == -1) {
                        r1 = i;
                        c1 = j;
                    }
                    r2 = i;
                    c2 = j;
                } else if (grid[i][j] == 'L') {
                    if (tr1 == -1) {
                        tr1 = i;
                        tc1 = j;
                    }
                    tr2 = i;
                    tc2 = j;
                }
            }
        }

        startR = r1;
        startC = c1;
        if (r1 == r2) {
            startOrient = 0;
            len = c2 - c1 + 1;
        } else {
            startOrient = 1;
            len = r2 - r1 + 1;
        }

        targetR = tr1;
        targetC = tc1;
        if (tr1 == tr2) {
            targetOrient = 0;
        } else {
            targetOrient = 1;
        }

        solve();
    }

    static boolean isPassable(int r, int c) {
        return r >= 0 && r < M && c >= 0 && c < N && grid[r][c] != 'B';
    }

    static boolean checkAllPassable(int r, int c, int orient) {
        if (orient == 0) {
            for (int j = 0; j < len; j++) {
                if (!isPassable(r, c + j)) return false;
            }
        } else {
            for (int i = 0; i < len; i++) {
                if (!isPassable(r + i, c)) return false;
            }
        }
        return true;
    }

    static boolean checkRotationSquare(int r, int c) {
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (!isPassable(r + i, c + j)) return false;
            }
        }
        return true;
    }

    static void solve() {
        Queue<State> q = new LinkedList<>();

        q.add(new State(startR, startC, startOrient, 0));
        visited[startR][startC][startOrient] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!q.isEmpty()) {
            State current = q.poll();

            if (current.r == targetR && current.c == targetC && current.orient == targetOrient) {
                System.out.println(current.steps);
                return;
            }

            int r = current.r;
            int c = current.c;
            int orient = current.orient;
            int steps = current.steps + 1;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (checkAllPassable(nr, nc, orient) && !visited[nr][nc][orient]) {
                    visited[nr][nc][orient] = true;
                    q.add(new State(nr, nc, orient, steps));
                }
            }

            int newOrient = 1 - orient;

            if (checkRotationSquare(r, c)) {
                if (!visited[r][c][newOrient]) {
                    visited[r][c][newOrient] = true;
                    q.add(new State(r, c, newOrient, steps));
                }
            }
        }

        System.out.println("Impossible");
    }
}
