class Solution {
    public int totalWaviness(int num1, int num2) {
        
        int res=0;
        for(int i=num1;i<=num2;i++){
            int num=i;
            res+=check(num);
        }

        return res;
    }

    public int check(int num){
        String s=String.valueOf(num);
        
        int count=0;
        for(int i=1;i<s.length()-1;i++){
           if(s.charAt(i)>s.charAt(i-1)&&s.charAt(i)>s.charAt(i+1)){
              count++;
           }
           else if(s.charAt(i)<s.charAt(i-1)&&s.charAt(i)<s.charAt(i+1)){
            count++;
           }
        }

        return count;

    }
}