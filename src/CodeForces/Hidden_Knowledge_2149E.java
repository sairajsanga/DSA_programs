package CodeForces;

import java.util.HashSet;
import java.util.Scanner;

public class Hidden_Knowledge_2149E {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
          int n=sc.nextInt();
          int k=sc.nextInt();
          int l=sc.nextInt();
          int r=sc.nextInt();

          int arr[]=new int[n];
          for(int i=0;i<n;i++){
              arr[i]=sc.nextInt();
          }
          int count=0;
          for(int i=l;i<=r;i++){
              int length=i;
              for(int j=0;j<n;j++){
                  HashSet<Integer> set=new HashSet<>();
                  if(j+length<=n){
                      for(int x=j;x<j+length;x++) {
                          set.add(arr[x]);
                      }
                  }
                  if(set.size()==k){
                      count++;
                  }
              }
          }
            System.out.println(count);
        }
    }
}
