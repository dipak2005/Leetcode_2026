/*
 * @lc app=leetcode id=167 lang=cpp
 *
 * [167] Two Sum II - Input Array Is Sorted
 */

// @lc code=start
#include <vector>
class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        
        int n = numbers.size();
        int si = 0 , ei = n-1;
        vector<int> ans;
        while (si < ei) 
        {   
            int sum = numbers[si] + numbers[ei];
            if(sum == target) {
             
              return {si+1 , ei+1};
            }
       
             else if(sum > target) {
                ei--;
            }else {
                si++;
            }
        }
    return {-1,-1};    
    }
};
// @lc code=end

