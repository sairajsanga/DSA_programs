
package RandomQues;
import java.util.HashMap;
import java.util.Scanner;

public class Codeforeces_contest_1054_Div_3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++){
            int a=sc.nextInt();
            int arr[]=new int[a];
            for(int j=0;j<arr.length;j++){
                arr[j]=sc.nextInt();
            }
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=0;j<arr.length;j++){
                map.put(arr[j],map.getOrDefault(arr[j],0)+1);
            }
            int neg=map.getOrDefault(-1,0);
            int zero=map.getOrDefault(0,0);
            int pos=map.getOrDefault(1,0);
            if(neg%2!=0){
               System.out.print(zero+2);
            }
            else{
                System.out.print(zero);
            }
        }
    }
}
