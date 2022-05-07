class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int subMax = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            if (subMax < 0) {
                subMax = 0;
            } 
            
            subMax += nums[i];
            result = Math.max(result, subMax);
        }
        
        return result;
    }
}