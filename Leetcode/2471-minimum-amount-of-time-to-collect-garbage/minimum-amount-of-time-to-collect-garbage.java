class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int total = 0; // total pickups time
        int n = garbage.length;
        int[] prefix = new int[n]; // prefix[i] = total travel from 0 to i
        
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + travel[i-1];
        }
        
        int res = 0;
        char[] types = {'M','P','G'};
        for(char type : types){
            int lastIdx = -1;
            int count = 0;
            for(int i=0; i<n; i++){
                String s = garbage[i];
                for(int j=0; j<s.length(); j++){
                    if(s.charAt(j) == type){
                        count++;
                        lastIdx = i;
                    }
                }
            }
            if(lastIdx != -1){
                res += count; // picking up each piece
                res += prefix[lastIdx]; // travel time to last house needing this type
            }
        }
        return res;
    }
}
