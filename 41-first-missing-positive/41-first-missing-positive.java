class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int missing = 1; 
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
        }
        
        for (int i = 0; i < n; i++) {
            Integer min = pq.poll();
            if (min == missing) {
                missing++;
            }
            else if (min > missing) {
                break;
            }
        }
        
        return missing;
    }
}