class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        
        int n=nums.length;

        int freq[]=new int[101];

        for(int i=0;i<n;i++){
            freq[nums[i]]++;
        }
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                int num=i;
                int f=freq[i];
                if(f>=k){
                   for(int j=0;j<k;j++){
                      list.add(num);
                   } 
                }
                else{
                    for(int j=0;j<f;j++){
                        list.add(num);
                    }
                }
            }
        }

        int res[]=new int[list.size()];

        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }

        return res;
    }
}