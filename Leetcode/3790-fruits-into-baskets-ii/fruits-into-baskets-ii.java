class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n=fruits.length;
        boolean visted[]=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            int fru=fruits[i];
             for(int j=0;j<n;j++){
                if(!visted[j]&&baskets[j]>=fru){
                    visted[j]=true;
                    break;
                }
             }
        }
        for(int i=0;i<n;i++){
            if(!visted[i]){
                count++;
            }
        }
        return count;
    }
}