class Solution {
    public int longestValidParentheses(String s) {
        int longest = 0;
        int currentLength = 0;
        
        Stack<Integer> openIndices = new Stack<>();
        openIndices.push(-1);
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                openIndices.push(i);
            } 
            else {
                openIndices.pop();
                if (openIndices.isEmpty()) {
                    openIndices.push(i);
                }
                else {
                    currentLength = i - openIndices.peek();
                    longest = Math.max(longest, currentLength);
                }
            }
        }
        
        return longest;
    }
}