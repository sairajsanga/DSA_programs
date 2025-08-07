package harry_programs;

import java.util.Scanner;

public class pallelogram_pattern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // hollow paralleogram
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= n; j++) {
                if (i == 1 || i == n || j == 1 || j == n) {
                    System.out.print("*");
                } else {
                    for (int k= 2; k <= n-k-1; k++) {
                        if (k== 1 || k == n) {
                            System.out.print("");
                        } else {
                            System.out.print(" ");
                        }
                    }
                }

            }
            // solid parallelogram
            /*for(int i=1;i<=n;i++){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }*/
        /*for(int i=n;i>=1;i--){
            for(int j=1;j<=n-i;j++){
                System.out.print(" ");
            }
            for(int j=1;j<=n;j++){
                System.out.print("*");
            }
            System.out.println();
        }*/
            System.out.println();
        }
    }
}

