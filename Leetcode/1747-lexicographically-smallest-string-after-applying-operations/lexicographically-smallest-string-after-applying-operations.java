class Solution {
    String min;
    HashSet<String> visited;
    public String findLexSmallestString(String s, int a, int b) {
        int n=s.length();
        this.min = "9".repeat(n);
        this.visited=new HashSet<>();
        solve(s,a,b);
        return min;
    }
    public void solve(String s,int a,int b){
        if(s.compareTo(min)<0){
            min=s;
        }
        if(visited.contains(s)) return;

        visited.add(s);

        String added=addition(s,a);
        String shift=shifted(s,b);
        solve(added,a,b);
        solve(shift,a,b);
    }
    public String addition(String s,int a){
        char arr[]=s.toCharArray();
        for(int i=1;i<arr.length;i+=2){
            int num=arr[i]-'0';
            num=(num+a)%10;
            arr[i]=(char)(num+'0');
        }
        return new String(arr);
    }
    public String shifted(String s,int b){
        String shift=s.substring(s.length()-b)+s.substring(0,s.length()-b);
        return shift;
    }
}