class Solution {
    public int[][] transpose(int[][] matrix) {
        int rowsCount = matrix.length;
        int columnsCount = matrix[0].length;
        int[][] transposed = new int[columnsCount][rowsCount];
        
        for (int r = 0; r < rowsCount; r++) {
            for (int c = 0; c < columnsCount; c++) {
                transposed[c][r] = matrix[r][c];
            }
        }
        
        return transposed;
    }
}