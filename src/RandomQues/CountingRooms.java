package RandomQues;

import java.util.Scanner;

public class CountingRooms {

    static char grid[][];
    static boolean visited[][];
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();

        grid=new char[n][m];

        for(int i=0;i<n;i++){
            grid[i]=sc.next().toCharArray();
        }

        visited=new boolean[n][m];

        int room=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='.'&& !visited[i][j]){
                    room++;
                    dfs(i,j);
                }
            }
        }
        System.out.println(room);
    }

    public static void dfs(int r,int c){

        if(r>=grid.length||r<0||c>=grid[0].length||c<0) return;

        if(grid[r][c]=='#'|| visited[r][c]) return;


        visited[r][c]=true;

        dfs(r-1,c);
        dfs(r+1,c);
        dfs(r,c-1);
        dfs(r,c+1);
    }
}
