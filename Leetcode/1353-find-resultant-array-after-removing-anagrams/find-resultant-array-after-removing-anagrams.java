class Solution {
    public List<String> removeAnagrams(String[] words) {
        int n=words.length;
        List<String> list=new ArrayList<>();
        list.add(words[0]);
        for(int i=1;i<n;i++){
            String prev=list.get(list.size()-1);
            if(!isAnagram(prev,words[i])){
                list.add(words[i]);
            }
        }
        return list;
    }
    public boolean isAnagram(String s1,String s2){
        if(s1.length()!=s2.length()) return false;

        int freq[]=new int[26];
        for(int i=0;i<s1.length();i++){
            freq[s1.charAt(i)-'a']++;
            freq[s2.charAt(i)-'a']--;
        }

        for(int count:freq){
            if(count!=0) return false;
        }
        return true;
    }
}