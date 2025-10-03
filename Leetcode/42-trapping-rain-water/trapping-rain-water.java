class Solution {
    int leftarr[];
    int rightarr[];
    public int trap(int[] height) {
       int n=height.length;
       int res=0;
       int left[]=getleftmax(height,n);
       int right[]=getrightmax(height,n);
       for(int i=0;i<n;i++){
          int w=Math.min(left[i],right[i])-height[i];
          if(w>0){
            res+=w;
          }
       } 
       return res;
    }
    public int[] getleftmax(int [] height,int n){
        int leftarr[]=new int[n];
         leftarr[0]=height[0];
        for(int x=1;x<n;x++){
             leftarr[x]=Math.max(leftarr[x-1],height[x]);
        }
        return leftarr;
    }
    public int[] getrightmax(int [] height,int n){
        int rightarr[]=new int[n];
         rightarr[n-1]=height[n-1];
        for(int x=n-2;x>=0;x--){
             rightarr[x]=Math.max(rightarr[x+1],height[x]);
        }
        return rightarr;
    }
}