class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> lower = new HashSet<>();
        HashSet<Character> upper = new HashSet<>();
        HashSet<Character> counted = new HashSet<>();
        int count = 0;

        for (char ch : word.toCharArray()) {
            if (Character.isLowerCase(ch)) {
                lower.add(ch);
                // If uppercase version was already seen and not yet counted
                if (upper.contains(Character.toUpperCase(ch)) && !counted.contains(ch)) {
                    count++;
                    counted.add(ch);
                }
            } else {
                upper.add(ch);
                // If lowercase version was already seen and not yet counted
                if (lower.contains(Character.toLowerCase(ch)) && !counted.contains(Character.toLowerCase(ch))) {
                    count++;
                    counted.add(Character.toLowerCase(ch));
                }
            }
        }
        return count;
    }
}