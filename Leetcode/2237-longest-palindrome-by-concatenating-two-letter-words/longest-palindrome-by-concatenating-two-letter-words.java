class Solution {
    public int longestPalindrome(String[] words) {
       HashMap<String,Integer> map=new HashMap<>();
       for(String s:words){
          map.put(s,map.getOrDefault(s,0)+1);
       } 
       int result=0;
       boolean centre=false;
       for(String word:words){
          String rev=reverse(word);
          if(!rev.equals(word)){
            if(map.getOrDefault(word,0)>0&&map.getOrDefault(rev,0)>0){
                map.put(word,map.getOrDefault(word,0)-1);
                map.put(rev,map.getOrDefault(rev,0)-1);
                result+=4;
            }
          }
          else{
            if(map.getOrDefault(word,0)>=2){
                 map.put(word,map.getOrDefault(word,0)-2);
                 result+=4;
            }
            else if(map.getOrDefault(word,0)==1&&centre==false){
                 map.put(word,map.getOrDefault(word,0)-1);
                 result+=2;
                 centre=true;
            }
          }
       }
       return result;
    }
    public String reverse(String str){
        StringBuilder s=new StringBuilder(str);
        return s.reverse().toString();     
    }
}