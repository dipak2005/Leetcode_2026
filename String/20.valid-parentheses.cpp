/*
 * @lc app=leetcode id=20 lang=cpp
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution
{
public:
    bool isValid(string s)
    {

        stack<int> st;

        for (int i = 0; i < s.length(); i++)
        {
            char ch = s[i];

            if (ch == '{' || ch == '[' || ch == '(')
            {
                st.push(ch);
            }
            else
            {
                if(st.empty()) return false;
                
                if ((ch == '}' && st.top() == '{') ||
                    (ch == ']' && st.top() == '[') ||
                    (ch == ')' && st.top() == '(')) {
                     st.pop();
                  }else {
                    st.push(ch);
                  }
            }
        }

    return st.empty() ? true : false;    
    }
};
// @lc code=end
