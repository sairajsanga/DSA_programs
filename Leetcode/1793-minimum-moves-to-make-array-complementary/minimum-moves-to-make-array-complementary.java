class Solution {
    public int minMoves(int[] nums, int limit) {
        int n = nums.length;

        int diff[] = new int[2 * limit + 2];
        int min = n;
        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n-1-i];

            int minValue=a<b?a+1:b+1;
            int maxValue=a>b?a+limit:b+limit;

            diff[2]+=2;
            diff[2*limit+1]-=2;
            diff[minValue]+=-1;
            diff[maxValue+1]-=-1;
            diff[a+b]+=-1;
            diff[a+b+1]-=-1;
        }

        int curr = 0;
        for (int i = 2; i <= 2 * limit; i++) {
            curr += diff[i];
            min = Math.min(min, curr);
        }

        return min;
    }
}