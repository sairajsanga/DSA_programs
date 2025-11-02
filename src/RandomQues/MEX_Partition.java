package RandomQues;

import java.util.HashSet;
import java.util.Scanner;

public class MEX_Partition {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                set.add(arr[i]);
            }
            int ans=0;
            for(int i=0;i<101;i++){
                if(!set.contains(i)){
                    ans=i;
                    break;
                }
            }
            System.out.println(ans);

        }
    }
}
