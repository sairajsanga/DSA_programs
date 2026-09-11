class Solution {
    public int totalNumbers(int[] digits) {
        int count[]=new int[10];

        for(int ele:digits){
            count[ele]++;
        }
        int ans=0;
        for(int i=100;i<1000;i+=2){
            int[] temp = count.clone();
            if(canform(i,temp)) ans++;
        }
        return ans;
    }

    public boolean canform(int num, int count[]) {

    while (num != 0) {
        int d = num % 10;

        if (count[d] > 0) {
            count[d]--;
            num /= 10;
        } else {
            break;
        }
    }

    return num == 0;
   }
}