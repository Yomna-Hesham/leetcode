class Solution {
    private int[] informTime;
    private Map<Integer, List<Integer>> subordinates = new HashMap<>();
    
    public int numOfMinutes(int n, int headID, int[] managers, int[] informTime) {
        this.informTime = informTime;
         
        for (int i = 0; i < n; i++) {
            subordinates.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            if (i == headID) {
                continue;
            }
            subordinates.get(managers[i]).add(i);
        }
        
       return getTotalInformTime(headID);
    }
    
    private Integer getTotalInformTime(Integer manager) {
        Integer maxSubordinateInformTime = 0;
        
        for (Integer subordinate : subordinates.get(manager)) {
            Integer subordinateInformTime = getTotalInformTime(subordinate);
            maxSubordinateInformTime = Math.max(maxSubordinateInformTime, subordinateInformTime);
        }
        
        return maxSubordinateInformTime + informTime[manager];
    }
}