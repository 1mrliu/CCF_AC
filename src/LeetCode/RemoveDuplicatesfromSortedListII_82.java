package LeetCode;

import java.util.HashMap;

/**
 * Created by liudong on 2019/3/25.
 * Given a sorted linked list, delete all nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.

 Example 1:

 Input: 1->2->3->3->4->4->5
 Output: 1->2->5
 Example 2:

 Input: 1->1->1->2->3
 Output: 2->3
 */
public class RemoveDuplicatesfromSortedListII_82 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode nullHead = new ListNode(0);
        nullHead.next = head;
        ListNode pre = nullHead;
        ListNode cur = head;

        while(cur != null){
            while (cur.next != null && cur.val == cur.next.val){
                cur = cur.next;
            }
            if (pre.next == cur) {
               pre = pre.next;
            }else{
                pre.next = cur.next;
            }
            cur = cur.next;
        }
        return nullHead.next;
    }


//  递归方法
//    public ListNode deleteDuplicates(ListNode head) {
//        return backtrack(head,null);
//    }
//    private ListNode backtrack(ListNode head, ListNode pre){
//        if (head == null) {
//            return null;
//        }
//        if (pre != null && head.val == pre.val || head.next != null && head.val == head.next.val) {
//            return backtrack(head.next, head);
//        }else{
//            head.next = backtrack(head.next, head);
//            return head;
//        }
//    }

}
