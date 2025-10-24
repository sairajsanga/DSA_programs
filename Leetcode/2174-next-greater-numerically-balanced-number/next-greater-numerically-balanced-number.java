class Solution {
    int freq[];
    public int nextBeautifulNumber(int n) {
        if(n==0) return 1;
       this.freq=new int[10];
       for(int i=0;i<10;i++){
          freq[i]=i;
       }
       int digitsleft=(int)(Math.log(n)/Math.log(10))+1;
       int result=backtrack(n,0,digitsleft);
       if(result!=-1){
         if(isbalanced(result)) return result;  
       }
        return backtrack(n,0,digitsleft+1);
    }

    public int backtrack(int n,int curr,int digits){
        if(digits==0){
            if(isbalanced(curr)){
                return (curr>n?curr:-1);
            }
            return -1;
        }
        int result=-1;
        for(int i=1;i<=9;i++){
            if(freq[i]>0&&freq[i]<=digits){
                freq[i]--;
                result=backtrack(n,curr*10+i,digits-1);
                if(result!=-1) break;
                freq[i]++;
            }
        }
        return result;
    }

    public boolean isbalanced(int num){
        int count[]=new int[10];
        while(num>0){
            count[num%10]++;
            num/=10;
        }

        for(int i=1;i<10;i++){
            if(count[i]>0&&count[i]!=i){
                return false;
            }
        }
        return true;
    }
}