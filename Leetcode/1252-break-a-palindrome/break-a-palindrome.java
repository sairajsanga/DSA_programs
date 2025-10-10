class Solution {
    public String breakPalindrome(String s) {
       if(s.length()==1) return "";
       char []arr=s.toCharArray();
       for(int i=0;i<arr.length/2;i++){
        if(arr[i]!='a'){
            arr[i]='a';
            return new String(arr);
        }
       }
       arr[arr.length-1]='b';
       return new String(arr);
    }
}