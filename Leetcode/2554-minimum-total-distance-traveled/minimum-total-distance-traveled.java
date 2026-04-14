class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        
        

        Collections.sort(robot);

        Arrays.sort(factory,(a,b)->a[0]-b[0]);
        List<Integer> factoryPositions=new ArrayList<>();
        for(int []f:factory){
            for(int i=0;i<f[1];i++){
                factoryPositions.add(f[0]);
            }
        }
        int robotcount=robot.size();
        int factorycount=factoryPositions.size();
        long memo[][]=new long[robotcount][factorycount];

        for(long a[]:memo){
            Arrays.fill(a,-1);
        }

        return helper(0,0,robot,factoryPositions,memo);
    }

    public long helper(int robotidx,int factoryidx,List<Integer> robot,List<Integer>factoryPositions,long [][]memo){
        if(robotidx==robot.size()) return 0;

        if(factoryidx==factoryPositions.size()){
            return (long)1e12;
        }

        if(memo[robotidx][factoryidx]!=-1) return memo[robotidx][factoryidx];
        

        //taking the current robot

        long take=Math.abs(robot.get(robotidx)-factoryPositions.get(factoryidx))+
                                                      helper(robotidx+1,factoryidx+1,robot,factoryPositions,memo);


        //skip the current factory

        long skip= helper(robotidx,factoryidx+1,robot,factoryPositions,memo);


        return memo[robotidx][factoryidx]=Math.min(take,skip);
    }
}