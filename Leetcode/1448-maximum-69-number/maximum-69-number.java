class Solution {
    public int maximum69Number (int num) {
       String n=Integer.toString(num);
       char arr[]=n.toCharArray();
       for(int i=0;i<arr.length;i++){
          if(arr[i]!='9'){
            arr[i]='9';
            break;
          }
       }
       String res=new String(arr);
       int ans=Integer.parseInt(res);
       return ans;
    }
}