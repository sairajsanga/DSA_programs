class Solution {
    public int passwordStrength(String password) {
        int n=password.length();

        StringBuilder str=new StringBuilder();

        char eles[]=password.toCharArray();
        

        HashSet<Character> charset=new HashSet<>();
        int strength=0;
        for(int i=0;i<n;i++){
            char x=password.charAt(i);
            if(!charset.contains(x)){
                if(x>=97&&x<=122){
                    strength+=1;
                }
                else if(x>=65&&x<=90){
                    strength+=2;
                }
                else if(x>=48&&x<=57){
                    strength+=3;
                }
                else{
                    strength+=5;
                }
            }
            charset.add(x);
        }

        return strength;


    }
}