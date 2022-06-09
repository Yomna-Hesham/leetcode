class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<String> strs = new Stack<>();
        
        String count = "";
        String str = "";
        for (char c : s.toCharArray()) {
            if (c >= '0' && c <= '9') {
                count += c;
            }
            else if (c == '[') {
                counts.push(Integer.valueOf(count));
                count = "";
                
                strs.push(str);
                str = "";
            }
            else if (c == ']') {
                Integer countValue = counts.pop();
                String temp = "";
                for (int i = 0; i < countValue; i++) {
                    temp += str;
                }
                str = strs.pop() + temp;
            }
            else {
                str += c;       
            }
        }
        
        return str;
    }
}