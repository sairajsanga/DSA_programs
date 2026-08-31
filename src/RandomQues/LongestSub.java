package RandomQues;

import java.util.Arrays;

public class LongestSub {
    public static void main(String[] args) {
        int arr[]={100,4,200,1,3,2};
        // 1,2,3,4,100,200

        Arrays.sort(arr);
        int n=arr.length;
        int j=1;
        int len=1;
        int max=-1;
        while(j<n){
            if(arr[j]-arr[j-1]==1){
                len++;
                max=Math.max(max,len);
            }
            else{
                len=0;
            }
        }

        System.out.println(max);

    }
}
