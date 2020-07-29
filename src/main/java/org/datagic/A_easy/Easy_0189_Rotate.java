package org.datagic.A_easy;

import java.util.Arrays;

/**
 * Desc: 旋转数组
 * Author: datagic (云瞻)
 * CreateDate: 2020/7/27 4:56 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0189_Rotate {
    /**
     * 题目：给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
     * 示例 1:
     * 输入: [1,2,3,4,5,6,7] 和 k = 3
     * 输出: [5,6,7,1,2,3,4]
     * 解释:
     * 向右旋转 1 步: [7,1,2,3,4,5,6]
     * 向右旋转 2 步: [6,7,1,2,3,4,5]
     * 向右旋转 3 步: [5,6,7,1,2,3,4]
     * 示例 2:
     * 输入: [-1,-100,3,99] 和 k = 2
     * 输出: [3,99,-1,-100]
     * 解释:
     * 向右旋转 1 步: [99,-1,-100,3]
     * 向右旋转 2 步: [3,99,-1,-100]
     * 说明:
     * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
     * 要求使用空间复杂度为 O(1) 的 原地 算法。
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：因为要原地将数组进行旋转，所以使用额外的数组，不是本题的最佳解。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：
     * 非原地法，使用额外的数组，时间、空间复杂度皆为 O(n)
     * 原地法1，暴力法，将数组旋转k次，时间复杂度 O(n∗k)，空间复杂度O(1)
     * 原地法2：环状替换法 时间复杂度 O(n)，空间复杂度 O(1)
     * 原地法3：反转法 时间复杂度 O(n)，空间复杂度 O(1)
     */
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int k = 3;

        // 暴力法
        // rotateBL(nums, k);

        // 环状替换法
        // rotateHZTH(nums, k);

        // 反转法
        rotateFZ(nums, k);

        System.out.println(Arrays.toString(nums));

    }

    /**
     * 暴力法，将数组旋转k次
     */
    public static void rotateBL(int[] nums, int k) {
        // 如果k<=0 则不作旋转操作; 如果k对数组长度取余为0，说明换来换去又回到原点了，也不做旋转操作。
        if (k <= 0 || k % nums.length == 0) {
            return;
        }
        // 实际要做的操作次数
        k = k % nums.length;
        // 设置中介值temp和随便一个位置的prev当做数组头
        int temp, prev;
        for (int i = 0; i < k; i++) {
            // 为计数方便，设置数组最后一个元素为头元素
            prev = nums.length - 1;
            for (int j = 0; j < nums.length - 1; j++) {
                temp = nums[j];
                nums[j] = nums[prev];
                nums[prev] = temp;
            }
        }
    }

    /**
     * 环状替换法，直接将某一元素放到最终的位置，被替换的元素存到temp中进而放到它的最终位置，如此循环n次，n为数组长度。
     * 类似 n=4  k=2 这种情况其实就是在替换的过程中，出现了还未完成全部替换的情况下，替换到了曾经替换过的地方，导致结果错误。
     * 比如：nums=[1,2,3,4]  k=2   1替换3，3替换1，即使反复循环，也无法替换到2和4。所以当这种情况出现时，要从下一个数字开始
     * 再重复相同的过程。
     */
    public static void rotateHZTH(int[] nums, int k) {
        // 如果k<=0 则不作旋转操作; 如果k对数组长度取余为0，说明换来换去又回到原点了，也不做旋转操作。
        if (k <= 0 || k % nums.length == 0) {
            return;
        }
        // 实际要做的操作次数
        k = k % nums.length;

        // 初始化移动次数
        int count = 0;
        // 初始化开始值，当移动次数为数组长度时，停止循环
        for (int start = 0; count < nums.length; start++) {
            // 设置当前值为开始值，当发生移动到之前移动过的位置时（start 等于 current），当前值加一，继续 while 循环。
            int current = start;
            // 设置开始的元素为prev
            int prev = nums[start];
            do {
                // 计算下一个位置为 当前位置+k 对 nums的长度取余
                int next = (current + k) % nums.length;
                // 把即将被替换的元素临时存出来
                int temp = nums[next];
                // 将开始元素替换到它的最终位置
                nums[next] = prev;
                // 被替换的元素变成开始元素
                prev = temp;
                // 被替换的位置变成当前位置
                current = next;
                // 替换次数计数
                count++;
                // 当前值和开始值不同代表没有替换到之前替换过的位置，则循环继续
            } while (start != current);
        }
    }

    /**
     * 反转法，数据无论如何移动，比如 1,2,3,4,5  ==>  3,4,5,1,2  其实都是将原数组反转之后，再把前k和后面的数据分别反转。
     * 5,4,3,2,1  ==>   3,4,5,2,1  ==>  3,4,5,1,2
     */
    public static void rotateFZ(int[] nums, int k) {
        // 如果k<=0 则不作旋转操作; 如果k对数组长度取余为0，说明换来换去又回到原点了，也不做旋转操作。
        if (k <= 0 || k % nums.length == 0) {
            return;
        }
        // 实际要做的操作次数
        k = k % nums.length;
        // 反转数组
        // 5,4,3,2,1
        reverse(nums, 0, nums.length - 1);
        // 3,4,5,2,1
        reverse(nums, 0, k - 1);
        // 3,4,5,1,2
        reverse(nums, k, nums.length - 1);

    }

    // 反转数组
    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}