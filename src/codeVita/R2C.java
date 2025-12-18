package codeVita;

import java.util.*;
public class R2C {
    static int S;
    static char[][][] G;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static boolean in(int z,int r,int c){return z>=0&&z<S&&r>=0&&r<S&&c>=0&&c<S;}
    static boolean walk(int z,int r,int c){return in(z,r,c)&&G[z][r][c]!='E';}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        if(!sc.hasNextInt()) return;
        S=sc.nextInt();
        G=new char[S][S][S];
        for(int z=0;z<S;z++){
            for(int r=0;r<S;r++){
                String line=sc.next();
                while(line.length()<S) line+=sc.next();
                for(int c=0;c<S;c++) G[z][r][c]=line.charAt(c);
            }
        }
        int sz=sc.nextInt(), sr=sc.nextInt(), scol=sc.nextInt();
        int gz=sc.nextInt(), gr=sc.nextInt(), gc=sc.nextInt();
        if(!walk(sz,sr,scol) || !walk(gz,gr,gc)){ System.out.println(-1); return; }
        boolean[][][] vis=new boolean[S][S][S];
        int[][][] dist=new int[S][S][S];
        ArrayDeque<int[]> q=new ArrayDeque<>();
        q.add(new int[]{sz,sr,scol});
        vis[sz][sr][scol]=true;
        dist[sz][sr][scol]=0;
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int z=cur[0], r=cur[1], c=cur[2];
            if(z==gz && r==gr && c==gc){ System.out.println(dist[z][r][c]); return; }
            for(int k=0;k<4;k++){
                int nr=r+dr[k], nc=c+dc[k];
                if(walk(z,nr,nc) && !vis[z][nr][nc]){ vis[z][nr][nc]=true; dist[z][nr][nc]=dist[z][r][c]+1; q.add(new int[]{z,nr,nc}); }
            }
            char ch=G[z][r][c];
            if(ch=='L'){
                int nz=z, nr2=r-1, nc2=c-1;
                if(walk(nz,nr2,nc2) && !vis[nz][nr2][nc2]){ vis[nz][nr2][nc2]=true; dist[nz][nr2][nc2]=dist[z][r][c]+1; q.add(new int[]{nz,nr2,nc2}); }
            }
            if(ch=='R'){
                int nz=z, nr2=r-1, nc2=c+1;
                if(walk(nz,nr2,nc2) && !vis[nz][nr2][nc2]){ vis[nz][nr2][nc2]=true; dist[nz][nr2][nc2]=dist[z][r][c]+1; q.add(new int[]{nz,nr2,nc2}); }
            }
            if(ch=='F'){
                int nz=z+1, nr2=r, nc2=c;
                if(walk(nz,nr2,nc2) && !vis[nz][nr2][nc2]){ vis[nz][nr2][nc2]=true; dist[nz][nr2][nc2]=dist[z][r][c]+1; q.add(new int[]{nz,nr2,nc2}); }
            }
            if(ch=='B'){
                int nz=z-1, nr2=r, nc2=c;
                if(walk(nz,nr2,nc2) && !vis[nz][nr2][nc2]){ vis[nz][nr2][nc2]=true; dist[nz][nr2][nc2]=dist[z][r][c]+1; q.add(new int[]{nz,nr2,nc2}); }
            }
            // reverse connections: tiles elsewhere that connect to current
            if(walk(z,r+1,c+1) && G[z][r+1][c+1]=='L' && !vis[z][r+1][c+1]){ vis[z][r+1][c+1]=true; dist[z][r+1][c+1]=dist[z][r][c]+1; q.add(new int[]{z,r+1,c+1}); }
            if(walk(z,r+1,c-1) && G[z][r+1][c-1]=='R' && !vis[z][r+1][c-1]){ vis[z][r+1][c-1]=true; dist[z][r+1][c-1]=dist[z][r][c]+1; q.add(new int[]{z,r+1,c-1}); }
            if(walk(z-1,r,c) && G[z-1][r][c]=='F' && !vis[z-1][r][c]){ vis[z-1][r][c]=true; dist[z-1][r][c]=dist[z][r][c]+1; q.add(new int[]{z-1,r,c}); }
            if(walk(z+1,r,c) && G[z+1][r][c]=='B' && !vis[z+1][r][c]){ vis[z+1][r][c]=true; dist[z+1][r][c]=dist[z][r][c]+1; q.add(new int[]{z+1,r,c}); }
        }
        System.out.println(-1);
    }
}

