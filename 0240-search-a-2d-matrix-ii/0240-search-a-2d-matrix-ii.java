class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = 0;
        while (i < matrix.length && matrix[i][0] <= target) {

            int idx = Arrays.binarySearch(matrix[i], target);
            if (idx >= 0)
                return true;
            i++;
        }

        return false;
    }
}