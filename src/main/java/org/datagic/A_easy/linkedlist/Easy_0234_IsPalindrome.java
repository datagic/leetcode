package org.datagic.A_easy.linkedlist;

/**
 * Desc: 回文链表
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/11 5:51 下午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Easy_0234_IsPalindrome {
    /**
     * 题目：请判断一个链表是否为回文链表。
     * ---------------------------------------------------------------------------------------------------------
     * 示例 1:
     * 输入: 1->2
     * 输出: false
     * 示例 2:
     * 输入: 1->2->2->1
     * 输出: true
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(5);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(1);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;

        boolean palindrome = isPalindrome(listNode1);
        boolean palindrome1 = isPalindrome1(listNode1);
        System.out.println(palindrome);
        System.out.println(palindrome1);
    }

    // 两个指针一个快一个慢，把慢的翻转过来然后和后面那一半去比较。
    public static boolean isPalindrome1(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (pre != null && slow != null) {
            if (pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }

    private static ListNode frontPointer;

    private static boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            // 直到currentNode没有下个元素的时候，不走这个if
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public static boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

}
