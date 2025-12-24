class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        int n=apple.length;
        int m=capacity.length;

        int totalapples=0;
        for(int i=0;i<n;i++){
            totalapples+=apple[i];
        }

        Arrays.sort(capacity);
        int target=totalapples;
        int count=0;
        for(int i=m-1;i>=0;i--){
            totalapples=totalapples-capacity[i];
            count++;
            if(totalapples<=0) return count;
        }
        return count;
    }
}