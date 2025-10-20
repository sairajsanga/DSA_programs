class Solution {
    public int minOperations(String s) {
        HashSet<Character> set=new HashSet<>();
        int count[]=new int[26];
        for(char ch:s.toCharArray()){
            set.add(ch);
        }
        int max=0;
        for(char ch:set){
            int step=(26-(ch-'a'))%26;
            if(step>max){
                max=step;
            }
        }
        return max;
    }
}