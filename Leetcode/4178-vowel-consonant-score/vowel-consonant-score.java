class Solution {
    public int vowelConsonantScore(String s) {
        int n=s.length();
        int v=0,c=0;
        for(char ch:s.toCharArray()){
           if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
              v++;
           }
           else if(ch >= 48 && ch <= 57 || ch == 32){
                continue;
            }
            else{
                c++;
            }
        }
        return (c > 0) ? (int) Math.floor(v / c) : 0;
    }
}