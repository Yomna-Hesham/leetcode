class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        int n = messages.length;
        
        Map<String, Integer> sendersWordsCount = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Integer wordsCount = sendersWordsCount.getOrDefault(senders[i], 0);
            String[] messageWords = messages[i].split(" ");
            sendersWordsCount.put(senders[i], wordsCount += messageWords.length);
        }
        
        PriorityQueue<SenderWordsCount> pq = new PriorityQueue<>((swc1, swc2) -> {
            if (swc1.wordsCount != swc2.wordsCount) {
                return swc2.wordsCount - swc1.wordsCount;
            }
            
            return swc2.sender.compareTo(swc1.sender);
        });
        
        for (String sender : sendersWordsCount.keySet()) {
            pq.add(new SenderWordsCount(sender, sendersWordsCount.get(sender)));
        }
        
        return pq.peek().sender;
    }
}

class SenderWordsCount {
    public String sender;
    public Integer wordsCount = 0;
    
    public SenderWordsCount(String sender, Integer wordsCount) {
        this.sender = sender;
        this.wordsCount = wordsCount;
    }
}