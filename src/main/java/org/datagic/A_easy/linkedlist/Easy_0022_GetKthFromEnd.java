package org.datagic.A_easy.linkedlist;

/**
 * Desc: 删除链表的倒数第N个节点
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/7 6:21 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0022_GetKthFromEnd {
    /**
     * 题目：输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
     * 例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。
     * ---------------------------------------------------------------------------------------------------------
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 k = 2.
     * 返回链表 4->5.
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        int k = 2;
        ListNode result = getKthFromEnd(listNode1, k);

        if (result == null) {
            return;
        }

        while (result.next != null) {
            System.out.println(result.val);
            result = result.next;
        }

        if (result.next == null) {
            System.out.println(result.val);
        }
    }

    public static ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        return null;
    }

}
