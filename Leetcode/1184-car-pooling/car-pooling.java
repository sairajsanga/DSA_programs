class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n=trips.length;
        int m=trips[0].length;
        int start[]=new int[1001];
        int sum=0;
        for(int i=0;i<trips.length;i++){  
            int sp=trips[i][1];
            int ep=trips[i][2]; 
            start[sp]+=trips[i][0];
            start[ep]-=trips[i][0];
            
        }
        
        for(int i=0;i<start.length;i++){
            sum+=start[i];
            if(sum>capacity) return false;
        }
        return true;
    }
}