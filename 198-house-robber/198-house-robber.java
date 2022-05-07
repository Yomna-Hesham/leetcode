class Solution {
    public int rob(int[] nums) {
        int result = 0;
        
        int n = nums.length;
        int[] subMax = new int[n+3];
        
        for (int i = n - 1; i >= 0; i--) {    
            subMax[i] = nums[i] + Math.max(subMax[i+2], subMax[i+3]);
            result = Math.max(result, subMax[i]);
        }
        
        return result;
    }
}