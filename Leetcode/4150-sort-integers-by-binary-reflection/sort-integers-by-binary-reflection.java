class Solution {
    class Pair{
        int num;
        int index;

        public Pair(int num,int index){
            this.num=num;
            this.index=index;
        }

    }
    public int[] sortByReflection(int[] nums) {
        int n=nums.length;
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            int ele=nums[i];
            String s=Integer.toBinaryString(ele);
            String rev=reverse(s);
            int revnum=Integer.parseInt(rev,2);
            list.add(new Pair(revnum,i));
        }
        Collections.sort(list,(a,b)->{
            if(a.num==b.num) return nums[a.index]-nums[b.index];
            return a.num-b.num;
        });
        int res[]=new int[n];
        int x=0;
        for(Pair p:list){
            int num=p.num;
            int ind=p.index;
            res[x++]=nums[ind];
        }
        return res;
    }
    public String reverse(String s){
        StringBuilder str=new StringBuilder(s);
        return str.reverse().toString();
    }
}