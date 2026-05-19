class Solution {
    
    public int minJumps(int[] arr) {
        int n=arr.length;
        
        HashMap<Integer,List<Integer>> map=new HashMap<>();

        for(int i=0;i<n;i++){
           map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }
        
        boolean visited[]=new boolean[n];

        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0,0});
        visited[0]=true;
        while(!q.isEmpty()){
            int curr[]=q.poll();
            int idx=curr[0];
            int steps=curr[1];
            
            if(idx==n-1) return steps;

            if(idx+1<n&&!visited[idx+1]){
               visited[idx+1]=true;
               q.offer(new int[]{idx+1,steps+1});
            }

            if(idx-1>=0&&!visited[idx-1]){
                visited[idx-1]=true;
                q.offer(new int[]{idx-1,steps+1});
            }

            //check the similar value in array

            int val=arr[idx];

            if(map.containsKey(val)){
                for(int nextidx:map.get(val)){
                    if(!visited[nextidx]){
                        if(nextidx==n-1) return steps+1;
                        visited[nextidx]=true;
                        q.offer(new int[]{nextidx,steps+1});
                    }
                }
                map.remove(val);
            }
           
        }

        
        return -1;
    }

   
}