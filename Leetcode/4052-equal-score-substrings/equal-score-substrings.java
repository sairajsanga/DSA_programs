class Solution {
    public boolean scoreBalance(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<26;i++){
            char ch=(char)('a'+i);
           map.put(ch,i+1);
        }
        int total=0;
        for(int i=0;i<s.length();i++){
            total+=map.get(s.charAt(i));
        }
        int left=0;
        for(int i=0;i<s.length();i++){
            left+=map.get(s.charAt(i));
            if(total-left==left){
                return true;
            }
        }
        return false;
    }
}