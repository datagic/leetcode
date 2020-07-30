package org.datagic.A_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc: 两数之和
 * Author: datagic (云瞻)
 * CreateDate: 2020/7/29 6:36 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0001_TwoSum {
    /**
     * 题目：给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * ---------------------------------------------------------------------------------------------------------
     * 示例:
     * 给定 nums = [2, 7, 11, 15], target = 9
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：使用哈希表进行查找是高效的，以空间换时间，如何运用哈希表对本体进行操作是关键。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(n)  空间复杂度：O(n)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：
     * 解法1，两遍哈希表，将数组元素与索引保存到哈希表中，然后遍历该哈希表，查找符合条件的元素。
     * 解法2，一遍哈希表，在保存到哈希表的同时，回过头看该哈希表中是否有符合要求的元素。
     */

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result1 = twoSum1Hash(nums, target);
        int[] result2 = twoSum2Hash(nums, target);

        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }

    // 两遍哈希表
    public static int[] twoSum2Hash(int[] nums, int target) {
        // 创建哈希表，存储数组元素与索引值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        // 遍历哈希表，取出符合条件的情况并返回结果数组
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp) && map.get(temp) != i) {
                return new int[]{map.get(temp), i};
            }
        }
        return null;
    }

    // 一遍哈希表
    public static int[] twoSum1Hash(int[] nums, int target) {
        // 创建哈希表，存储数组元素与索引值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            // 若包含这个key，说明之前的nums[index]存入的时候，就已经有符合的元素了，之前的index一定不等于当前的i，
            // 所以不用加 map.get(temp) != i
            if (map.containsKey(temp)) {
                return new int[]{map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
