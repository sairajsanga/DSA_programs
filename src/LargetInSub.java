import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LargetInSub {
    public static void main(String[] args) {
        int arr[]={10, 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int k=3;
        List<Integer> list=new ArrayList<>();
        System.out.println(ListofLarEle(arr,list,k));
    }
    public static List<Integer> ListofLarEle(int nums[],List<Integer> list ,int k){
        int i=0;
        int j=0;
        int max=nums[0];
        while(j<nums.length){
           int window[]= Arrays.copyOfRange(nums,i,j+1);
           if(j-i+1<k){
               j++;
           }
           else if(j-i+1==k) {
               int ele = gethighest(window);
               list.add(ele);
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
