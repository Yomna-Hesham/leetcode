class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index; 
        if (intervals.length == 0) {
            index = 0;
        } else {
            index = getIndex(intervals, newInterval, 0, intervals.length - 1);        
        }
        
        intervals = insert(newInterval, index, intervals);
        return merge(intervals);
    }
    
    private int getIndex(int[][] intervals, int[] newInterval, int leftIndex, int rightIndex) {
        if (rightIndex == leftIndex) {
            if (newInterval[0] < intervals[leftIndex][0]) {
                return leftIndex;
            }
            
            return rightIndex + 1;
        }
        
        int midIndex = (rightIndex - leftIndex)/2 + leftIndex;
        if (newInterval[0] < intervals[midIndex][0]) {
            if (midIndex == leftIndex) {
                return leftIndex;
            }
            
            return getIndex(intervals, newInterval, leftIndex, midIndex-1);
        }
        
        if (newInterval[0] > intervals[midIndex][0]) {
            return getIndex(intervals, newInterval, midIndex+1, rightIndex);
        }
        
        return midIndex;
    }
    
    private int[][] insert(int[] newInterval, int index, int[][] intervals) {
        int[][] updated = new int[intervals.length + 1][2];
        boolean inserted = false;
        
        for (int i = 0; i < intervals.length; i++) {
            if (i == index) {
                updated[i] = newInterval;
                inserted = true;
            }
            
            if (inserted) {
                updated[i+1] = intervals[i];
            } else {
                updated[i] = intervals[i];
            }
        }
        if (!inserted) {
            updated[updated.length-1] = newInterval;
        }
        return updated;
    }
    
    private int[][] merge(int[][] intervals) {
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
