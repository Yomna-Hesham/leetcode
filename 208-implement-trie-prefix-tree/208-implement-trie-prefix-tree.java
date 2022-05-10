class Trie {
    private Node root = new Node();

    public Trie() {
        
    }
    
    public void insert(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            current = current.getChildren().computeIfAbsent(c, key -> new Node());
        }
        
        current.setIsWordEnd(true);
    }
    
    public boolean search(String word) {
        Node current = root; 
        for (char c : word.toCharArray()) {
            Node child = current.getChildren().get(c);
            if (child == null) {
                return false;
            }
            
            current = child;
        }
        
        return current.getIsWordEnd();
    } 
    
    public boolean startsWith(String prefix) {
        Node current = root; 
        for (char c : prefix.toCharArray()) {
            Node child = current.getChildren().get(c);
            if (child == null) {
                return false;
            }
            
            current = child;
        }
        
        return true;
    }
    
    private class Node {
        private Map<Character, Node> children = new HashMap<>();
        private Boolean isWordEnd = false;
        
        public Map<Character, Node> getChildren() {
            return children;
        }
        
        public void setIsWordEnd(Boolean isWordEnd) {
            this.isWordEnd = isWordEnd;
        }
        
        public Boolean getIsWordEnd() {
            return isWordEnd;
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */