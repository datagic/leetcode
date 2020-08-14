package org.datagic.A_easy.linkedlist;

/**
 * Desc: 反转链表
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/11 11:36 上午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0024_ReverseList {
    /**
     * 题目：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
     * ---------------------------------------------------------------------------------------------------------
     * 示例:
     * 输入: 1->2->3->4->5->NULL
     * 输出: 5->4->3->2->1->NULL
     * 限制：
     * 0 <= 节点个数 <= 5000
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode res1 = reverseList(listNode1);

        while (res1 != null) {
            System.out.println(res1.val);
            res1 = res1.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//        ListNode pre = new ListNode(0);
//        ListNode tmp;
//        while (head != null) {
//            tmp = pre.next;
//            ListNode l = new ListNode(head.val);
//            pre.next = l;
//            pre.next.next = tmp;
//            head = head.next;
//        }
//        return pre.next;

        ListNode curr = head;
        ListNode prev = null;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}