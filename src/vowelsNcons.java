import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class vowelsNcons {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
       String str=sc.nextLine();
        System.out.println(rearrange(str));

    }
    public static String rearrange(String str){
        Queue<Character> vowels=new LinkedList<>();
        Queue<Character> cons=new LinkedList<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                vowels.offer(str.charAt(i));
            }
            else{
                cons.offer(str.charAt(i));
            }
        }

        for(int i=0;i<str.length();i++){
            if(i%2==0){
                sb.append(cons.poll());
            }
            else{
                sb.append(vowels.poll());
            }
        }
        return sb.toString();
    }
}
