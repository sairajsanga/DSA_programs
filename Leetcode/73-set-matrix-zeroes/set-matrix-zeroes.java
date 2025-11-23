class Solution {
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean temp[][]=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0){
                    temp[i][j]=true;
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(temp[i][j]){
                    Arrays.fill(matrix[i],0);
                    for(int row=0;row<m;row++){
                        matrix[row][j]=0;
                    }
                }
            }
        }   
    }
}