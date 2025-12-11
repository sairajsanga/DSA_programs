class Solution {
    public List<Integer> pancakeSort(int[] arr) {
       List<Integer> list=new ArrayList<>();
       for(int i=arr.length-1;i>=0;i--){
           int largestindex=findIndex(arr,i);
           swap(arr,largestindex);
           swap(arr,i);
           list.add(largestindex+1);
           list.add(i+1);
       }
       return list;
    }

    public void swap(int nums[], int j) {
        int i = 0;
        while (i < j) {
            int temp = nums[j];
            nums[j] = nums[i];
            nums[i] = temp;
            i++;
            j--;
        }
    }

    public int findIndex(int[] arr, int k) {
        int index = k;
        for (int i = k - 1; i >= 0; i--) {
            if (arr[i] > arr[index])
                index = i;
        }
        return index;
    }
}