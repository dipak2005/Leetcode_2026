/*
 * @lc app=leetcode id=151 lang=cpp
 *
 * [151] Reverse Words in a String
 */

// @lc code=start
class Solution {
public:
    string reverseWords(string s) {
        
        // string str = trim(s);

        int si = 0 ,  ei = s.size()-1;
         
        while(si < ei) {

            char temp = s[si];
            s[si] = s[ei];
            s[ei] = temp;
            si++;
            ei--;
        }
    return s;    
    }
};
// @lc code=end

