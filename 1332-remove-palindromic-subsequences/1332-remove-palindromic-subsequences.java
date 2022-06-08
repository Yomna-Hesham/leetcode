class Solution {
    public int removePalindromeSub(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        
        for (int i = 0; i < n/2; i++) {
            if (s.charAt(i) != s.charAt(n-i-1)) {
                return 2;
            }
        }
        
        return 1;
    }
}