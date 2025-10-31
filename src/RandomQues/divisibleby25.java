package RandomQues;

import java.util.Scanner;
public class divisibleby25 {
    private static int minSteps(int n) {
        String num = Integer.toString(n);
        return solve(num, num.length(), 0);
    }
    private static int solve(String num, int index, int steps) {
        if(index == 0) {
            return Integer.MAX_VALUE;
        }
        if(Integer.parseInt(num) % 25 == 0) {
            return steps;
        }
        int minSteps = Integer.MAX_VALUE;
        for(int i = index - 1; i >= 0; i--) {
            int res = solve(num.substring(0, i) + num.substring(i + 1), index - 1, steps + 1);
            minSteps = Math.min(minSteps, res);
        }

        return minSteps;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            System.out.println(minSteps(n));
        }
    }
}
