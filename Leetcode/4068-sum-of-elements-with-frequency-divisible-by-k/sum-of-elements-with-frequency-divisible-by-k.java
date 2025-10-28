class Solution {
    public int sumDivisibleByK(int[] nums, int k) {
       int n=nums.length; 
       HashMap<Integer,Integer> map=new HashMap<>();
       for(int ele:nums){
        map.put(ele,map.getOrDefault(ele,0)+1);
       }
       int sum=0;
       for(Map.Entry<Integer,Integer> entry:map.entrySet()){
           int ele=entry.getKey();
           int freq=entry.getValue();
           if(freq%k==0){
            sum+=(ele*freq);
           }
       }
       return sum;
    }
}