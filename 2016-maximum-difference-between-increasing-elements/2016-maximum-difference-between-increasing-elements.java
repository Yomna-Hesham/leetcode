class Solution {
    public int maximumDifference(int[] nums) {
        int maxDiff = -1;
        int min = Integer.MAX_VALUE;
        
        for (int num : nums) {
            if (num > min) {
                int diff = num - min;
                maxDiff = Math.max(diff, maxDiff);
            } else if (num < min) {
                min = num;
            }
        }
        
        return maxDiff;
    }
}