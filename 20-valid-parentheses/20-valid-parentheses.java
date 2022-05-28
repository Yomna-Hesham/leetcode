class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            Character ch1 = Character.valueOf(c);
            if (isOpen(ch1)) {
                stack.push(ch1);
            }
            else {
                if (stack.isEmpty()){
                    return false;
                }
                
                Character ch2 = stack.pop();
                if (!match(ch2, ch1)) {
                    return false;
                }
            }
        }
        
        return stack.isEmpty();
    }
    
    private boolean isOpen(Character c) {
        return c == '(' || c == '{' || c == '[';
    }
    
    private boolean match(Character c1, Character c2) {
        switch (c1) {
            case '(':
                return c2 == ')';
            case '{':
                return c2 == '}';
            case '[': 
                return c2 == ']';
        }
        
        return false;
    }
}