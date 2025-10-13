class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int res[] = new int[s.length()];
        char str[] = s.toCharArray();
        for (int arr[] : shifts) {
            int start = arr[0];
            int end = arr[1];
            int direction = arr[2];
            if (direction == 1) {
                res[start] += 1;
                if (end + 1 < n) {
                    res[end + 1] -= 1;
                }
            } else {
                res[start] -= 1;
                if (end + 1 < n) {
                    res[end + 1] += 1;
                }
            }
        }
        for (int i = 1; i < res.length; i++) {
            res[i] += res[i - 1];
        }
        char result[] = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int shift = ((result[i] - 'a') + res[i]) % 26;
            if (shift < 0)
                shift += 26; // handle backward wrap
            result[i] = (char)('a' + shift);
        }
        
        return new String (result);
    }
}