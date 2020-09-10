package org.datagic.A_easy.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Desc: 二叉树的最大深度
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/14 5:04 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0104_MaxDepth {
    /**
     * 题目：给定一个二叉树，找出其最大深度。
     * ---------------------------------------------------------------------------------------------------------
     * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
     * 说明: 叶子节点是指没有子节点的节点。
     * 示例：
     * 给定二叉树 [3,9,20,null,null,15,7]，
     * 3
     * / \
     * 9  20
     * /  \
     * 15   7
     * 返回它的最大深度 3 。
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode lleft = new TreeNode(15);
        TreeNode rright = new TreeNode(7);
        root.left = left;
        left.left = lleft;
        root.right = right;
        right.right = rright;
//        int ii = maxDepth2(root);
//        System.out.println(ii);
//
//        List l = new ArrayList<TreeNode>();
//        List<TreeNode> list = preorderTraverse(root, l);
//        for (TreeNode t : list) {
//            System.out.println(t.val);
//        }

        //TreeNode.qianxu(root);
        //TreeNode.zhongxu(root);
        TreeNode.houxu(root);
    }

    public static List<TreeNode> preorderTraverse(TreeNode node, List list) {
        //首先从根节点开始遍历
        list.add(node);
        if (node.left != null) {
            preorderTraverse(node.left, list);
        }
        if (node.right != null) {
            preorderTraverse(node.right, list);
        }
        return list;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int lm = maxDepth(root.left);
            int rm = maxDepth(root.right);
            return Math.max(lm, rm) + 1;
        }
    }

    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         * offer，add 区别：
         * 一些队列有大小限制，因此如果想在一个满的队列中加入一个新项，多出的项就会被拒绝。
         * 这时新的 offer 方法就可以起作用了。它不是对调用 add() 方法抛出一个 unchecked 异常，
         * 而只是得到由 offer() 返回的 false。
         *
         * poll，remove 区别：
         * remove() 和 poll() 方法都是从队列中删除第一个元素。remove() 的行为与 Collection 接口的版本相似，
         * 但是新的 poll() 方法在用空集合调用时不是抛出异常，只是返回 null。因此新的方法更适合容易出现异常条件的情况。
         *
         * peek，element区别：
         * element() 和 peek() 用于在队列的头部查询元素。与 remove() 方法类似，在队列为空时， element() 抛出一个异常，
         * 而 peek() 返回 null。
         */

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                TreeNode troot = queue.poll();
                if (troot.left != null) {
                    queue.offer(troot.left);
                }
                if (troot.right != null) {
                    queue.offer(troot.right);
                }
                size--;
            }
            res++;
        }
        return res;
    }
}