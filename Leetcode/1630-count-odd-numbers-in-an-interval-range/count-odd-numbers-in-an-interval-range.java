class Solution {
    public int countOdds(int low, int high) {
        if(low%2==0){
            low=low+1;
        }
        if(high%2==0){
            high--;
        }

        int start=(low-1)/2;
        int end=(high-1)/2;
        return end-start+1;
    }
}