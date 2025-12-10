class Solution {

    public int minMirrorPairDistance(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++){
           int rev=reverse(nums[i]);
           if(map.containsKey(nums[i])){
              min=Math.min(min,i-map.get(nums[i]));
           }
           map.put(rev,i);
        }
        return min==Integer.MAX_VALUE?-1:min;       
    }
    public int reverse(int num){
        int sum=0;
        while(num>0){
            int rem=num%10;
            sum=sum*10+rem;
            num=num/10;
        }
        return sum;
    }
}