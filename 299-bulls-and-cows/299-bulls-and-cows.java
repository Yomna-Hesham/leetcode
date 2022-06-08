class Solution {
    public String getHint(String secret, String guess) {
        int a = 0;
        int b = 0;
        int n = secret.length();
        int[] freq = new int[10];
        
        for (int i = 0; i < n; i++) {
            Integer digit = Character.getNumericValue(secret.charAt(i));
            freq[digit]++;
        }
        
        for (int i = 0; i < n; i++) {
            Integer secretDigit = Character.getNumericValue(secret.charAt(i));
            Integer guessDigit = Character.getNumericValue(guess.charAt(i));
            
            if (guessDigit.equals(secretDigit)) {
                a++;
                freq[guessDigit]--;
            }
        }
        
        for (int i = 0; i < n; i++) {
            Integer secretDigit = Character.getNumericValue(secret.charAt(i));
            Integer guessDigit = Character.getNumericValue(guess.charAt(i));
            
            if (!guessDigit.equals(secretDigit) && freq[guessDigit] > 0) {
                b++;
                freq[guessDigit]--;
            }
        }
        
        return ""+a+"A"+b+"B";
    }
}