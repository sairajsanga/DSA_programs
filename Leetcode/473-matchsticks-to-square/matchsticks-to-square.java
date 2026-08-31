import java.util.*;

class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;

        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % 4 != 0) return false;
        int side = sum / 4;

        Arrays.sort(nums);
        reverse(nums); // descending order

        int[] sides = new int[4];
        return backtrack(nums, 0, sides, side);
    }

    private boolean backtrack(int[] nums, int index, int[] sides, int target) {
        if (index == nums.length) {
            return sides[0] == target &&
                   sides[1] == target &&
                   sides[2] == target &&
                   sides[3] == target;
        }

        int stick = nums[index];

        for (int i = 0; i < 4; i++) {
            if (sides[i] + stick > target) continue;

            sides[i] += stick;

            if (backtrack(nums, index + 1, sides, target)) {
                return true;
            }

            sides[i] -= stick;

            // pruning:
            // if this side was 0 before placing, don't try other empty sides
            if (sides[i] == 0) break;
        }

        return false;
    }

    private void reverse(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}