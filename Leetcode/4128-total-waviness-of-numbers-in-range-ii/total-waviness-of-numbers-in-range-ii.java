class Solution {
    char digits[];
    long n; 
    Result dp[][][][][];
    

    class Result{
        long waves;
        long waviness;

        public Result(long waves,long waviness){
            this.waves=waves;
            this.waviness=waviness;
        }
    }


    public long totalWaviness(long num1, long num2) {
        return find(num2)-find(num1-1);
    }

    public long find(long num){
        this.digits=Long.toString(num).toCharArray();
        this.n=digits.length;
        this.dp=new Result[11][11][17][2][2];
        if(n<3) return 0;

        Result s=solve(-1,-1,0,true,true);
        return s.waviness;
    }

    public boolean isPeak(int prevPrev,int prev,int curr){
        if(prev > curr && prev > prevPrev || prev < curr && prev < prevPrev) return true;
        return false;
    }

    public Result solve(int prevPrev,int prev,int curr,boolean issame,boolean leadingZero){
        if(curr==n){
            return new Result(1,0);
        }

        if(prev!=-1 && dp[prevPrev+1][prev+1][curr][issame?1:0][leadingZero?1:0]!=null) return dp[prevPrev+1][prev+1][curr][issame?1:0][leadingZero?1:0];

        long totalwaves=0;
        long totalwaviness=0;
        int limit=issame?digits[curr]-'0':9;

        for(int digit=0;digit<=limit;digit++){
            boolean newleadingZero = leadingZero && (digit==0);
            boolean newtight = issame && (digit==limit);
            
            Result child;
            if(newleadingZero){
               child=solve(-1,-1,curr+1,newtight,true);
            }
            else{
                child=solve(prev,digit,curr+1,newtight,false);
                if(prevPrev!=-1 && prev!=-1){
                    if(isPeak(prevPrev,prev,digit)){
                        totalwaviness += child.waves;
                    }
                }
            }

            totalwaves+=child.waves;
            totalwaviness+=child.waviness;  
        }
        if(prev!=-1) dp[prevPrev+1][prev+1][curr][issame?1:0][leadingZero?1:0]=new Result(totalwaves,totalwaviness); 
        return new Result(totalwaves,totalwaviness);      
    }



}