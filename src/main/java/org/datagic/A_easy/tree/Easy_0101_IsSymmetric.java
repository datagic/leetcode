package org.datagic.A_easy.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Desc: 对称二叉树
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/19 10:01 上午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0101_IsSymmetric {
    /**
     * 题目：给定一个二叉树，检查它是否是镜像对称的。
     * ---------------------------------------------------------------------------------------------------------
     * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
     * 1
     * /  \
     * 2    2
     * / \  / \
     * 3  4 4  3
     * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
     * 1
     * / \
     * 2   2
     * \    \
     * 3    3
     * ---------------------------------------------------------------------------------------------------------
     * 进阶：
     * 你可以运用递归和迭代两种方法解决这个问题吗？
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        System.out.println(isSymmetric(root)); // 递归
        System.out.println(isSymmetricDieDai(root)); // 迭代
    }

    // ------------------------------------递归------------------------------------

    public static boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public static boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.val == q.val && check(p.left, q.right) && check(p.right, q.left);
    }

    // ------------------------------------迭代------------------------------------

    public static boolean isSymmetricDieDai(TreeNode root) {
        return checkDieDai(root, root);
    }

    public static boolean checkDieDai(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }

}
