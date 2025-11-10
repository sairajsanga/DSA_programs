class Solution {
    public int minOperations(int[] nums) {
        int n=nums.length;
        Stack<Integer> stack=new Stack<>();
        int count=0;
        
        boolean flag=false;
        for(int i=0;i<n;i++){
            if (nums[i] == 0) {
                stack.clear();
               continue;
            }
            while(!stack.isEmpty()&&nums[i]<stack.peek()){
                flag=false;
                stack.pop();
            }
            if(stack.isEmpty()||nums[i]>stack.peek()){
                flag=true;
                stack.push(nums[i]);
                count++;  
            } 
        }
        return count;
    }   
}