package org.datagic.B_medium.linkedlist;

/**
 * Desc: 删除链表的倒数第N个节点
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/10 11:39 上午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Medium_0019_RemoveNthFromEnd {
    /**
     * 题目：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * ---------------------------------------------------------------------------------------------------------
     * 示例：
     * 给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 说明：
     * 给定的 n 保证是有效的。
     * 进阶：
     * 你能尝试使用一趟扫描实现吗？
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
        ListNode listNode = removeNthFromEnd(listNode1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

//        ListNode listNode1 = new ListNode(1);
//        ListNode listNode2 = new ListNode(2);
//        listNode1.next = listNode2;
//        ListNode listNode = removeNthFromEnd(listNode1, 2);
//        while (listNode != null) {
//            System.out.println(listNode.val);
//            listNode = listNode.next;
//        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return head;
        }
        if (head.next == null && n == 1) {
            return null;
        }
        ListNode res = head;
        ListNode temp = head;
        int count = 0;
        while (head.next != null) {
            head = head.next;
            count++;
            if (count >= n) {
                if (temp.next.next == null) {
                    temp.next = null;
                    return res;
                } else if (head.next == null) {
                    temp.next = temp.next.next;
                } else {
                    temp = temp.next;
                }
            } else if (head.next == null) {
                res = res.next;
            }
        }
        return res;
    }
}
