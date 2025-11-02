package RandomQues;

import java.util.Scanner;

public class MEX_Rose {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int k=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            int freq[]=new int[n+1];
            int count=0;
            for(int i=0;i<n;i++){
               freq[arr[i]]++;
               count=freq[k];
            }
            int miss=0;
            for(int i=0;i<k;i++){
                if(freq[i]==0) miss++;
            }
            int max=count+Math.max(0,miss-count);
            System.out.println(max);
        }
    }
}
