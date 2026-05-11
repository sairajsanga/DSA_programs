class Solution {
    public int[] separateDigits(int[] nums) {
        int n=nums.length;
        List<Integer> list=new ArrayList<>();
        int idx=0;
        for(int i=n-1;i>=0;i--){
            int num=nums[i];
            while(num!=0){
               int digit=num%10;
               list.add(digit);
               num=num/10;
            }
        }
        Collections.reverse(list);

        int size=list.size();
        int result[]=new int[size];
        for(int i=0;i<size;i++){
            result[i]=list.get(i);
        }
        return result;

    }
}