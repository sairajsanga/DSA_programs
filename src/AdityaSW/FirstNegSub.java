package AdityaSW;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegSub {
    public static void main(String[] args) {
        int arr[]={-8,2,3,-6,10};
        int k=2;
        List<Integer> integers = firstNegInt(arr, k);
        System.out.println(integers);
    }
    public static List<Integer> firstNegInt(int arr[], int k) {
        Queue<Integer> list=new LinkedList<>();
        List<Integer> l=new ArrayList<>();
        int i=0;
        int j=0;
        int n=arr.length;
        while(j<n){
            if(arr[j]<0){
                list.offer(arr[j]);
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(list.isEmpty()){
                    l.add(0);
                }
                else{
                    l.add(list.peek());
                }
                if(!list.isEmpty()&&arr[i]==list.peek()){
                    list.poll();
                }
                i++;
                j++;
            }
        }
        return l;
    }
}