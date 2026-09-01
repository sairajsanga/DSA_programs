class Solution {
    public String getHint(String secret, String guess) {

        int n = secret.length();

        int secretCount[] = new int[10];
        int guessCount[] = new int[10];

        int bulls = 0;

        // Count bulls and only count non-bull digits
        for (int i = 0; i < n; i++) {

            if (secret.charAt(i) == guess.charAt(i)) {
                bulls++;
            } else {
                int s = secret.charAt(i) - '0';
                int g = guess.charAt(i) - '0';

                secretCount[s]++;
                guessCount[g]++;
            }
        }

        // Find cows
        int cows = 0;

        for (int i = 0; i < 10; i++) {
            cows += Math.min(secretCount[i], guessCount[i]);
        }

        return bulls + "A" + cows + "B";
    }
}