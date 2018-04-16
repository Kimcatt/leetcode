package com.kimcatt.leetcode.no1;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * <p>
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * <p>
 * Example:
 * <p>
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * <p>
 * return [0, 1].
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0, len = nums.length; i < len; i++) {
            if (nums[i] < 0 && target > 0 && target > Integer.MAX_VALUE + nums[i]) {

            } else if (nums[i] > 0 && target < 0 && target < Integer.MIN_VALUE + nums[i]) {

            } else if (valueIndexMap.containsKey(target - nums[i])) {
                res[0] = valueIndexMap.get(target - nums[i]);
                res[1] = i;
                break;
            }
            valueIndexMap.put(nums[i], i);
        }
        return res;
    }


}
