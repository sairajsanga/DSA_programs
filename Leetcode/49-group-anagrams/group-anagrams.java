class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length==0||strs==null) return new ArrayList<>();

        Map<String,List<String>> map=new HashMap<>();
        for(String s:strs){
           char ca[]=s.toCharArray();
           Arrays.sort(ca);
           String keystr=String.valueOf(ca);
           if(!map.containsKey(keystr)){
            map.put(keystr,new ArrayList<>());
           }
           map.get(keystr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}