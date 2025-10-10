class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int n=energy.length;
       int suffix[]=new int[energy.length];
       
       for(int i=n-1;i>=0;i--){
          if(i+k>=n){
            suffix[i]=energy[i];
          }
          else{
            suffix[i]=energy[i]+suffix[i+k];
          }
       }
       int max=Integer.MIN_VALUE;
       for(int i=0;i<suffix.length;i++){
           if(max<suffix[i]){
            max=suffix[i];
           }
       }
       return max;
    }
}