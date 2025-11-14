class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int result[][]=new int[n][n];
        for(int []query:queries){
            int row1=query[0];
            int col1=query[1];
            int row2=query[2];
            int col2=query[3];

            for(int x=row1;x<=row2;x++){
                result[x][col1]+=1;
                if(col2+1<n){
                    result[x][col2+1]-=1; 
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=1;j<n;j++){
                result[i][j]+=result[i][j-1];
            }
        }
        
        return result;
    }
}