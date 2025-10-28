class Solution {
    public boolean scoreBalance(String s) {
        
        int total=0;
        for(int i=0;i<s.length();i++){
            total+=s.charAt(i) - 'a' + 1;
        }
        int left=0;
        for(int i=0;i<s.length();i++){
            left+=s.charAt(i) - 'a' + 1;
            if(total-left==left){
                return true;
            }
        }
        return false;
    }
}