/*
 * @lc app=leetcode id=2273 lang=java
 *
 * [2273] Find Resultant Array After Removing Anagrams
 */

// @lc code=start
import java.util.*;

class Solution {

    public boolean isAnagram(String s1, String s2) {

        if (s1.length() != s2.length())
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {

            char ch = s1.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i < s2.length(); i++) {

            char ch = s2.charAt(i);
            if (map.containsKey(ch)) {
                int val = map.get(ch);
                map.put(ch, val - 1);
                if (map.get(ch) == 0)
                    map.remove(ch);
            }
        }

        return map.isEmpty();
    }

    public List<String> removeAnagrams(String[] words) {

        int n = words.length;
        List<String> list = new ArrayList<>();

        String temp = "";

        for (int i = 0; i < n; i++) {
            String word = words[i];

            if (!isAnagram(temp, word)) {
                list.add(word);
            }

            temp = word;
        }

        return list;
    }
}
// @lc code=end
