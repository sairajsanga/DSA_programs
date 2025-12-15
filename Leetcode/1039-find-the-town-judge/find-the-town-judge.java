class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0 && n == 1) 
            return 1;
        int test[]=new int[n+1];
        for(int arr[]:trust){
           int a=arr[0];
           int b=arr[1];
           test[a]--;
           test[b]++;
        }
        for(int i=0;i<test.length;i++){
           if(test[i]==n-1){
            return i;
           }
        }
        return -1;
    }
}