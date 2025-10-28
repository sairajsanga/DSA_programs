class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
       int n=nums.length;
       Map<Integer,Integer> map=new TreeMap<>();
       HashMap<Integer,Integer> freq=new HashMap<>();
       for(int ele:nums){
          freq.put(ele,freq.getOrDefault(ele,0)+1);
       }
       for(int i=0;i<n;i++){
        map.put(nums[i],0);
       }
       for(int i=0;i<n;i++){
          int ele=nums[i];
          int start=(nums[i]-k<0)?0:nums[i]-k;
          int end=nums[i]+k;
          map.put(start,map.getOrDefault(start,0)+1);
          map.put(end+1,map.getOrDefault(end+1,0)-1);
       }
       int curr = 0;
       for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
           curr += entry.getValue(); // add diff to running total
           map.put(entry.getKey(), curr); // store cumulative freq
        }
      int max=0;
      for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        int key=entry.getKey();
        int val=entry.getValue();
        if(val>0){
            int operations=Math.min(val-freq.getOrDefault(key,0),numOperations);
            max=Math.max(max,operations+freq.getOrDefault(key,0));
        }
      }
      return max;
    }
}