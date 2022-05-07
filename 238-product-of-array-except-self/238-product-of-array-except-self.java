class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] forward = new int[n];
        int[] backward = new int[n];
        int[] result = new int[n];
        
        for (int i = 0; i < n; i++) {
            int j = n - 1- i;
            
            if (i == 0) {
                forward[i] = nums[i];
                backward[j] = nums[j];
                
                continue;
            }
            
            forward[i] = nums[i]*forward[i-1];
            backward[j] = nums[j]*backward[j+1];
        }
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                result[i] = backward[i+1];
                continue;
            }
            if (i == n - 1) {
                result[i] = forward[i-1];
                continue;
            }
            
            result[i] = forward[i-1]*backward[i+1]; 
        }
        
        return result;
    }
}