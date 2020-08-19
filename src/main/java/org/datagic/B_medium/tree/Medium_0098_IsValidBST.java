package org.datagic.B_medium.tree;

/**
 * Desc: 验证二叉搜索树
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/17 6:16 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Medium_0098_IsValidBST {
    /**
     * 题目：给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     * 假设一个二叉搜索树具有如下特征：
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入:
     * 2
     * / \
     * 1   3
     * 输出: true
     * 示例 2:
     * 输入:
     * 5
     * / \
     * 1   4
     *      / \
     *     3   6
     * 输出: false
     * 解释: 输入为: [5,1,4,null,null,3,6]。
     *      根节点的值为 5 ，但是其右子节点值为 4 。
     */
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        root.left = new TreeNode(5);
//        root.right = new TreeNode(15);
//        root.right.right = new TreeNode(20);
//        root.right.left = new TreeNode(6);
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(1);
        root.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(8);
//        root.right.right.left = new TreeNode(13);
        root.right.right.right = new TreeNode(19);
        System.out.println(isValidBST(root));
    }

    /*private static long pre = Long.MIN_VALUE;

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null) {
            if (!isValidBST(root.left)) {
                return false;
            }
        }
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return isValidBST(root.right);
    }*/

    public static boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null) {
            return true;
        }
        int val = node.val;
        if (lower != null && val <= lower) {
            return false;
        }
        if (upper != null && val >= upper) {
            return false;
        }

        if (!helper(node.right, val, upper)) {
            return false;
        }
        if (!helper(node.left, lower, val)) {
            return false;
        }
        return true;
    }

    public static boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }
}