class Solution {
    int modulo=1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        List<Integer> sums=new ArrayList<>();
        int prefix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=(prefix[i-1]+nums[i])%modulo;
        }
        for(int ele:prefix){
            sums.add(ele);
        }
        for(int i=0;i<prefix.length-1;i++){
            for(int j=i+1;j<prefix.length;j++){
                sums.add((prefix[j]-prefix[i]+modulo)%modulo);
            }
        }
        Collections.sort(sums);
        int l=left-1;
        int r=right-1;
        int sum=0;
        for(int i=l;i<=r;i++){
            sum=(sum+sums.get(i))%modulo;
        }
        return (int)sum;
    }
}