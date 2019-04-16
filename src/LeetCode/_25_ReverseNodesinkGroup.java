package LeetCode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 *
 * Given this linked list: 1->2->3->4->5
 *
 * For k = 2, you should return: 2->1->4->3->5
 *
 * For k = 3, you should return: 3->2->1->4->5
 *
 * Note:
 *
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *链表进行排序
 */

 // Definition for singly-linked list.

public class _25_ReverseNodesinkGroup {

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }


    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        int len = 1;
        while (head.next !=null){
            len++;
            head = head.next;
        }

        ListNode pre = dummy;
        for (int i = 0; i+k <= len ; i+=k) {
            ListNode cur = pre.next;
            ListNode nxt = cur.next;
            for (int j = 1; j < k; j++) {
                // swap two node
                cur.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = cur.next;
            }
            pre = cur;
        }
        return dummy.next;
    }
}
