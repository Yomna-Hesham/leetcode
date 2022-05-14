class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        
        List<int[]> merged = new ArrayList<>(intervals.length);
        merged.add(intervals[0]);
        int mergedLastIndex = 0;
        
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= merged.get(mergedLastIndex)[1]) {
                merged.get(mergedLastIndex)[1] = Math.max(intervals[i][1], merged.get(mergedLastIndex)[1]);
            } else {
                merged.add(intervals[i]);
                mergedLastIndex++;
            }   
        }
        
        int[][] result = new int[merged.size()][2];
        for (int i = 0; i < merged.size(); i++) {
            result[i] = merged.get(i);
        }
        
        return result;
    }
}