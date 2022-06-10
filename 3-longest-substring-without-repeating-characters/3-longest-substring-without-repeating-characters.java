class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> idx = new HashMap<>();
        
        int longestLength = 0;
        int currentLength = 0;
        
        int begin = 0;
        for (int end = 0; end < s.length(); end++) {
            Character c = s.charAt(end);
            Integer cIdx = idx.get(c);
            
            if (cIdx != null && cIdx >= begin) {
                begin = cIdx + 1;
                longestLength = Math.max(longestLength, currentLength);
            }
            
            idx.put(c, end);
            currentLength = end + 1 - begin;
        }
        
        return Math.max(longestLength, currentLength);
    }
}