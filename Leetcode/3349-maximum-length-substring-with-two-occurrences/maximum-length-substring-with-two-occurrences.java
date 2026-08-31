class Solution {
    public int maximumLengthSubstring(String s) {
        int n=s.length();
        int count[]=new int[26];

        int i=0,j=0;
        int max=0;
        while(j<n){
           int ch=s.charAt(j)-'a';
           count[ch]++;
           while(count[ch]>2){
             int ch2=s.charAt(i)-'a';
             count[ch2]--;
             i++;
           }
           max=Math.max(max,j-i+1);
           j++;
        }
        return max;
    }
}