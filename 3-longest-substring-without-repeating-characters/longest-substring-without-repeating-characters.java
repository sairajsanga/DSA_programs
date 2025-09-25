class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0;
        int j=0;
        int n=s.length();
        int max=0;
        while(j<n){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            if(map.size()==j-i+1){
                max=Math.max(max,j-i+1);
            }
            else if(map.size()<j-i+1){
                while(map.size()<j-i+1){
                    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                    if(map.getOrDefault(s.charAt(i),0)==0){
                        map.remove(s.charAt(i));
                    }
                    i++;
                }
            }
            j++;
        }
        return max;
    }
}