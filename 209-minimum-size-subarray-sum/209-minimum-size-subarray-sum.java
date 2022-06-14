class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLength = Integer.MAX_VALUE;
        
        int n = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        
        while (left < n && right < n) {
            sum += nums[right];
            if (sum >= target) {
                int length = right - left + 1;
                minLength = Math.min(minLength, length);
                sum -= nums[left];
                sum -= nums[right];
                left++;
            }
            else {
                right++;
            }
        }
        
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
}