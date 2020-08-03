package org.datagic.A_easy.array;

import java.util.Arrays;

/**
 * Desc: 移动零
 * Author: datagic (云瞻)
 * CreateDate: 2020/7/30 4:38 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0283_MoveZeroes {
    /**
     * 题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * ---------------------------------------------------------------------------------------------------------
     * 示例:
     * 输入: [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     * 说明:
     * 必须在原数组上操作，不能拷贝额外的数组。
     * 尽量减少操作次数。
     * ---------------------------------------------------------------------------------------------------------
     * 题目解析：将所有的0移动到末尾，其余元素不能改变原来顺序，原地操作。提到原地，第一个想法就是双指针，具体看下面解法。
     * ---------------------------------------------------------------------------------------------------------
     * 时间复杂度：O(n)  空间复杂度：O(1)
     * ---------------------------------------------------------------------------------------------------------
     * 题目解法：
     * 解法1，两次遍历，第一次遍历，第一个指针遍历元素将所有的非0元素左移，第二个指针指向被移动的元素的位置。第一次遍历结束之后，第二
     * 个指针第一个0元素，将它和它之后的元素都赋值为0即可。
     * 解法2，一次遍历，
     */
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        //moveZeroes2Ergod(nums);
        moveZeroes1Ergod(nums);
        System.out.println(Arrays.toString(nums));
    }

    /**
     * 两次遍历
     * 第一次遍历，第一个指针遍历元素将所有的非0元素左移，第二个指针指向被移动的元素的位置。
     * 第一次遍历结束之后，第二个指针第一个0元素，将它和它之后的元素都赋值为0即可。
     */
    public static void moveZeroes2Ergod(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int p = 0;
        int q = 0;
        // p是往下遍历的指针，q是"卡住"非零元素的指针
        // p一直往下遍历，遇到非0则替换q的元素，q被p替换，q则后遗
        for (int i = 0; i < nums.length; i++) {
            if (nums[p] != 0) {
                nums[q] = nums[p];
                q++;
                p++;
            } else {
                p++;
            }
            if (p == nums.length) {
                break;
            }
        }
        // 第二次遍历赋值
        for (int i = q; i < nums.length; i++) {
            nums[q] = 0;
            q++;
        }

        /**
         *      上面我写的比较麻烦，LeetCode有一个答案非常优雅 如下：
         *
         * 		if(nums==null) {
         * 			return;
         *                }
         * 		//第一次遍历的时候，j指针记录非0的个数，只要是非0的统统都赋给nums[j]
         * 		int j = 0;
         * 		for(int i=0;i<nums.length;++i) {
         * 			if(nums[i]!=0) {
         * 				nums[j++] = nums[i];
         *            }
         *        }
         * 		//非0元素统计完了，剩下的都是0了
         * 		//所以第二次遍历把末尾的元素都赋为0即可
         * 		for(int i=j;i<nums.length;++i) {
         * 			nums[i] = 0;
         *        }
         *
         */
    }

    /**
     * 一次遍历 快速排序思想，放置一个flag，非0的在flag左侧，等于0的放在flag和其右侧
     */
    public static void moveZeroes1Ergod(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        // 立flag
        int flag = 0;
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                boolean exchange = false;
                if (nums[flag] == 0) {
                    exchange = true;
                }
                nums[flag] = nums[i];
                if (exchange) {
                    nums[i] = 0;
                }
                flag++;
            }
        }
    }
}