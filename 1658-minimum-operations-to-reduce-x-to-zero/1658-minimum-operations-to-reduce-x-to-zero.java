class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        int longestMiddleLength = -1;
        
        int[] preSum = new int[n];
        preSum[0] = nums[0];
        
        Map<Integer, Integer> preSumIdx = new HashMap<>();
        preSumIdx.put(0, -1);
        preSumIdx.put(preSum[0], 0);
        
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i-1] + nums[i];
            preSumIdx.put(preSum[i], i);
        }
        int targetSum = preSum[n-1] - x;
        
        for (int i = 0; i < n; i++) {
            int complementary = preSum[i] - targetSum;
            Integer complementaryIdx = preSumIdx.get(complementary);
            
            if (complementaryIdx != null) {
                longestMiddleLength = Math.max(longestMiddleLength, i - complementaryIdx);
            }
        }
        
        return longestMiddleLength == -1 ? -1 : n - longestMiddleLength;
    }
}