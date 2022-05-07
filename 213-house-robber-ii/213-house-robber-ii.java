class Solution {
    public int rob(int[] nums) {
        int result = 0;
        
        int n = nums.length;
        int maxFirstExcl = nums[n-1];
        int maxLastExcl = nums[0];
        int[] subMax = new int[n+3];
        
        for (int i = n-2; i >= 0; i--) {
            subMax[i] = nums[i] + Math.max(subMax[i+2], subMax[i+3]);
            maxLastExcl = Math.max(maxLastExcl, subMax[i]);
        }
        
        for (int i = n-1; i > 0; i--) {
            subMax[i] = nums[i] + Math.max(subMax[i+2], subMax[i+3]);
            maxFirstExcl = Math.max(maxFirstExcl, subMax[i]);
        }
        result = Math.max(maxFirstExcl, maxLastExcl);
        
        return result;
    }
}