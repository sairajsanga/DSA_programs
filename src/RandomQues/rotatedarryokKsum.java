package RandomQues;

import java.util.Arrays;

public class rotatedarryokKsum {
    public static void main(String[] args) {
        int arr[]={1,2,3,4};
        int k=2;
        int n=arr.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            for(int j=i+1;j<=i+k;j++){
                res[i]+=arr[j%n];
            }
        }
        System.out.println(Arrays.toString(res));
    }
}
