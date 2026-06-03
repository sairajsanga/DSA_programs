class Solution {

    public boolean equationsPossible(String[] equations) {
        int n=equations.length;

        char[] parent=new char[26];

        int rank[]=new int[26];

        for(int i=0;i<26;i++){
            parent[i]=(char) ('a'+i);
        }

        for(int i=0;i<n;i++){
            String str=equations[i];
            char ch1=str.charAt(0);
            char ch2=str.charAt(3);
            char ch3=str.charAt(1);
            if(ch3=='='){
               union(ch1,ch2,parent,rank);
            }     
        }

        for(String str:equations){
            char ch1=str.charAt(0);
            char ch2=str.charAt(3);
            char ch3=str.charAt(1);

            if(ch3=='!'){
                char x=find(ch1,parent);
                char y=find(ch2,parent);
                if(x==y) return false;
            }
            
        }

        return true;


    }

    public char find(char ch,char parent[]){

        if(ch==parent[ch-'a']) return ch;

        return parent[ch-'a']=find(parent[ch-'a'],parent);
    }

    public void union(char a,char b,char parent[],int rank[]){
        char parent_a=find(a,parent);
        char parent_b=find(b,parent);

        if(parent_a==parent_b) return;

        if(rank[parent_a-'a']>rank[parent_b-'a']){
            parent[parent_b-'a']=parent_a;
        }
        else if(rank[parent_b-'a']>rank[parent_a-'a']){
            parent[parent_a-'a']=parent_b;
        }
        else{
            parent[parent_b-'a']=parent_a;
            rank[parent_a-'a']++;
        }
    }


}