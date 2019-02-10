package LeetCode;

/**
 * Created by liudong on 2019/2/10.
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class SwapNodesinPairs_24 {
    // Definition for singly-linked list
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
      }
    }
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next==null)) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }
}
