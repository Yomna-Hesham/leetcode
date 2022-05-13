class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer complimentIndex = indices.get(target - nums[i]);
            if (complimentIndex != null) {
                result[0] = i;
                result[1] = complimentIndex;
                
                break;
            }
            
            indices.put(nums[i], i);
        }
        
        return result;
    }
}