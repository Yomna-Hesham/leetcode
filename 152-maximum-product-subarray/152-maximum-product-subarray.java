class Solution {
    public int maxProduct(int[] nums) {
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            
            int tempMax = Math.max(
                num*max,
                Math.max(
                    num*min,
                    num
                )
            );
            
            min = Math.min(
                num*max,
                Math.min(
                    num*min,
                    num
                )
            );
            max = tempMax; 
            
            result = Math.max(result, max); 
        }
        
        return result;
    }
    
}