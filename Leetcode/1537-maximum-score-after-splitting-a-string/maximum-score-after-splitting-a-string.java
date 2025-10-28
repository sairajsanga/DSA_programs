class Solution {
    public int maxScore(String s) {
        int zero[]=new int[s.length()];
        int ones[]=new int[s.length()];
        int zerocount=0;
        int onescount=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='0'){
                zerocount++;
                zero[i]=zerocount;
            } 
        }
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)=='1'){
                onescount++;
                ones[i]=onescount;
            }
        }
        int max=Integer.MIN_VALUE;
        for(int i=0;i<s.length()-1;i++){
            int ans=zero[i]+ones[i+1];
            max=Math.max(ans,max);
        }
        return max;
    }
}