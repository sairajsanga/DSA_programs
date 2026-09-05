class Solution {
    public int maxJump(int[] stones) {
        
        int n=stones.length;

        int ans=stones[1]-stones[0];
        
        for(int i=3;i<n;i+=2){
            ans=Math.max(ans,stones[i]-stones[i-2]);
        }
        for(int i=2;i<n;i+=2){
            ans=Math.max(ans,stones[i]-stones[i-2]);
        }

        return ans;
    }
}