class Solution {
    public String minRemoveToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();
        StringBuilder str = new StringBuilder();

        for(int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if(ch == '(') {
                stack.push(ch);
                str.append(ch);

            } else if(ch == ')') {

                if(!stack.isEmpty()) {
                    stack.pop();
                    str.append(ch);
                }

            } else {
                str.append(ch);
            }
        }

        int size = stack.size();

        for(int i = str.length() - 1; i >= 0 && size > 0; i--) {
            if(str.charAt(i) == '(') {
                str.deleteCharAt(i);
                size--;
            }
        }

        return str.toString();
    }
}