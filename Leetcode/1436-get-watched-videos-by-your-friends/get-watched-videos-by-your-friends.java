class Solution {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        
        int n=friends.length;

        Queue<Integer> q=new LinkedList<>();
        boolean visited[]=new boolean[n];
        q.add(id);
        visited[id]=true;
        
        while(!q.isEmpty()&&level>0){
            
            int size=q.size();

            for(int i=0;i<size;i++){
                int curr=q.poll();

                for(int ele:friends[curr]){
                    if(!visited[ele]){    
                        q.offer(ele);
                    }
                    visited[ele]=true;
                }
            }
            level--;
        }

       HashMap<String,Integer> map=new HashMap<>();

       while(!q.isEmpty()){
          int curr=q.poll();

          for(String str:watchedVideos.get(curr)){
            map.put(str,map.getOrDefault(str,0)+1);
          }
       }

       List<String> result=new ArrayList<>();

       for(String str:map.keySet()){
           result.add(str);
       }

       Collections.sort(result,(a,b)-> map.get(a)==map.get(b) ? a.compareTo(b):map.get(a)-map.get(b));

       return result;
    }
}