class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Map<Integer, Integer> levelSize = new HashMap<>();
        for (int i = 0; i < triangle.size(); i++) {
            Integer previousLevelSize = levelSize.getOrDefault(i-1, 0);
            levelSize.put(i, previousLevelSize + 1);
        }
        
        for (int i = triangle.size()-2; i >= 0; i--) {
            for (int j = 0; j < levelSize.get(i); j++) {
                Integer minAdj = Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1));
                Integer updatedValue = triangle.get(i).get(j) + minAdj;
                triangle.get(i).set(j, updatedValue);
            }
        }
        
        return triangle.get(0).get(0);
    }
}