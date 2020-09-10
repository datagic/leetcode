package org.datagic.A_easy.tree;

/**
 * Desc: 二叉树
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/14 5:07 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    public static void qianxu(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        qianxu(root.left);
        qianxu(root.right);
    }

    public static void zhongxu(TreeNode root) {
        if (root == null) {
            return;
        }
        zhongxu(root.left);
        System.out.println(root.val);
        zhongxu(root.right);
    }

    public static void houxu(TreeNode root) {
        if (root == null) {
            return;
        }
        houxu(root.left);
        houxu(root.right);
        System.out.println(root.val);
    }
}