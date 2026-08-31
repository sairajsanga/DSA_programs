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
                if(x>='a'&&x<='z'){
                    strength+=1;
                }
                else if(x>='A'&&x<='Z'){
                    strength+=2;
                }
                else if(x>='0'&&x<='9'){
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