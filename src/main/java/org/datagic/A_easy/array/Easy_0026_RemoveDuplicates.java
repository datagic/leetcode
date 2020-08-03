package org.datagic.A_easy.array;

import java.util.Arrays;

/**
 * Desc: 删除排序数组中的重复项
 * Author: datagic (云瞻)
 * CreateDate: 2020/7/17 3:40 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0026_RemoveDuplicates {
    /**
     * 题目：给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：原地 空间复杂度O(1)，含义就是不能new新的数组来解题。数组是有序的，所以只要将不重复的元素依次移到左侧则完成。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：使用双指针法完成，定义两个指针p，q，将p放置在最左端，q放置在最左端+1位置，p、q比较是否相等，相等则q后移一位继续比较，
     * 不相等且q-p>1时，将q位置元素移动到p的下一位（若等于1，其实q位置元素本来就在p的下一位，无需原地移动），然后p++、q++，继续重复
     * 上述操作直到q等于数组长度则不再进行，返回数组的长度即p+1。
     */
    public static int removeDuplicates(int[] nums) {
        // 判断是否是个空数组，空的直接返回长度0
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // 将p放置在数组最左侧、q放置在最左端+1
        int p = 0;
        int q = 1;
        // "直到q等于数组长度则不再进行"，所以最后一次执行是 q = nums.length - 1
        while (q < nums.length) {
            // 不相等，将q位置元素移动到p的下一位
            if (nums[p] != nums[q]) {
                // 且q-p>1时
                if (q - p > 1) {
                    // 将q位置元素移动到p的下一位
                    nums[p + 1] = nums[q];
                }
                p++;
            }
            q++;
        }
        return p + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 0, 1, 1, 2, 3, 4, 5, 6, 6, 6, 7, 8};
        int newNumsLength = removeDuplicates(nums);
        System.out.println("移除后数组的新长度：" + newNumsLength);
        System.out.println("原地移动后的数组" + Arrays.toString(nums));
    }
}