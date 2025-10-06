/*
 * @lc app=leetcode id=778 lang=java
 *
 * [778] Swim in Rising Water
 */

// @lc code=start
class Solution {
    int direction[][] = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

    public boolean isReachable(int T, int[][] grid, int N, int i, int j, boolean[][] visited) {

        // base case
        if (i == N - 1 && j == N - 1)
            return true;

        visited[i][j] = true;
        for (int[] dir : direction) {
            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if (new_i >= 0 && new_i < N && new_j >= 0 && new_j < N && !visited[new_i][new_j] && grid[i][j] <= T
                    && grid[new_i][new_j] <= T) {
                if (isReachable(T, grid, N, new_i, new_j, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public int swimInWater(int[][] grid) {

        int n = grid.length;
        int si = 0, ei = n * n - 1;

        while (si < ei) {
            int mid = si + (ei - si) / 2;

            boolean[][] visited = new boolean[n][n];

            if (isReachable(mid, grid, n, 0, 0, visited)) {
                ei = mid;
            } else {
                si = mid + 1;
            }

        }
        return si;
    }
}
// @lc code=end
