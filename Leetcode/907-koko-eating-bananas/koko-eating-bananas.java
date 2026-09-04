class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int n=piles.length;

       
       int max=0;
       int total=0;

       for(int i=0;i<n;i++){
           max=Math.max(max,piles[i]);
           
       }

       long start=1;
       long end=max;

       while(start<=end){
           long mid=start+(end-start)/2;
            
            if(gethours(piles,mid)<=h){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return (int)start;
    }
     public long gethours(int[] piles, long speed) {

        long hours = 0;

        for(int pile : piles) {
            hours += (pile + speed - 1) / speed;
        }

        return hours;
    }
}