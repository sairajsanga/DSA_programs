class Solution {
    public long[] distance(int[] nums) {
        
        int n=nums.length;

        long res[]=new long[n];

        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
            map.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);   
        }
        

        for(List<Integer> list:map.values()){
            int size=list.size();

            long prefix[]=new long[size];

            prefix[0]=list.get(0);
            for(int i=1;i<size;i++){
                prefix[i]=prefix[i-1]+list.get(i);
            }

            for(int i=0;i<size;i++){
                long idx=list.get(i);

                long sumLeft=(i>0)?prefix[i-1]:0;

                long sumRight=prefix[size-1]-prefix[i];

                long countLeft=i;

                long countRight=size-1-i;

                long left = idx * countLeft - sumLeft;
                long right = sumRight - idx * countRight;

                res[(int)idx]=left+right;
            }

        }
        
        return res;
    }
}