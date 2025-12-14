class Solution {
    public String reverseWords(String s) {
        String arr[] = s.split(" ");
        if (arr.length == 1)
            return arr[0];
        String first = arr[0];
        int vowels = vowels(first);
        StringBuilder str = new StringBuilder();
        str.append(first);
        str.append(" ");
        for (int i = 1; i < arr.length; i++) {
            if (vowels(arr[i]) == vowels) {
                str.append(reverse(arr[i]));
                if (i != arr.length - 1) {
                    str.append(" ");
                }
            } else {
                str.append(arr[i]);
                if (i != arr.length - 1) {
                    str.append(" ");
                }
            }
        }
        return str.toString();
    }

    public int vowels(String s) {
        int count = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                count++;
            }
        }
        return count;
    }

    public String reverse(String s) {
        StringBuilder str = new StringBuilder(s);
        return str.reverse().toString();
    }

}