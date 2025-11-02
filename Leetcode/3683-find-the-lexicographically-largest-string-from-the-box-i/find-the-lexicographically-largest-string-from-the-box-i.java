class Solution {
    public String answerString(String s, int numFriends) {
        int n=s.length();
        if(numFriends==1) return s;
        int k=(n-numFriends)+1;
        String res="";
        for(int i=0;i<n;i++){
           String temp;
           if(i+k<=n){
              temp=s.substring(i,i+k);
           } 
           else{
              temp=s.substring(i);
           }
           if(temp.compareTo(res)>0){
            res=temp;
           }
        }
        return res;
    }
}