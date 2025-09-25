class Solution {
    String res="";
    public String findDifferentBinaryString(String[] nums) {
        Set<String> s=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            s.add(nums[i]);
        }
        helper(nums,"",s);
        return res;
    }
    public void helper(String nums[],String str,Set<String> set){
        if(str.length()>nums.length){
            return;
        }
        if(str.length()==nums.length){
            if(!set.contains(str)){
                res=""+str;
            }
            else{
               return;
            }  
        }
        helper(nums,str+'1',set);
        helper(nums,str+'0',set);
    }
}