class Solution {
    public int minOperations(String s) {
        HashSet<Character> set=new HashSet<>();
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