class Solution {
    public int numberOfPoints(List<List<Integer>> cars) {
        int freq[]=new int[102];
        int count=0;
        for(List<Integer> car:cars){
            int start=car.get(0);
            int end=car.get(1);
            freq[start]++;
            freq[end+1]--;
        }
        int prefix[]=new int[freq.length];
        for(int i=1;i<freq.length;i++){
            prefix[i]=prefix[i-1]+freq[i-1];
        }
        for(int ele:prefix){
            if(ele>0) count++;
        }
        return count;
    }
}