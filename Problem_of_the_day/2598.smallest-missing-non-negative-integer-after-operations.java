/*
 * @lc app=leetcode id=2598 lang=java
 *
 * [2598] Smallest Missing Non-negative Integer After Operations
 */

// @lc code=start
import java.util.*;

class Solution {
    public int findSmallestInteger(int[] nums, int value) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int rem = ((nums[i] % value) + value) % value;

            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }

        int i = 0;

        while (true) {
            int rem = i % value;

            if (map.getOrDefault(rem, 0) > 0) {

                map.put(rem, map.get(rem) - 1);
                i++;
            } else {
                return i;
            }
        }

    }
}
// @lc code=end
