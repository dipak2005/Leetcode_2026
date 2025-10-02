/*
 * @lc app=leetcode id=3100 lang=java
 *
 * [3100] Water Bottles II
 */

// @lc code=start
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {

        int drunk_Bottles = numBottles;
        int empty_Bottles = numBottles;
        numBottles = 0;

        while (empty_Bottles >= numExchange) {
            empty_Bottles -= numExchange;
            numExchange += 1;
            drunk_Bottles += 1;
            empty_Bottles += 1;
        }
        return drunk_Bottles;
    }
}
// @lc code=end
