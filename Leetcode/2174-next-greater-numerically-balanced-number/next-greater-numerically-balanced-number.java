class Solution {
    public int nextBeautifulNumber(int n) {

        for(int i=n+1;i<=10000000;i++){
            String curr=Integer.toString(i);
            HashMap<Integer,Integer> map=new HashMap<>();
            boolean flag=true;
            
            for(int k=0;k<curr.length();k++){
                int ele=curr.charAt(k)-'0';
                map.put(ele,map.getOrDefault(ele,0)+1);
            }
            for(int ele:map.keySet()){
                if(map.get(ele)!=ele){
                    flag=false;
                    break;
                }
            }
            if(flag){
                return i;
            }
        }
        return -1;
    }
}