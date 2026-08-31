package RandomQues;

public class SubsetSum {
    static Boolean dp[][];
    public static void main(String[] args) {
        int arr[]={3,34,5,4,12,2};
        int sum=10;
        dp=new Boolean[arr.length+1][sum+1];

        System.out.println(solve(arr,0,sum));
    }

    public static  boolean  solve(int arr[],int idx,int sum){

        if(sum==0) return true;

        if(idx>=arr.length||sum<0) return false;

        if(dp[idx][sum]!=null){
            return dp[idx][sum];
        }

        boolean take=solve(arr,idx+1,sum-arr[idx]);
        boolean  skip=solve(arr,idx+1,sum);

        return dp[idx][sum]=take||skip;

    }
}
