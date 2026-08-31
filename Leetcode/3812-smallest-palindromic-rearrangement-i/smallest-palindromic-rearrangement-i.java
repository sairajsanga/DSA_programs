class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int partition=n/2;

        char chars[]=s.toCharArray();
        Arrays.sort(chars,0,partition);

        for(int i=0;i<partition;i++){
            chars[n-i-1]=chars[i];
        }

        return new String(chars);
    }
}