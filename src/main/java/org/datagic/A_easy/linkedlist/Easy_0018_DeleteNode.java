package org.datagic.A_easy.linkedlist;

/**
 * Desc: 删除链表中的节点
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/7 4:39 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0018_DeleteNode {
    /**
     * 题目：给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * 返回删除后的链表的头节点。
     * 注意：此题对比原题有改动
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * 说明：
     * 题目保证链表中节点的值互不相同
     * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
     */
    public static void main(String[] args) {
        // 4 -> 5 -> 1 -> 9
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode1 = new ListNode(1);
        ListNode listNode9 = new ListNode(9);

        listNode4.next = listNode5;
        listNode5.next = listNode1;
        listNode1.next = listNode9;

        // 删除之后并返回头结点
        ListNode listNode = deleteNode(listNode4, 5);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }

    public static ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode temp = head;
        if (head.val == val) {
            return head.next;
        }
        while (head.next != null) {
            if (head.next.val == val) {
                head.next = head.next.next;
                break;
            }
            head = head.next;
        }
        return temp;
    }
}