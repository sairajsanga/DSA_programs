class Solution {
    public boolean judgeCircle(String moves) {
        int n=moves.length();
        int up=0;
        int left=0;
        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='U'){
                up++;
            }
            else if(moves.charAt(i)=='L'){
                left++;
            }
            else if(moves.charAt(i)=='D'){
                up--;
            }
            else{
                left--;
            }
        }

        if(left==0&&up==0) return true;

        return false;
    }
}