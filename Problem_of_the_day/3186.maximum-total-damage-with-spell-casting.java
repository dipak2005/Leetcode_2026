/*
 * @lc app=leetcode id=3186 lang=java
 *
 * [3186] Maximum Total Damage With Spell Casting
 */

// @lc code=start
import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {

        Map<Integer, Long> freq = freq = new HashMap<>();

        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0L) + 1);
        }
        /*
         * 1-> 2
         * 3-> 1
         * 4-> 1
         */

        List<Integer> keys = new ArrayList<>(freq.keySet());
        Collections.sort(keys); // 1 , 3 , 4

        int n = keys.size();
        long[] dp = new long[n];
        dp[0] = freq.get(keys.get(0)) * keys.get(0);

        for (int i = 1; i < n; i++) {
            long take = freq.get(keys.get(i)) * keys.get(i);
            int prev = binarySearch(keys, i - 1, keys.get(i) - 3);

            if (prev >= 0)
                take += dp[prev];

            dp[i] = Math.max(dp[i - 1], take);
        }
        return dp[n - 1];
    }

    public int binarySearch(List<Integer> keys, int end, int values) {

        int l = 0, r = end, ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (keys.get(mid) <= values) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
// @lc code=end
