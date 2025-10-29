class Solution {
    public int smallestNumber(int n) {
        int pow=(int)(Math.log(n)/Math.log(2))+1;
        return (int)Math.pow(2,pow)-1;
    }
}