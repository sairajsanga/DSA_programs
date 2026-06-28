class Solution {
    public int maximumLength(int[] nums) {
         int n=nums.length;

        HashMap<Integer,Integer> map=new HashMap<>();

        for(int i=0;i<n;i++) map.put(nums[i],map.getOrDefault(nums[i],0)+1);

        int cnt=0;
        for(int ele:nums) if(ele==1) cnt++;

        

        int result=(cnt&1)==1?cnt:cnt-1;
        for(int i=0;i<n;i++){
            int num=nums[i];
            if(num==1) continue;
            int len=0;
            int k=num;
            while(map.getOrDefault(k,0)>1){
                len+=2;
                k=k*k;
            }
            if(map.containsKey(k)){
                if(map.get(k)==1){
                    len+=1;
                }
            }else{
                len-=1;
            }

            result=Math.max(result,len);
        }
        return result==Integer.MIN_VALUE?1:result;

    }
    
}