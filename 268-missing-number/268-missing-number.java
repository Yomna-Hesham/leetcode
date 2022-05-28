class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        
        int expectedSum = n;
        int actualSum = 0;
        
        for (int i = 0; i < n; i++) {
            expectedSum += i;
            actualSum += nums[i];
        }
        
        return expectedSum - actualSum;
    }
}