package AdityaSW;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class LargetInSub {
    static class Pair{
        int value;
        int index;
        Pair(int value,int index){
            this.value=value;
            this.index=index;
        }
    }
    public static void main(String[] args) {
        int arr[]={ 1, 8, 9,7,10, 6, 5, 4, 3, 2 };
        int k=3;
        List<Integer> list=new ArrayList<>();
        System.out.println(ListofLarEle(arr,list,k));
    }
    public static List<Integer> ListofLarEle(int nums[],List<Integer> list ,int k){
        int i=0;
        int j=0;
        int max=-1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->{
           return (b.value-a.value);
        });
        while(j<nums.length){
             pq.offer(new Pair(nums[j],j));
           if(j-i+1<k){
               j++;
           }
           else if(j-i+1==k) {
               while(i>pq.peek().index){
                   pq.poll();
               }
               list.add(pq.peek().value);
               i++;
               j++;
           }

        }
        return list;
    }
    public static int gethighest(int nums[]){
        Arrays.sort(nums);
        return nums[nums.length-1];
    }
}
