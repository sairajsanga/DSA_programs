class Solution {
    String res="";
    public String lexGreaterPermutation(String s, String target) {
        int n=s.length();
        
        int freq[]=new int[26];


        for(char ch:s.toCharArray()){
            freq[ch-'a']++;
        }

      if(solve("",freq,target,0,false)) return res;
      return "";
    }

    public boolean solve(String curr,int count[],String target,int idx,boolean greater){

        if(idx==target.length()) {
            if(greater) {
                res+=curr;
                return true;
            }  
            return false;
        }

        int targetchar=target.charAt(idx)-'a';

        for(char ch='a';ch<='z';ch++){

            if(count[ch-'a']==0) continue;
            if(!greater && ch<target.charAt(idx)) continue;

            boolean nextGreater=greater||ch>target.charAt(idx);
            if(count[ch-'a']>0){
                curr+=ch;
                count[ch-'a']--;
            }
            
            if(solve(curr,count,target,idx+1,nextGreater)) return true;

            count[ch-'a']++;
            curr=curr.substring(0,curr.length()-1);
        }
        return false;       
    }
}