/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int si = 0, ei = height.length - 1, maxWater = Integer.MIN_VALUE;

        while (si < ei) {

            int h = Math.min(height[si], height[ei]);
            int w = ei - si;

            maxWater = Math.max(maxWater, h * w);

            if (height[si] < height[ei]) {
                si++;
            } else {
                ei--;
            }
        }

        return maxWater;
    }
}
// @lc code=end
