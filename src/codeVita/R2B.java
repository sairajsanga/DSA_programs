package codeVita;

import java.util.*;
public class R2B {
    static int N, M, I;
    static char[][] grid;
    static String word;
    static int L;
    static int best = Integer.MAX_VALUE;
    static boolean[][] vis;
    static ArrayList<Integer>[] cluesAtTime;
    static int[] Tarr;
    static int[] x1a, y1a, x2a, y2a;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        grid = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                String s = sc.next();
                grid[i][j] = s.charAt(0);
            }
        }
        I = sc.nextInt();
        Tarr = new int[I];
        x1a = new int[I];
        y1a = new int[I];
        x2a = new int[I];
        y2a = new int[I];
        ArrayList<int[]> tmp = new ArrayList<>();
        for (int k = 0; k < I; k++) {
            int t = sc.nextInt();
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            Tarr[k] = t;
            x1a[k] = x1-1;
            y1a[k] = y1-1;
            x2a[k] = x2-1;
            y2a[k] = y2-1;
        }
        word = sc.next();
        L = word.length();
        cluesAtTime = new ArrayList[L+1];
        for (int t = 0; t <= L; t++) cluesAtTime[t] = new ArrayList<>();
        for (int k = 0; k < I; k++) {
            int t = Tarr[k];
            if (t >= 1 && t <= L) cluesAtTime[t].add(k);
        }
        vis = new boolean[N][M];
        boolean anyPath = false;
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < M; c++) {
                if (grid[r][c] == word.charAt(0)) {
                    int add = countCluesAtPosition(1, r, c);
                    if (add < best) {
                        vis[r][c] = true;
                        dfs(r, c, 1, add);
                        vis[r][c] = false;
                    }
                    if (best != Integer.MAX_VALUE) anyPath = true;
                }
            }
        }
        if (best == Integer.MAX_VALUE) {
            System.out.print("Impossible");
        } else if (best == 0) {
            System.out.print("All clues are correct");
        } else {
            System.out.print(best);
        }
        sc.close();
    }
    static int countCluesAtPosition(int t, int r, int c) {
        if (t < 1 || t > L) return 0;
        int sum = 0;
        for (int idx : cluesAtTime[t]) {
            if (r >= x1a[idx] && r <= x2a[idx] && c >= y1a[idx] && c <= y2a[idx]) sum++;
        }
        return sum;
    }
    static void dfs(int r, int c, int pos, int viol) {
        if (viol >= best) return;
        if (pos == L) {
            best = Math.min(best, viol);
            return;
        }
        int np = pos + 1;
        for (int k = 0; k < 4; k++) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
            if (vis[nr][nc]) continue;
            if (grid[nr][nc] != word.charAt(pos)) continue;
            int add = countCluesAtPosition(np, nr, nc);
            vis[nr][nc] = true;
            dfs(nr, nc, np, viol + add);
            vis[nr][nc] = false;
        }
    }
}

