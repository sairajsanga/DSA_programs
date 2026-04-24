class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int n=moves.length();
        int countL=0;
        int countR=0;
        int under=0;

        for(int i=0;i<n;i++){
            if(moves.charAt(i)=='L'){
                countL++;
            }
            else if(moves.charAt(i)=='R'){
                countR++;
            }
            else{
                under++;
            }
        }
    
       int val=0;
       int ans=0;
       if(countL>countR){
          val=countL+under;
          ans=val-countR;
       }
       else{
          val=countR+under;
          ans=val-countL;
       }
       return ans;

    }
}