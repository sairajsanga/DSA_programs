class Solution {
    public int bagOfTokensScore(int[] tokens, int p) {
        Arrays.sort(tokens);
        int score=0;
        int i=0;
        int j=tokens.length-1;
        int max=0;
        while(i<=j){
            if(p>=tokens[i]){
                p=p-tokens[i];
                score++;
                i++;
                max=Math.max(max,score);
            }
            else if(score>=1){
                p=p+tokens[j];
                j--;
                score--;  
            }
            else{
                return max;
            }
        }
        return max;
    }
}