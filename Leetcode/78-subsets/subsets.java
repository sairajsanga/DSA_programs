class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        int n=nums.length;

        List<List<Integer>> result=new ArrayList<>();
        List<Integer> innerList=new ArrayList<>();

        helper(nums,0,result,innerList);
        return result;
    }

    public void helper(int nums[],int start,List<List<Integer>> result,List<Integer> list){

        if(start==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }


        list.add(nums[start]);
        helper(nums,start+1,result,list);
        list.remove(list.size()-1);
        helper(nums,start+1,result,list);        
    }
}