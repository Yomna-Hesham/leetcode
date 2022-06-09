class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            Integer complementryIdx = map.get(target - numbers[i]);
            
            if (complementryIdx != null) {
                res[0] = complementryIdx;
                res[1] = i + 1;
                
                break;
            }
            
            map.put(numbers[i], i+1);
        }
        
        return res;
    }
}