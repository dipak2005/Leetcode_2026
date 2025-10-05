/*
 * @lc app=leetcode id=417 lang=java
 *
 * [417] Pacific Atlantic Water Flow
 */

// @lc code=start
import java.util.*;

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length, m = heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        // initialize border with true because border ka water ocean me jayega hi so..
        for (int i = 0; i < n; i++) { // row
            pacific[i][0] = true;
            atlantic[i][m - 1] = true;
        }
        // initialize border with true because border ka water ocean me jayega hi so..
        for (int j = 0; j < m; j++) { // col
            pacific[0][j] = true;
            atlantic[n - 1][j] = true;
        }

        boolean updated = true;

        while (updated) {
            updated = false;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!pacific[i][j]) {

                        // upper
                        if (i > 0 && pacific[i - 1][j] && heights[i][j] >= heights[i - 1][j]) {
                            pacific[i][j] = true;
                            updated = true;
                        } // down
                        else if (i < n - 1 && pacific[i + 1][j] && heights[i][j] >= heights[i + 1][j]) {
                            pacific[i][j] = true;
                            updated = true;
                        }
                        // left
                        else if (j > 0 && pacific[i][j - 1] && heights[i][j] >= heights[i][j - 1]) {
                            pacific[i][j] = true;
                            updated = true;
                        }
                        // right
                        else if (j < m - 1 && pacific[i][j + 1] && heights[i][j] >= heights[i][j + 1]) {
                            pacific[i][j] = true;
                            updated = true;
                        }
                    }

                    if (!atlantic[i][j]) {

                        // upper
                        if (i > 0 && atlantic[i - 1][j] && heights[i][j] >= heights[i - 1][j]) {
                            atlantic[i][j] = true;
                            updated = true;
                        } // down
                        else if (i < n - 1 && atlantic[i + 1][j] && heights[i][j] >= heights[i + 1][j]) {
                            atlantic[i][j] = true;
                            updated = true;
                        }
                        // left
                        else if (j > 0 && atlantic[i][j - 1] && heights[i][j] >= heights[i][j - 1]) {
                            atlantic[i][j] = true;
                            updated = true;
                        }
                        // right
                        else if (j < m - 1 && atlantic[i][j + 1] && heights[i][j] >= heights[i][j + 1]) {
                            atlantic[i][j] = true;
                            updated = true;
                        }
                    }
                }
            }

        }
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    list.add(Arrays.asList(i, j));
                }

            }
        }
        return list;
    }
}
// @lc code=end
