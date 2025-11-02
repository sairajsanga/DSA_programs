package CodeForces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EqualOcuurences {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int n=sc.nextInt();
            int arr[]=new int[n];
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            }
            int max=Integer.MIN_VALUE;
            for(Map.Entry<Integer,Integer> entry:map.entrySet()){
                int val=entry.getValue();
                int noofele=0;
                for(Map.Entry<Integer,Integer> entry2:map.entrySet()) {
                    int val2=entry2.getValue();
                    if(val2>=val){
                        noofele++;
                    }
                }
                max=Math.max(max,noofele*val);
            }
            System.out.println(max);
        }
    }

}
