class Solution {
    public int[] asteroidCollision(int[] nums) {
        int n=nums.length;


        Stack<Integer> stack=new Stack<>();
       
        for(int i=0;i<n;i++){
            
           if(nums[i]<0){
                while(!stack.isEmpty() && stack.peek()>0 && stack.peek()<Math.abs(nums[i])){
                    stack.pop();
                } 

                if(stack.isEmpty()||stack.peek()<0){
                    stack.push(nums[i]);
                }else if(stack.peek()+nums[i]==0){
                   stack.pop();
                }
           } 
           else{
           stack.push(nums[i]); 
           }      
        }
        int res[]=new int[stack.size()];
        int idx=stack.size()-1;
        while(!stack.isEmpty()){
           
           res[idx]=stack.pop();
           idx--;
        }
        return res;
        
    }
}