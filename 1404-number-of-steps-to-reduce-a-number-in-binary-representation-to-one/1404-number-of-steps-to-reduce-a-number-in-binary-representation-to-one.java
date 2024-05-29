class Solution {
    public int numSteps(String s) {
        int steps = 0;
        boolean carry = false;
        byte[] bits = s.getBytes();
        int n = bits.length;
        
        for (int i = n - 1; i > 0; i--) {
            if (bits[i] == '1') {
                if (!carry) {
                    steps++;
                    carry = true;
                }
            } else {
                if (carry) {
                    steps++;
                }
            }
        }

        steps += (n-1);
        steps += carry ? 1 : 0;

        return steps;
    }
}