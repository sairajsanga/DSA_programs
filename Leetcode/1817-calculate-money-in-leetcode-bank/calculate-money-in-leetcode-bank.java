class Solution {
    public int totalMoney(int n) {
        if(n<=7) return (n*(n+1))/2;
        int weeks=(n/7);
        int remaning=n%7;
        
        int total=((weeks*(weeks-1))/2)*7;
        total+=weeks*28;
        total+=remaning*(remaning+1)/2+weeks*remaning;
       
        return total;
    }
}