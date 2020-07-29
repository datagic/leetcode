package org.datagic.A_easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Desc: 存在重复元素
 * Author: datagic (云瞻)
 * CreateDate: 2020/7/28 4:23 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0217_ContainsDuplicate {
    /**
     * 题目：给定一个整数数组，判断是否存在重复元素。
     * 如果任意一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入: [1,2,3,1]
     * 输出: true
     * 示例 2:
     * 输入: [1,2,3,4]
     * 输出: false
     * 示例 3:
     * 输入: [1,1,1,3,3,4,3,2,4,2]
     * 输出: true
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：不可用去重等工具类，这样算法题就失去意义了。题目理解上比较容易，存在重复元素则返回false，不存在则返回true。
     * ---------------------------------------------------------------------------------------------------------
     * 最佳时间复杂度：O(n)  空间复杂度：O(1)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：
     * 解法1，朴素线性查找，就是将每一种组合都查出，判断是否有相同的组合。
     * 组合公式为C(n,2)=n*(n-1)/2*1，时间复杂度 O(n^2)，空间复杂度 O(1)
     * 解法2，排序之后，比较i与i+1元素是否相等，时间复杂度就是排序的时间复杂度 O(nlogn) 空间复杂度 O(1)
     * 解法3，哈希表，
     */

    public static void main(String[] args) {
        int[] nums = {39, 40, 16, 26, 17, 27, 41, 42, 23, 43, 44, 45, 18, 46, 28, 47, 48, 49, 19, 50, 21, 29, 20, 30, 1, 22, 2, 3, 4, 11, 5, 6, 7, 8, 9, 12, 10, 31, 13, 32, 33, 24, 14, 34, 35, 36, 25, 37, 15, 38};

        boolean containsDuplicate = containsDuplicate(nums);
        boolean containsDuplicateSort = containsDuplicateSort(nums);
        boolean containsDuplicateHash = containsDuplicateHash(nums);

        System.out.println(containsDuplicate);
        System.out.println(containsDuplicateSort);
        System.out.println(containsDuplicateHash);
    }

    /**
     * 朴素线性查找法 组合公式为C(n,2)=n*(n-1)/2*1，时间复杂度 O(n^2)，空间复杂度 O(1)
     * 这种方式LeetCode会超时
     */
    public static boolean containsDuplicate(int[] nums) {
        // 这里面的 ++i，++j 换成 i++，j++ 也没问题，只是在大量数据的for循环中，++i的性能高于i++
        // 因为i++是在使用当前值之后再+1，所以需要一个临时的变量来转存。
        // 而++i则是在直接+1，省去了对内存的操作的环节，相对而言能够提高性能。
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < i; ++j) {
                if (nums[j] == nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 排序 然后查找是否有连续相同的元素
     */
    public static boolean containsDuplicateSort(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 哈希表 时间复杂度、空间复杂度为 O(n)
     */
    public static boolean containsDuplicateHash(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;

    }

}