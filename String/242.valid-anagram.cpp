/*
 * @lc app=leetcode id=242 lang=cpp
 *
 * [242] Valid Anagram
 */

// @lc code=start
#include<string>
class Solution {
public:
    bool isAnagram(string s, string t) {
       
      
      if(s.length() != t.length()) return false;
      int count[26];

      for(int i = 0 ; i< s.length() ;i++) {
        int idx = s[i] - 'a';
        count[idx]++;
      }

      for(int  i = 0 ; i < t.length() ; i++) {
        int idx = t[i] - 'a';

        if(count[idx] == 0) {
          return false;
        }else {
          count[idx]--;
        }
      }
    return true;  
    }
};
// @lc code=end

