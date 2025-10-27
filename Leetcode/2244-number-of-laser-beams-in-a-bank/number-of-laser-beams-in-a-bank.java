class Solution {
    public int numberOfBeams(String[] bank) {
       int n=bank.length;
       int res=0;
       for(int i=0;i<n-1;i++){
          int ans=0;
          int devices=nooflasers(bank[i]);
          if(devices==0) continue;
          for(int j=i+1;j<n;j++){
             int internaldevices=nooflasers(bank[j]);
             if(internaldevices==0) continue;
             ans=devices*internaldevices;
             break;
          }
          res+=ans;
       }
       return res;

    }
    public int nooflasers(String str){
        int count=0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='1') count++;
        }
        return count;
    }
}