package org.datagic.A_easy.tree;

/**
 * Desc: 将有序数组转换为二叉搜索树
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/20 1:48 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0108_SortedArrayToBST {
    /**
     * 题目：将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
     * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
     * ---------------------------------------------------------------------------------------------------------
     * 示例:
     * 给定有序数组: [-10,-3,0,5,9],
     * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
     * 0
     * / \
     * -3   9
     * /   /
     * -10  5
     */
    public static void main(String[] args) {
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode res = sortedArrayToBST(nums);
        TreeNode.zhongxu(res);
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);
    }

    public static TreeNode dfs(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;

        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, left, mid - 1);
        node.right = dfs(nums, mid + 1, right);
        return node;
    }
}
