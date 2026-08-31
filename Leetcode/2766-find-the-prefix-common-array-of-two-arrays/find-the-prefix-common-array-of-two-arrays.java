class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;

        int res[]=new int[n];


        HashSet<Integer> setA=new HashSet<>();
        HashSet<Integer> setB=new HashSet<>();
        
       
        for(int i=0;i<n;i++){
            setA.add(A[i]);
            setB.add(B[i]);

            int count=0;
            for(int ele:setA){
                if(setB.contains(ele)){
                    count++;
                }
            }
            res[i]=count;
        }
        

        return res;

      
    }
}