class Solution {
    public int largestPrime(int n) {
        List<Integer> list = new ArrayList<>();

        boolean prime[] = new boolean[n + 1];

        for (int i = 0; i <= n; i++) {
            prime[i] = true;
        }
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    prime[j] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            if (prime[i])
                primes.add(i);
        }

        int[] prefix = new int[primes.size() + 1];
        for (int i = 0; i < primes.size(); i++) {
            prefix[i + 1] = prefix[i] + primes.get(i);
            if (prefix[i + 1] > n)
                break;
        }

        int max=Integer.MIN_VALUE;
       for(int i=0;i<prefix.length;i++){
          int sum=prefix[i];
          if(sum<=n&&prime[sum]){
               max=Math.max(max,sum);
          } 
       }

       return max==Integer.MIN_VALUE?0:max;
    }
}