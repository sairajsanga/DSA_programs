class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        int n=s.length();
        int count1[]=new int[26];
        int count2[]=new int[26];
        for(char ch:p.toCharArray()){
           count2[ch-'a']++;
        }
        int i=0;
        int j=0;
        List<Integer> list=new ArrayList<>();
        while(j<n){
            char ch=s.charAt(j);
            count1[ch-'a']++;

            if(j-i+1==p.length()){
                if(isAnagram(count1,count2)){
                    list.add(i);
                }
                count1[s.charAt(i)-'a']--;
                i++;
            }
            j++;
        }
        return list;
        
    }

    public boolean isAnagram(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) {
            return false;
            }
        }
      return true;
    }
}