class Solution {
    public List<List<String>> partition(String s) {
        int n=s.length();

       List<List<String>> res=new ArrayList<>();
       List<String> temp=new ArrayList<>();
       solve(s,0,res,temp);
       return res;
    }

    public void solve(String s,int i,List<List<String>> res,List<String> temp){

        if(i==s.length()){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int end=i;end<s.length();end++){
            if(IsPalindrome(s,i,end)){
                temp.add(s.substring(i,end+1));
                solve(s,end+1,res,temp);
                temp.removeLast();
            }
        }   
    }

    public boolean IsPalindrome(String s,int i ,int j){
        
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)) return false;
            i++;
            j--;
        }

        return true;
    }
}