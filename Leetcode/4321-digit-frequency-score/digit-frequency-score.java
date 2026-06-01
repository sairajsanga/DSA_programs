class Solution {
    public int digitFrequencyScore(int n) {
        
        int freq[]=new int[10];
        int total=0;

        while(n!=0){
            int rem=n%10;
            freq[rem]++;
            n=n/10;
        }

        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                int sum=i*freq[i];
                total+=sum;
            }
        }

        return total;

    }
}