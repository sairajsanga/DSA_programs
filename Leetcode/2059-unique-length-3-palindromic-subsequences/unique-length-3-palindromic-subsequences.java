class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(s.charAt(i));
        }
        int count=0;
        for(char ch:set){
             int firstIndex=first(ch,s);
             int secoundIndex=secound(ch,s);
             HashSet<Character> inter=new HashSet<>();
             for(int i=firstIndex+1;i<secoundIndex;i++){
                inter.add(s.charAt(i));
             }
             count+=inter.size();
        }
        return count;
    }

    public int first(char ch,String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==ch){
                return i;
            }
        }
        return -1;
    }

    public int secound(char ch,String s){
        for(int i=s.length()-1;i>=0;i--){
            if(s.charAt(i)==ch){
                return i;
            }
        }
        return -1;
    }



}