package RandomQues;

public class LongestPath_SAP {
    public static void main(String[] args) {
       int n=2;
       int m=2;
       int grid[][]={
               {2,1},
               {1,2}
       };
        System.out.println(Longestpath(grid,n,m,0,0));
    }
    public static int Longestpath(int grid[][],int n,int m,int i,int j){
        if(i>=n||j>=m){
            return Integer.MIN_VALUE;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
        int current=grid[i][j];
        int longest=Integer.MIN_VALUE;
        if(j+1<m&&grid[i][j+1]>current){
            int right=Longestpath(grid,n,m,i,j+1);
            if(right!=Integer.MIN_VALUE){
                longest=Math.max(longest,1+right);
            }
        }
        if(i+1<n&&grid[i+1][j]>current){
            int down=Longestpath(grid,n,m,i+1,j);
            if(down!=Integer.MIN_VALUE){
                longest=Math.max(longest,1+down);
            }
        }
        return longest==Integer.MIN_VALUE?-1:longest;
    }
}
