class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] result = new int[k][2];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(
        (p1, p2) -> (int) ((Math.pow(p1[0], 2) + Math.pow(p1[1], 2)) - (Math.pow(p2[0], 2) + Math.pow(p2[1], 2))));

        for (int[] point : points) {
            pq.add(point);
        }
        
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }
        
        return result;
    }
}