class Solution {
    public int minOperations(String s) {
        boolean[] freq = new boolean[26];
        for(char ch : s.toCharArray()) {
            freq[ch - 'a'] = true;
        }
        int count = 0;
        for(int i = 1; i < 25; i++) {
            if(freq[i]) {
                freq[i + 1] = freq[i];
                count++;
            }
        }
        return (freq[25])? count + 1 : count;
    }
}