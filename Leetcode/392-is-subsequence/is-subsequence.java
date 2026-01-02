class Solution {
    public boolean isSubsequence(String s, String t) {
        return solve(s,t);
    }

    public boolean solve(String s,String t){
        if(s.length()==0) return true;
        if(t.length()==0) return false;
        if(s.charAt(s.length()-1)==t.charAt(t.length()-1)){
            return solve(s.substring(0,s.length()-1),t.substring(0,t.length()-1));
        }

        return solve(s,t.substring(0,t.length()-1));
    }
}