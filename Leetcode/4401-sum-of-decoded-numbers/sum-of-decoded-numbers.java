class Solution {
    long mod = 1000000007L;

    public int sumDecoded(long[] nums) {

        int n = nums.length;

        long total = 0;

        for (int i = 0; i < n; i++) {
            long num=nums[i];
            long width = num % 10;
            long d = num / 10;

            String s = Long.toString(d);
            
            if (width > s.length()) continue;
                
            long sub = Long.parseLong(s.substring(0, (int) width));
            long rem = Long.parseLong(s.substring((int) width));

            long ans = power(sub,rem);
            total = (total + ans) % mod;
        }
        return (int)total;

    }

    public long power(long x, long y) {

        long result = 1;

        x %= mod;

        while (y > 0) {

            if (y % 2 == 1) {
                result = (result * x) % mod;
            }

            x = (x * x) % mod;

            y /= 2;
        }

        return result%mod;
    }
}