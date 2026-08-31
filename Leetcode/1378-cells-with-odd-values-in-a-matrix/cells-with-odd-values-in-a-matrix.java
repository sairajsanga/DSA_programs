class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int arr[][]=new int[m][n];

        for(int indice[]:indices){
            int r=indice[0];
            int c=indice[1];
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(i==r){
                        arr[i][j]+=1;
                    }
                    if(j==c){
                        arr[i][j]+=1;
                    }
                }
            }
        }
        
        int ans=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(arr[i][j]+" ");
                if(arr[i][j]%2!=0){
                   ans++;
                }
            }
        }
        return ans;
    }
}