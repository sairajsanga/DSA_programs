class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int res[]=new int[spells.length];
        int i=0;
        
        while(i<spells.length){
            int low=binarysearch(spells,potions,success,i);
            res[i]=potions.length-low;
            i++;
        }
        return res;
    }
    public int binarysearch(int []spells,int potions[],long success,int index){
        int low=0;
        int high=potions.length-1;
        while(low<=high&&index<spells.length){
            int mid=low+(high-low)/2;
            long prod=(long) potions[mid]*spells[index];
            if(prod>=success){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}