package AdityaSW;

import java.util.HashMap;

public class LongSubstringKUniqueCharacters {
    public static void main(String[] args) {
        String s="aabcaebe";
        int k=3;
        System.out.println(findLongK(s,k));
    }
    public static int findLongK(String s,int k){
       int n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int max=0;
        while(j<n){
            map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            if(map.size()<k){
                j++;
            }
            else if(map.size()==k){
                max=Math.max(max,j-i+1);
                j++;
            }
            else if(map.size()>k){
                while(map.size()>k) {
                    map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) - 1);
                    if(map.get(s.charAt(i))==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
//                if(map.size()==k){
//                    max=Math.max(max,j-i+1);
//                }
                j++;
            }
        }
        return max;
    }
}
