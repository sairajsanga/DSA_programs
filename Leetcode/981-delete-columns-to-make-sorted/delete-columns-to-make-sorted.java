class Solution {
    public int minDeletionSize(String[] strs) {
        int n=strs[0].length();
        int m=strs.length;
        int count=0;
        for(int i=0;i<n;i++){
            char currChar = strs[0].charAt(i);
            for(int j=1;j<m;j++){
                if(strs[j].charAt(i)<currChar){
                    count++;
                    break;
                }
                currChar = strs[j].charAt(i);
            }          
        }
        return count;
    }


}