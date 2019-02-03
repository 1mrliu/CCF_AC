package LeetCode;

/**
 * Created by liudong on 2019/2/3.
 * Given a linked list, remove the n-th node from the end of list and return its head.

 Example:

 Given linked list: 1->2->3->4->5, and n = 2.

 After removing the second node from the end, the linked list becomes 1->2->3->5.

 Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 * Time O(L)   Space O(1)
 */
public class RemoveNthNodeFromEndofList_19 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
         ListNode dummy = new ListNode(0);
         dummy.next = head;
         int length = 0;
         ListNode first = head;
         while(first != null){
             length++;
             first = first.next;
         }
         length -= n;
         first = dummy;
         while(length > 0){
             length--;
             first = first.next;
         }
         first.next = first.next.next;
         return dummy.next;
    }
    public static void main(String[] args){

    }
}
