package RandomQues;

import java.util.Scanner;

public class codeforces {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            String s1=sc.next();
            String s2=sc.next();

            int count1[]=new int[26];

            for(char ch:s1.toCharArray()){
                count1[ch-'a']++;
            }
            for(char ch:s2.toCharArray()){
                count1[ch-'a']--;
            }
            boolean flag=true;
            for(int ele:count1){
                if(ele>0){
                    flag=false;
                    break;
                }
            }
            if(flag){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
        }
    }
}
