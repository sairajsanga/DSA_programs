package RandomQues;

public class binarysearch_nextgreaterEle {
    public static void main(String[] args) {
        int arr[]={1,1,3,4};
        System.out.println(binarySearch(arr,3));
    }
    public static int binarySearch(int arr[],int target){
        int low=0;
        int high=arr.length-1;
        while(low<=high){
           int mid=low+(high-low)/2;
           if(arr[mid]<=target){
               low=mid+1;
           }
           else if(arr[mid]>target){
               high=mid-1;
           }
        }
        return arr[low];
    }
}
