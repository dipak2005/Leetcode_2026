/*
 * @lc app=leetcode id=2300 lang=java
 *
 * [2300] Successful Pairs of Spells and Potions
 */

// @lc code=start
import java.util.*;

class Solution {
    public int binarySearch(int[] nums, int target) {

        int si = 0, ei = nums.length;

        while (si < ei) {

            int mid = si + (ei - si) / 2;

            if (nums[mid] < target) {
                si = mid + 1;
            } else {
                ei = mid;
            }

        }
        return si;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {

        Arrays.sort(potions); // 1,2,3,4,5
        int maxPotion = potions[potions.length - 1];
        int[] ans = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {

            int spell = spells[i];

            long minPotion = (long) Math.ceil((1.0 * success) / spell);

            if (minPotion > maxPotion) {
                ans[i] = 0;
                continue;
            }

            int index = binarySearch(potions, (int) minPotion);
            ans[i] = potions.length - index;
        }

        return ans;
    }
}
// @lc code=end
