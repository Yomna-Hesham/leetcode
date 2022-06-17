class Solution {
    public int characterReplacement(String s, int k) {
        int longest = 0;
        
        Map<Character, Integer> charFreqs = new HashMap<>();
        int left = 0;
        int right = 0;
        int length = 0;
        int maxFreq = 0;
        int n = s.length();
        
        while(left < n && right < n) {
            int charFreq = charFreqs.getOrDefault(s.charAt(right), 0);
            charFreq++;
            maxFreq = Math.max(maxFreq, charFreq);
            
            length = right-left+1;
            if (length - maxFreq <= k) {
                longest = Math.max(longest, length);
                charFreqs.put(s.charAt(right), charFreq);
                right++;
            } 
            else {
                charFreq = charFreqs.get(s.charAt(left));
                charFreqs.put(s.charAt(left), --charFreq);
                left++;
            }
        }
     
        return Math.max(longest, length);
    }
}