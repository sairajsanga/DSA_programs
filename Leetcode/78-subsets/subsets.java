class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;
        this.result=new ArrayList<>();
        solve(nums,0,new ArrayList<>());
        return result;
    }
    public void solve(int nums[],int idx,List<Integer> list){
        if(idx>nums.length) return;
        if(idx==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        int num=nums[idx];
        list.add(num);
        solve(nums,idx+1,list);
        list.removeLast();
        solve(nums,idx+1,list);
    }
}