class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        
        int result[][]=new int[n+1][n+1];
        for(int []query:queries){
            int row1=query[0];
            int col1=query[1];
            int row2=query[2];
            int col2=query[3];

            result[row1][col1]+=1;
            result[row2+1][col1]-=1;
            result[row1][col2+1]-=1;
            result[row2+1][col2+1]+=1;
        }
        int mat[][]=new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = (i == 0) ? 0 : mat[i - 1][j];
                int x2 = (j == 0) ? 0 : mat[i][j - 1];
                int x3 = (i == 0 || j == 0) ? 0 : mat[i - 1][j - 1];
                mat[i][j] = result[i][j] + x1 + x2 - x3;
            }
        }
        return mat;
    }
}