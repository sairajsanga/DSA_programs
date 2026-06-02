class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n=nums.length;
        
        int newnums[]=new int[n];
        for (int i = 0; i < nums.length; i++) newnums[i] = nums[i];


        Arrays.sort(newnums);

        HashMap<Integer,Integer> numToGroup=new HashMap<>();
        int grpnum=0;
        numToGroup.put(newnums[0],grpnum);

        HashMap<Integer,LinkedList<Integer>> grpToList=new HashMap<>();

        grpToList.put(grpnum,new LinkedList<Integer>(Arrays.asList(newnums[0])));

        for(int i=1;i<n;i++){
            if(Math.abs(newnums[i]-newnums[i-1])>limit){
                grpnum++;
            }

            numToGroup.put(newnums[i],grpnum);
            if(!grpToList.containsKey(grpnum)){
                grpToList.put(grpnum,new LinkedList<Integer>());
            }
            grpToList.get(grpnum).add(newnums[i]);
        }

        int result[]=new int [n];
        for(int i=0;i<n;i++){
            int num=nums[i];
            int group=numToGroup.get(num);

            nums[i]=grpToList.get(group).pollFirst();
        }

        return nums;
    }
}