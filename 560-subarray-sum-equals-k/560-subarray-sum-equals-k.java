class Solution {
    public int subarraySum(int[] nums, int k) {
        int subarrayCount = 0;
        int preSum = 0;
        
        Map<Integer, Integer> preSumCount = new HashMap<>();
        preSumCount.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            
            Integer targetPreSumCount = preSumCount.get(preSum - k);
            if (targetPreSumCount != null) {
                subarrayCount += targetPreSumCount;
            }
            
            Integer currentPreSumCount = preSumCount.getOrDefault(preSum, 0);
            preSumCount.put(preSum, ++currentPreSumCount);
        }
        
        return subarrayCount;
    }
}