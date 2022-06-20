class Solution {
    public int minimumLengthEncoding(String[] words) {
        int res = 0;
        
        Arrays.sort(words, (o1, o2) -> o2.length() - o1.length());
        Map<Character, Object> trie = new HashMap<>();
        for (String word : words) {
            int wordLength = word.length();
            Map<Character, Object> current = trie;
            boolean found = true;
            
            System.out.println(word);
            for (int i = wordLength - 1; i >= 0; i--) {
                Character c = word.charAt(i);
                System.out.println(c);
                Map<Character, Object> next = (Map<Character, Object>) current.get(c);
                if (next == null) {
                    System.out.println("NEXT NULL");
                    found = false;
                    next = new HashMap<>();
                    current.put(c, next);       
                }
                
                current = next;
            }
            
            if (!found) {
                System.out.println("NOT FOUND");
                res += wordLength + 1;
            }
        }
        
        return res;
    }
}
