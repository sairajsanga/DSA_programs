class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        int n=arr.length;
        int min=Integer.MAX_VALUE;
        Arrays.sort(arr);
        for(int i=0;i<n-1;i++){
            min=Math.min(min,arr[i+1]-arr[i]);  
        }

        int mindiff=min;
        
        List<List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n-1;i++){
           if(arr[i+1]-arr[i]==mindiff){
              result.add(Arrays.asList(arr[i],arr[i+1]));
           }
        }
        return result;
    }
    // public int getminimum(int arr[]){
    //     for(int i=0;i<arr.length;i++){
    //         if(arr[i]<0){
    //             arr[i]=arr[i]*-1;
    //         }
    //     }

    //     Arrays.sort(arr);
    //     return arr[1]-arr[0];
    // }
}