package RandomQues;

class longestRepetdstring {
    //Leetcode 1156
    public static int maxRepOpt1(String text) {
        int[] freq = new int[26];
        for(char ch : text.toCharArray())
            freq[ch - 'a']++;

        int maxLen = 0, n = text.length();
        for(char ch = 'a'; ch <= 'z'; ch++) {
            int i = 0, j = 0, miss = 0;
            int subFreq = 0;
            int len = 0;
            while(j < n) {
                char chj = text.charAt(j);
                if(chj == ch) {
                    subFreq++;
                } else miss++;

                while(miss > 1) {
                    char chi = text.charAt(i);
                    if(chi == ch) {
                        subFreq--;
                    } else miss--;
                    i++;
                }

                if(freq[ch - 'a'] - subFreq >= miss)
                    len = Math.max(len, j - i + 1);

                j++;
            }
            if(freq[ch - 'a'] - subFreq >= miss)
                len = Math.max(len, j - i);

            maxLen = Math.max(maxLen, len);
        }

        return maxLen;
    }

    public static void main(String[] args) {
       String s="aaabaaa";
        System.out.println(maxRepOpt1(s));
    }
}
