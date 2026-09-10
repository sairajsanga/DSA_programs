class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int n=s.length();

        int i=0;
        int j=0;
        int count[]=new int[2];
        int ans=Integer.MAX_VALUE;
        List<String> str=new ArrayList<>();
        while(j<n){
           int ch=s.charAt(j);
           count[ch-'0']++;

            if(count[1]==k){
               ans=Math.min(ans,j-i+1);
               str.add(s.substring(i,j+1));
            }
           while(count[1]>=k){
              count[s.charAt(i)-'0']--;
              i++;
              if(count[1]==k){
                 ans=Math.min(ans,j-i+1);
                str.add(s.substring(i,j+1));
              }
           }
           j++;
        }
        Collections.sort(str,(a,b)->{
            if(a.length()==b.length()) return a.compareTo(b);
            else return a.length()-b.length();     
        });

        return str.size()==0?"":str.get(0);
    }
}