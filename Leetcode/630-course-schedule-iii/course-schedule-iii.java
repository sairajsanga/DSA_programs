class Solution {
    public int scheduleCourse(int[][] courses) {
        int n=courses.length;
        
        Arrays.sort(courses,(a,b)->{
            if(a[1]!=b[1]) return a[1]-b[1];
            return a[0]-b[0];
        });

        PriorityQueue<Integer> q=new PriorityQueue<>((a,b)->b-a);


        int currTime=0;

        for(int c[]:courses){
            int duration=c[0];
            int lastday=c[1];

            if(currTime+duration<=lastday){
                currTime+=duration;
                q.add(duration);
            }
            else if(!q.isEmpty()){
                int peek=q.peek();
                if(peek>duration && currTime-peek+duration<=lastday){
                    q.poll();
                    currTime+=duration-peek;
                    q.add(duration);
                }
            }
        }


        return q.size();

           
    }
}