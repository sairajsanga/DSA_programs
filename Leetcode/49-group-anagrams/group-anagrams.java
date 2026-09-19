class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;

        HashMap<String,List<String>> map=new HashMap<>();
        for(int i=0;i<n;i++){
            char s[]=strs[i].toCharArray();
            Arrays.sort(s);
            String sort=Arrays.toString(s);
            if(map.containsKey(sort)){
                map.get(sort).add(strs[i]);
            }
            else{
               map.putIfAbsent(sort,new ArrayList<>());
               map.get(sort).add(strs[i]);
            }
        }
        List<List<String>> res=new ArrayList<>();
        for(List<String> ans:map.values()){
           res.add(ans);
        }

        return res;
    }
}