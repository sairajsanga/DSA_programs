class Solution {
    public int maxSumDivThree(int[] nums) {
        int total = 0;
        List<Integer> rem1 = new ArrayList<>();
        List<Integer> rem2 = new ArrayList<>();
        
        for (int num : nums) {
            total += num;
            if (num % 3 == 1) rem1.add(num);
            else if (num % 3 == 2) rem2.add(num);
        }
        
        Collections.sort(rem1);
        Collections.sort(rem2);
        
        if (total % 3 == 0) return total;
        if (total % 3 == 1) {
            int remove1 = rem1.size() >= 1 ? rem1.get(0) : Integer.MAX_VALUE;
            int remove2 = rem2.size() >= 2 ? rem2.get(0) + rem2.get(1) : Integer.MAX_VALUE;
            return total - Math.min(remove1, remove2);
        } else { // total % 3 == 2
            int remove1 = rem2.size() >= 1 ? rem2.get(0) : Integer.MAX_VALUE;
            int remove2 = rem1.size() >= 2 ? rem1.get(0) + rem1.get(1) : Integer.MAX_VALUE;
            return total - Math.min(remove1, remove2);
        }
    }
}