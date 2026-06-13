class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String str="";
        for(int i=0;i<words.length;i++){
            String s=words[i];
            int sum=0;
            for(char ch:words[i].toCharArray()){
                sum+=weights[ch-'a'];
            }

            int v=sum%26;
            int charval=26-v;
            char ch=(char)(charval+'a'-1);
            str=str+ch;  
        }

        return str;
        
    }

    // c--2. z=25
    // c=23 
    //. ch-'a'=idx --> idx+'a'=ch
}