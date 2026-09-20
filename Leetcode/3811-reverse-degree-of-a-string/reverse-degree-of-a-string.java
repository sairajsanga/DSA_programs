class Solution {
    public int reverseDegree(String s) {
        int n=s.length();

        HashMap<Character,Integer> map=new HashMap<>();
        char x='a';
        for(int i=26;i>=1;i--){
            map.put(x,i);
            x=(char)(x+1);
        }
        
        int sum=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            int val=map.get(ch);

            sum+=(i+1)*val;
        }

        return sum;
    }
}