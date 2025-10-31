package RandomQues;

import java.util.Scanner;

public class codeforces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next(); // read as string to keep leading zeros safely
            System.out.println(solveOne(s));
        }
    }
    static int solveOne(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;
        String[] targets = {"00","25","50","75"};

        for (String t : targets) {
            char a = t.charAt(0), b = t.charAt(1);
            // find b from right
            int j = -1;
            for (int idx = n - 1; idx >= 0; idx--) {
                if (s.charAt(idx) == b) { j = idx; break; }
            }
            if (j == -1) continue;
            // find a to the left of j
            int i = -1;
            for (int idx = j - 1; idx >= 0; idx--) {
                if (s.charAt(idx) == a) { i = idx; break; }
            }
            if (i == -1) continue;

            // deletions to bring s[i], s[j] to last two positions
            int deletions = (n - 1 - j) + (j - i - 1); // equals n - i - 2
            ans = Math.min(ans, deletions);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}