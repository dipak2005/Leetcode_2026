/*
 * @lc app=leetcode id=2022 lang=cpp
 *
 * [2022] Convert 1D Array Into 2D Array
 */

// @lc code=start
class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        
        vector<vector<int>> result(m , vector<int>(n,0));

        int length = original.size() , k = 0;

        if(length != m*n) return {};

        for(int i = 0 ; i < m ;i++) {
            for(int j =0 ; j < n ; j++) {
                if(k < length) {
                    result[i][j] = original[k++];
                }
            }
        }
    return result;    
    }
};
// @lc code=end

