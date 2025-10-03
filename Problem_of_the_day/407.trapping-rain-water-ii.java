/*
 * @lc app=leetcode id=407 lang=java
 *
 * [407] Trapping Rain Water II
 */

// @lc code=start
import java.util.*;

class Solution {
    public int trapRainWater(int[][] heightMap) {

        int[][] dir = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
        int rows = heightMap.length;
        int cols = heightMap[0].length;

        if (rows < 3 || cols < 3)
            return 0;

        int totalUnvisitedCells = rows * cols;
        boolean[][] visited = new boolean[rows][cols];

        // height , row , col
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // row
        for (int i = 0; i < rows; i++) {
            pq.offer(new int[] { heightMap[i][0], i, 0 });
            pq.offer(new int[] { heightMap[i][cols - 1], i, cols - 1 });
            visited[i][0] = true;
            visited[i][cols - 1] = true;
            totalUnvisitedCells--;
            totalUnvisitedCells--;
        }

        // col
        for (int i = 0; i < cols - 1; i++) {
            pq.offer(new int[] { heightMap[0][i], 0, i });
            pq.offer(new int[] { heightMap[rows - 1][i], rows - 1, i });
            visited[0][i] = true;
            visited[rows - 1][i] = true;
            totalUnvisitedCells--;
            totalUnvisitedCells--;
        }

        int waterLevel = 0, trappedWater = 0;

        while (!pq.isEmpty()) {
            int[] currentCell = pq.poll();
            int currentHeight = currentCell[0];
            int currentRow = currentCell[1];
            int currentCol = currentCell[2];
            waterLevel = Math.max(waterLevel, currentHeight);

            for (int direction = 0; direction < 4; direction++) {
                int neighbourRow = currentRow + dir[direction][0];
                int neighbourCol = currentCol + dir[direction][1];

                if (isValidCell(neighbourRow, neighbourCol, rows, cols) && !visited[neighbourRow][neighbourCol]) {
                    int neighbourHeight = heightMap[neighbourRow][neighbourCol];
                    if (neighbourHeight < waterLevel) {
                        trappedWater += waterLevel - neighbourHeight;
                    }

                    pq.offer(new int[] { neighbourHeight, neighbourRow, neighbourCol });
                    visited[neighbourRow][neighbourCol] = true;
                    totalUnvisitedCells--;
                }
            }
        }
        return trappedWater;
    }

    public boolean isValidCell(int row, int col, int rows, int cols) {

        return row >= 0 && col >= 0 && row < rows && col < cols;

    }
}
// @lc code=end
