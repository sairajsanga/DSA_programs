class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;

        return helper(arr, start);
    }

    public boolean  helper(int arr[], int start) {

        if (start >= arr.length || start < 0||arr[start]<0)
            return false;

        if(arr[start]==0) return true;

        int jumpindex=arr[start];
        arr[start]=-1;

        boolean right = helper(arr, start + jumpindex);

        boolean left = helper(arr, start - jumpindex);

        return right||left;
    }
}