import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] inputArr = new char[n];
        int countA = 0, countB = 0, countC = 0;
        for (int i = 0; i < n; i++) {
            inputArr[i] = st.nextToken().charAt(0);
            if (inputArr[i] == 'A') countA++;
            else if (inputArr[i] == 'B') countB++;
            else countC++;
        }

        String inputString = new String(inputArr);


        st = new StringTokenizer(br.readLine());

        Map<Integer, Character> fixedMap = new HashMap<>();
        while (st.hasMoreTokens()) {
            int pos = Integer.parseInt(st.nextToken());

            fixedMap.put(pos - 1, inputArr[pos - 1]);
        }


        String[] perms = {"ABC", "ACB", "BAC", "BCA", "CAB", "CBA"};


        int minShifts = Integer.MAX_VALUE;


        for (String perm : perms) {


            StringBuilder targetBuilder = new StringBuilder(n);
            for (char c : perm.toCharArray()) {
                if (c == 'A') {
                    for (int i = 0; i < countA; i++) targetBuilder.append('A');
                } else if (c == 'B') {
                    for (int i = 0; i < countB; i++) targetBuilder.append('B');
                } else {
                    for (int i = 0; i < countC; i++) targetBuilder.append('C');
                }
            }
            String targetString = targetBuilder.toString();


            boolean possible = true;
            for (Map.Entry<Integer, Character> entry : fixedMap.entrySet()) {
                int idx = entry.getKey();
                char originalOwner = entry.getValue();
                char targetOwner = targetString.charAt(idx);


                if (originalOwner != targetOwner) {
                    possible = false;
                    break;
                }
            }


            if (possible) {

                int lcs = calculateLCS(inputString, targetString);
                int shifts = n - lcs;
                minShifts = Math.min(minShifts, shifts);
            }
        }


        if (minShifts == Integer.MAX_VALUE) {

            System.out.print("Impossible");
        } else {

            System.out.print(minShifts);
        }
    }


    private static int calculateLCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();


        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }


        return dp[m][n];
    }
}