class Solution {
    public boolean asteroidsDestroyed(int mass, int[] nums) {
        
        int n=nums.length;
        Arrays.sort(nums);

        // int i=0;
        // long dup=mass;
        // while(i<n){
        //     if(nums[i]>dup) return false;
        //     else{
        //         dup+=nums[i];    
        //     }
        //     i++;
        // }

        // return true;

        return DFS((long)mass,nums,0);

        
    }

    public boolean DFS(long mass,int asteroids[],int start){
        if(mass<asteroids[start]) return false;
        if(start>=asteroids.length) return false;

        if(start==asteroids.length-1) return true;

        return DFS(mass+asteroids[start],asteroids,start+1);
    }

}