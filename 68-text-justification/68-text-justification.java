class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        
        int lineCharsCount = 0;
        int lineSpacesCount = 0;
        Queue<String> lineWords = new LinkedList<>();
        Stack<String> spaces = new Stack<>();
        
        for (int i = 0; i < words.length; i++) {
            if (lineCharsCount + lineSpacesCount + words[i].length() <= maxWidth) {
                lineWords.add(words[i]);
                lineCharsCount += words[i].length();
                lineSpacesCount++;
                
            } else {
                lineSpacesCount = maxWidth - lineCharsCount;
                int slotsCount = lineWords.size() - 1;
                
                if (slotsCount > 0) {
                    while (lineSpacesCount % slotsCount > 0) {
                        int spaceLength = lineSpacesCount / slotsCount;

                        char[] space = new char[spaceLength];
                        Arrays.fill(space, ' ');
                        spaces.push(new String(space));

                        lineSpacesCount -= spaceLength;
                        slotsCount--;
                    }
                    
                    int spaceLength = lineSpacesCount / slotsCount;
                    for (int j = 0; j < slotsCount; j++) {
                        char[] space = new char[spaceLength];
                        Arrays.fill(space, ' ');
                        spaces.push(new String(space));
                    }
                } else {
                    char[] space = new char[lineSpacesCount];
                    Arrays.fill(space, ' ');
                    spaces.push(new String(space));
                }
                 
                String line = "";
                while (!lineWords.isEmpty() || !spaces.isEmpty()) {
                    if (!lineWords.isEmpty()) {
                        line += lineWords.poll();
                    }
                    
                    if (!spaces.isEmpty()) {
                        line += spaces.pop();
                    }
                }
                result.add(line);
                
                i--;
                lineCharsCount = 0;
                lineSpacesCount = 0;
            }
        }
        
        if (lineCharsCount > 0) {
            String line = "";
            while (!lineWords.isEmpty()) {
                line += lineWords.poll();
                if (line.length() < maxWidth) {
                    line += " ";
                }
            }
            char[] space = new char[maxWidth - line.length()];
            Arrays.fill(space, ' ');
            line += new String(space);
            
            result.add(line); 
        }
        
        return result;
    }
}