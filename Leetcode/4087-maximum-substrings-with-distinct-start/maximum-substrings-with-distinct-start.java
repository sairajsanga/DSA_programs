class Solution {
    public int maxDistinct(String s) {
        int n=s.length();
        HashSet<Character> set=new HashSet<>();
        for(char ch:s.toCharArray()){
            set.add(ch);
        }
        return set.size();
    }
}