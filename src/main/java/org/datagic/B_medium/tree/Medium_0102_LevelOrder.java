package org.datagic.B_medium.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Desc: 二叉树的层序遍历
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/19 5:07 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Medium_0102_LevelOrder {
    /**
     * 题目：给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
     * ---------------------------------------------------------------------------------------------------------
     * 示例：
     * 二叉树：[3,9,20,null,null,15,7],
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回其层次遍历结果：
     * [
     * [3],
     * [9,20],
     * [15,7]
     * ]
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        List<List<Integer>> lists = levelOrder(root);
        for (List l : lists) {
            System.out.println(l);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> t = new LinkedList<>();
        TreeNode temp;
        t.offer(root);
        List<Integer> sub = new ArrayList<>();
        sub.add(root.val);
        res.add(sub);
        while (!t.isEmpty()) {
            sub = new ArrayList<>();
            int size = t.size();
            for (int i = 0; i < size; i++) {
                temp = t.poll();
                if (temp.left != null) {
                    sub.add(temp.left.val);
                    t.offer(temp.left);
                }
                if (temp.right != null) {
                    sub.add(temp.right.val);
                    t.offer(temp.right);
                }
            }
            if (sub != null && sub.size() > 0) {
                res.add(sub);
            }
        }
        return res;
    }

}
