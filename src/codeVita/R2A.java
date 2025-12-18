package codeVita;

import java.util.*;

public class R2A {
    static class Node {
        int r, i, d;
        Node(int r, int i, int d) { this.r = r; this.i = i; this.d = d; }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) { System.out.println(-1); return; }
        int N = sc.nextInt();
        sc.nextLine();
        char[][] rings = new char[N][];
        for (int k = 0; k < N; k++) {
            String line = "";
            while (line.length() == 0 && sc.hasNextLine()) line = sc.nextLine().trim();
            rings[k] = line.toCharArray();
        }
        int outer = N - 1;
        int outerLen = rings[outer].length;
        boolean[][] vis = new boolean[N][];
        for (int r = 0; r < N; r++) vis[r] = new boolean[rings[r].length];
        ArrayDeque<Node> q = new ArrayDeque<>();
        for (int i = 0; i < outerLen; i++) {
            if (rings[outer][i] == '0') {
                vis[outer][i] = true;
                q.add(new Node(outer, i, 1));
            }
        }
        int ans = -1;
        while (!q.isEmpty()) {
            Node cur = q.poll();
            int r = cur.r, i = cur.i, d = cur.d;
            if (r == 0 && rings[0][i] == '0') { ans = d; break; }
            int L = rings[r].length;
            int ni1 = (i + 1) % L;
            if (!vis[r][ni1] && rings[r][ni1] == '0') { vis[r][ni1] = true; q.add(new Node(r, ni1, d + 1)); }
            int ni2 = (i - 1 + L) % L;
            if (!vis[r][ni2] && rings[r][ni2] == '0') { vis[r][ni2] = true; q.add(new Node(r, ni2, d + 1)); }
            if (r - 1 >= 0) {
                int inward = i / 2;
                if (!vis[r - 1][inward] && rings[r - 1][inward] == '0') { vis[r - 1][inward] = true; q.add(new Node(r - 1, inward, d + 1)); }
            }
            if (r + 1 < N) {
                int outLen = rings[r + 1].length;
                int o1 = i * 2;
                if (o1 < outLen && !vis[r + 1][o1] && rings[r + 1][o1] == '0') { vis[r + 1][o1] = true; q.add(new Node(r + 1, o1, d + 1)); }
                int o2 = i * 2 + 1;
                if (o2 < outLen && !vis[r + 1][o2] && rings[r + 1][o2] == '0') { vis[r + 1][o2] = true; q.add(new Node(r + 1, o2, d + 1)); }
            }
        }
        System.out.print(ans == -1 ? -1 : ans);
        sc.close();
    }
}
