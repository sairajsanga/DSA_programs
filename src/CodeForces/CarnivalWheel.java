package CodeForces;

import java.util.HashSet;
import java.util.Scanner;

public class CarnivalWheel {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int l=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();

            int max=Integer.MIN_VALUE;
            HashSet<Integer> set=new HashSet<>();
            for(int i=0;i<=5000;i++){
                int val=(a+(i*b))%l;
                if(set.contains(val)) break;
                else {
                    set.add(val);
                    max = Math.max(max, val);
                }
            }
            System.out.println(max);
        }
    }
}


