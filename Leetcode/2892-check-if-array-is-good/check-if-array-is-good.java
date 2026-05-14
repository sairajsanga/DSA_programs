class Solution {
    public boolean isGood(int[] nums) {
        int n = nums.length;
        int max = 0;
        HashMap<Integer,Integer> map=new HashMap<>();
        int total=0;
        for (int i = 0; i < n; i++) {
            total+=nums[i];
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
            max = Math.max(max, nums[i]);
        } 

        if(map.get(max)<2||map.get(max)>2) return false;

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int key=entry.getKey();
            int value=entry.getValue();

            if(key!=max&&value>1) return false;

        }

        int validsum=(max*(max+1))/2;
        if(validsum+max==total) return true;
        return false;

    }
}