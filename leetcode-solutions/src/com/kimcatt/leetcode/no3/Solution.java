package com.kimcatt.leetcode.no3;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {

    /**
     * 滑动窗口解法1 - 要遍历元素两次，考虑HashMap的调整时间，不太好
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>(26);
        int maxLength = 0;
        int i = 0, j = 0, pos;
        for (int len = s.length(); j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                maxLength = Math.max(maxLength, j - i);
                pos = map.get(s.charAt(j));
                for (int k = i; k <= pos; k++) {
                    map.remove(s.charAt(k));
                }
                i = pos + 1;
            }
            map.put(s.charAt(j), j);
        }
        j--;
        maxLength = Math.max(maxLength, j - i + 1);
        return maxLength;
    }

    /**
     * 滑动窗口解法2 - 记录左侧的位置，过程中记录最大长度
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int n = s.length(), res = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //重置下一次i的位置
                i = Math.max(map.get(s.charAt(j)) + 1, i);
            }
            map.put(s.charAt(j), j);
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring2("tmmzuxt"));
    }
}
