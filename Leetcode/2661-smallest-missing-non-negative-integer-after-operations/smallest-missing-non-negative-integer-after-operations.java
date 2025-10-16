class Solution {
    public int findSmallestInteger(int[] nums, int value) {
       HashMap<Integer,Integer> map=new HashMap<>();
       
       int n=nums.length;
       for(int num:nums){
        int rem=(num%value+value)%value;
          map.put(rem,map.getOrDefault(rem,0)+1);
       }

       for(int i=0;i<=n+value;i++){
          if(map.containsKey(i%value)){
             map.put(i%value,map.getOrDefault(i%value,0)-1);
             if(map.get(i%value)==0){
                map.remove(i%value);
             }
          }
          else{
            return i;
          }
       }
       return -1;
    }
}