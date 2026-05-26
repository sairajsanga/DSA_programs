class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[]=new int[26];
        int max=0;
        int maxcount=0;
        for(char ch:tasks){
            count[ch-'A']++;
        }
        for(int ele:count){
            max=Math.max(max,ele);  
        }
        for(int ele:count){
            if(ele==max){
                maxcount++;
            }
        }
         
        int ans=(max-1)*(n+1);
        return Math.max(tasks.length,ans+maxcount);
         
    }
}