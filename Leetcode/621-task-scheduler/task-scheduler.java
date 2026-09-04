class Solution {
    public int leastInterval(char[] tasks, int n) {
        int count[]=new int[26];
        int max=0;
        int maxcount=0;
        for(char ch:tasks){
            count[ch-'A']++;
            max=Math.max(max,count[ch-'A']); 
        }
        
        int ans=(max-1)*(n+1);
        for(int ele:count){
            if(ele==max){
               ans++;
            }
        }  
        return Math.max(ans,tasks.length);      
    }
}