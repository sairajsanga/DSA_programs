class Solution {
    public boolean hasSameDigits(String s) {
       String result=helper(s);
       if(result.length()==2){
         if(result.charAt(0)==result.charAt(1)) return true;
       }
       return false;
    }
    public String helper(String s){
        int n=s.length();
        if(n==2) return s;
       int i=0;
       StringBuilder str=new StringBuilder();
       while(i<n-1&&n!=2){
          int first=s.charAt(i)-'0';
          int secound=s.charAt(i+1)-'0';
          int val=(first+secound)%10;
          str.append(String.valueOf(val));
          i++;
       }
       return helper(str.toString());
    }
}