class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
    Set seen = new HashSet(), repeated = new HashSet();
    for (int i = 0; i + 9 < s.length(); i++) {
        String ten = s.substring(i, i + 10);
        if(!seen.contains(ten)){
            seen.add(ten);
        }
        else repeated.add(ten);
    }
    return new ArrayList(repeated);
}
}