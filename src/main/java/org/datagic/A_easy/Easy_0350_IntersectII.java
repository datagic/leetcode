package org.datagic.A_easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


/**
 * Desc: 两个数组的交集II
 * Author: datagic (云瞻)
 * CreateDate: 2020/7/29 5:01 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0350_IntersectII {
    /**
     * 题目：给定两个数组，编写一个函数来计算它们的交集。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     * 示例 2:
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     * ---------------------------------------------------------------------------------------------------------
     * 说明：
     * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
     * 我们可以不考虑输出结果的顺序。
     * 进阶：
     * 如果给定的数组已经排好序呢？你将如何优化你的算法？
     * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
     * 如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：题目很好理解，求交集。数组a中出现n次i，数组b中出现m次i，则交集中有|n-m|个i
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：
     * 哈希表法，将较短的数组遍历（减少空间复杂度），记录key为数组元素，value为出现次数；然后遍历较长的数组，当key中有该元素，且value
     * 不为0，则放入结果数组中，并将value-1。这种方式的原理是：对于一个元素，其在交集中出现的次数等于该元素在两个数组中出现次数的最小值。
     * 时间复杂度：O(m+n)，空间复杂度：O(min(m,n))
     * 有序情况，使用双指针法。把两个指针放在两个数组的头部，比较两个头部元素大小，若不相等，则更小的元素指针后移一位继续比较，如果相等，
     * 则记录该值到结果数组中，并同时将两指针后移一位反复操作，指导某一数组遍历完成。
     */
    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        // int[] result = intersectHash(nums1, nums2);
        int[] result = intersectSort(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 哈希表法
     */
    public static int[] intersectHash(int[] nums1, int[] nums2) {
        // 将长度较小的放到HashMap中，减少空间复杂度
        if (nums1.length > nums2.length) {
            return intersectHash(nums2, nums1);
        }
        // 将长度较小的num1放入HashMap，遍历num1并计数。
        Map<Integer, Integer> hashMap = new HashMap<>();
        for (int n : nums1) {
            hashMap.put(n, hashMap.getOrDefault(n, 0) + 1);
        }
        // 初始化结果数组，最大为最长数组的长度
        int[] intersection = new int[nums1.length];
        // 结果数组中的元素靠index赋值。
        int index = 0;
        for (int n : nums2) {
            // 判断nums中是否存在元素为hashMap的key，当key中有该元素，且value不为0，则放入结果数组中，并将value-1。
            if (hashMap.getOrDefault(n, 0) > 0) {
                intersection[index] = n;
                index++;
                hashMap.put(n, hashMap.get(n) - 1);
            }
        }
        // 返回正确长度的结果数组
        return Arrays.copyOfRange(intersection, 0, index);
    }

    // 若两个数组有序
    public static int[] intersectSort(int[] nums1, int[] nums2) {
        if (nums1.length == 0) {
            return nums1;
        }
        if (nums2.length == 0) {
            return nums2;
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        // 初始化两个指针，z1指向nums1头结点，z2指向nums2头结点。
        int z1 = 0;
        int z2 = 0;
        // 计算两个数组长度，以防指针越界。
        int l1 = nums1.length;
        int l2 = nums2.length;
        // 初始化结果数组，最大为最长数组的长度
        int[] intersection = new int[Math.max(nums1.length, nums2.length)];
        // 结果数组中的元素靠index赋值。
        int index = 0;
        do {
            if (nums1[z1] > nums2[z2]) {
                z2++;
            } else if (nums1[z1] < nums2[z2]) {
                z1++;
            } else {
                // 数组赋值
                intersection[index] = nums1[z1];
                z1++;
                z2++;
                index++;
            }
        } while (z1 != l1 && z2 != l2);
        return Arrays.copyOfRange(intersection, 0, index);
    }
}
