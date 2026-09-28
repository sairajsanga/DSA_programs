class Solution {
    public int maxDepth(String s) {
        int n=s.length();

        int maxDepth=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
               count++;
               maxDepth=Math.max(maxDepth,count);
            }
            else if(s.charAt(i)==')'){
                count--;
            }
        }
        return maxDepth;
    }
}