package CodeForces;

import java.util.Scanner;

public class Fruits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count[] = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }
        int maxodd = Integer.MIN_VALUE;
        int mineven = Integer.MAX_VALUE;
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                if (count[i] % 2 != 0) {
                    if (count[i] > maxodd) {
                        maxodd = count[i];
                    }
                }
                if (count[i] % 2 == 0) {
                    if (count[i] < mineven) {
                        mineven = count[i];
                    }
                }
            }
        }
        System.out.println(maxodd - mineven);
    }
}
