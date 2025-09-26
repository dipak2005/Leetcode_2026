/*
 * @lc app=leetcode id=704 lang=cpp
 *
 * [704] Binary Search
 */

// @lc code=start
#include<iostream>
#include<vector>
class Solution {
public:
    int search(vector<int>& nums, int target) {
        
        int n = nums.size();

        int si = 0 , ei = n-1;

        while (si <= ei) {
            int mid = si + (ei-si)/2;

            if(nums[mid] == target) {
                return mid;
            }
            else {
                if(nums[mid] < target) {
                    si = mid+1;
                }else  {
                    ei = mid-1;
                }
            }
        }
    return -1;    
    }
};
// @lc code=end

