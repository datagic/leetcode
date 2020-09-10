package org.datagic.D_Sort;

import java.util.Arrays;

/**
 * Desc: 合并两个有序数组
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/21 11:01 上午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Sort_0088_Merge {
    /**
     * 题目：给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。
     * ---------------------------------------------------------------------------------------------------------
     * 说明:
     * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。
     * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
     * 示例:
     * 输入:
     * nums1 = [1,2,3,0,0,0], m = 3
     * nums2 = [2,5,6],       n = 3
     * 输出: [1,2,2,3,5,6]
     */
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        int m = 3;
        int n = 3;
        Solution.merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = 0;
        int q = 0;
        while (p < n) {
            if (nums2[q] < nums1[p]) {
                int temp = nums2[q];
                nums2[q] = nums1[p];
                nums1[p] = temp;
                q++;
            }
            p++;
        }
        for (int i = 0; i < nums2.length; i++) {
            nums1[i + m] = nums2[i];
        }
    }

}


class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            // nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];

            if (nums1[len1] > nums2[len2]) {
                nums1[len] = nums1[len1];
                len--;
                len1--;
            } else {
                nums1[len] = nums2[len2];
                len--;
                len2--;
            }

        }
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
    }
}
