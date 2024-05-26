class Solution {
    public int totalNQueens(int n) {
        int solutionsCount = 0;

        for (int i = 0; i < n; i++) {
            boolean[][] cellsUnderAttack = new boolean[n][n];
            solutionsCount += countSolutions(n, cellsUnderAttack, 0, i);
        }

        return solutionsCount;
    }

    private int countSolutions(int n, boolean[][] cellsUnderAttack, int row, int column) {
        if (cellsUnderAttack[row][column]) {
            return 0;
        }
        if (row == n-1) {
            return 1;
        }

        for (int i = 0; i < n; i++) {
            cellsUnderAttack[row][i] = true;
        }
        for (int i = 0; i < n; i++) {
            cellsUnderAttack[i][column] = true;
        }

        int rowAttack = row;
        int columnAttack = column;
        while (rowAttack >= 0 && columnAttack >= 0) {
            cellsUnderAttack[rowAttack][columnAttack] = true;
            rowAttack--;
            columnAttack--;
        }

        rowAttack = row;
        columnAttack = column;
        while (rowAttack < n && columnAttack < n) {
            cellsUnderAttack[rowAttack][columnAttack] = true;
            rowAttack++;
            columnAttack++;
        }

        rowAttack = row;
        columnAttack = column;
        while (rowAttack >= 0 && columnAttack < n) {
            cellsUnderAttack[rowAttack][columnAttack] = true;
            rowAttack--;
            columnAttack++;
        }

        rowAttack = row;
        columnAttack = column;
        while (rowAttack < n && columnAttack >= 0) {
            cellsUnderAttack[rowAttack][columnAttack] = true;
            rowAttack++;
            columnAttack--;
        }


        int solutionsCount = 0;
        for (int i = 0; i < n; i++) {
            solutionsCount += countSolutions(n, copy(cellsUnderAttack), row + 1, i);
        }

        return solutionsCount;
    }

    private boolean[][] copy(boolean[][] original) {
        boolean[][] copy = new boolean[original.length][original.length];
        for (int i = 0; i < copy.length; i++) {
            copy[i] = Arrays.copyOf(original[i], original[i].length);
        }

        return copy;
    }

}