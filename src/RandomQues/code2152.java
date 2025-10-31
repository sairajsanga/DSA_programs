package RandomQues;

import java.util.Scanner;

public class code2152 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            System.out.println(minNumberOperations(arr));
        }
    }
    public static int minNumberOperations(int[] target) {
        int count=target[0];
        int counts=1;
        for(int i=1;i<target.length;i++){
            count+=Math.max(target[i]-target[i-1],0);
            if(count!=0){
                counts++;
            }
        }
        return counts;
    }
}
