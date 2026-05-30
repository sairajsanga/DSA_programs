class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++) adj.add(new ArrayList<>());
        for(int nums[]:prerequisites){
            adj.get(nums[1]).add(nums[0]);
            indegree[nums[0]]++;
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }

        int count=0;
        while(!q.isEmpty()){
            int ele=q.poll();
            count++;

            for(int v:adj.get(ele)){
                indegree[v]--;
                if(indegree[v]==0){
                    q.add(v);
                }
            }
        }
        return count==numCourses;
    }
}