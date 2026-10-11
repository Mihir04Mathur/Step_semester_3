package session_ten_topics.assignment_problems;

import java.util.Arrays;

public class BusiestBusRow {

    /**
     * Time Complexity: O(r * c) where r is the number of rows and c is the number of columns.
     * Space Complexity: O(1) additional space (only scalar tracking variables).
     */
    public static String busiestRow(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return "Row -1, Total 0";
        }

        int bestRowIndex = 0;
        int maxTotal = Integer.MIN_VALUE;

        for (int i = 0; i < grid.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < grid[i].length; j++) {
                rowSum += grid[i][j];
            }
            // Update only when strictly larger to preserve smaller index on ties
            if (rowSum > maxTotal) {
                maxTotal = rowSum;
                bestRowIndex = i;
            }
        }

        return "Row " + bestRowIndex + ", Total " + maxTotal;
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        System.out.println("grid = " + Arrays.deepToString(grid));
        System.out.println("Expected: Row 1, Total 7");
        System.out.println("Got: " + busiestRow(grid));
    }
}
