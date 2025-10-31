package RandomQues;

import java.util.Scanner;

public class newcode {
    static int solveOne(String s) {
        int n = s.length();
        int ans = Integer.MAX_VALUE;

        class Helper {
            int cost(char a, char b) {

                int i = -1;
                for (int k = n - 1; k >= 0; k--) {
                    if (s.charAt(k) == b) { i = k; break; }
                }
                if (i == -1) return Integer.MAX_VALUE;

                int j = -1;
                for (int k = i - 1; k >= 0; k--) {
                    if (s.charAt(k) == a) { j = k; break; }
                }
                if (j == -1) return Integer.MAX_VALUE;

                return (i - j - 1) + (n - i - 1);
            }
        }
        Helper h = new Helper();
        ans = Math.min(ans, h.cost('0','0'));
        ans = Math.min(ans, h.cost('2','5'));
        ans = Math.min(ans, h.cost('5','0'));
        ans = Math.min(ans, h.cost('7','5'));

        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner fs = new Scanner(System.in);
        int t = fs.nextInt();

        while (t-- > 0) {
            String s = fs.next();
            System.out.println(solveOne(s));
        }

    }
}

