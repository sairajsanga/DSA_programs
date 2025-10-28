class Solution {
    public int[] dailyTemperatures(int[] nums) {
        int n=nums.length;
        int result[]=new int[n];

        Stack<Integer> stack=new Stack<>();

        for(int i=n-1;i>=0;i--){

            while(!stack.isEmpty()&&nums[stack.peek()]<=nums[i]){
                stack.pop();
            }
            if(!stack.isEmpty()){
                result[i]=stack.peek()-i;
            }
            stack.push(i);
        }
        return result;
    }
}