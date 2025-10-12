class Solution {
    public int longestBalanced(String s) {
        int n=s.length();
        if(n==1) return 1;
        int count[]=new int[26];
        char arr[]=s.toCharArray();
        int res=0;
        int large=0;
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                int bound[]=getmincount(arr,i,j);
                int min=bound[0];
                int max=bound[1];
                if(min==max){
                   large=Math.max(large,j-i+1);
                }
            }
        }
        return large;
    }
    public int[] getmincount(char arr[],int i,int j){
        int count[]=new int[26];
        for(int x=i;x<=j;x++){
            count[arr[x]-'a']++;
        }
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int ele:count){
             if(ele!=0&&ele<min){
                min=ele;
             }
             if(ele!=0&&ele>max){
                max=ele;
             }
        }
        return new int[]{min,max};
    }
    // public int getmaxcount(char arr[],int i,int j){
    //     int count[]=new int[26];
    //     for(int x=i;x<=j;x++){
    //         count[arr[x]-'a']++;
    //     }
    //     int max=Integer.MIN_VALUE;
    //     for(int ele:count){
    //          if(ele!=0&&ele>max){
    //             max=ele;
    //          }
    //     }
    //     return max;
    // }
}