class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m=mat.length;
        int n=mat[0].length;
        int answer[][]=new int[mat.length][mat[0].length];

        for(int i=0;i<mat.length;i++){
            
            for(int j=0;j<mat[0].length;j++){
                int rmin=i-k;
                int rmax=i+k;
                int cmin=j-k;
                int cmax=j+k;
                if(rmin<0) rmin=0;
                if(cmin<0) cmin=0;
                if(rmax>=m) rmax=m-1;
                if(cmax>=n) cmax=n-1;
                int sum=0;
                for(int x=rmin;x<=rmax;x++){
                    for(int y=cmin;y<=cmax;y++){
                        sum+=mat[x][y];
                    }
                }
                answer[i][j]=sum;
            }
        }
        return answer;
    }
}