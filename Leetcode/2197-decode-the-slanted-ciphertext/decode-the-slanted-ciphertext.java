class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        char arr[]=encodedText.toCharArray();

        int n=arr.length;

        int k=n/rows;
         
        StringBuilder str=new StringBuilder();

        for(int i=0;i<k;i++){
            for(int j=i;j<n;j+=k+1){
                str.append(arr[j]);
            }
        }

        return str.toString().stripTrailing();
    }
}