import java.util.Scanner;

public class removing_repeated_char {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str=sc.nextLine();
        char []ch=str.toCharArray();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ch.length;i++){
            boolean repeated=false;
            for(int j=i+1;j<ch.length;j++){
                if(ch[i]==ch[j]){
                    repeated=true;
                    break;
                }
            }
            if(!repeated) {
                sb.append(ch[i]);
            }
        }
        System.out.print(sb);
    }
}
