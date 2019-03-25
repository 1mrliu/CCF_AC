package LeetCode;

import java.util.HashMap;

/**
 * Created by liudong on 2019/3/25.
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

 Example 1:

 Input: 1->1->2
 Output: 1->2
 Example 2:

 Input: 1->1->2->3->3
 Output: 1->2->3

 */
public class RemoveDuplicatesfromSortedList_83 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;

        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val) {
                cur.next =  cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;

//        HashMap<Integer, Integer> table = new HashMap<Integer, Integer>();
//        ListNode temp = head;
//        ListNode pre = null; //辅助链表的头节点
//        while (temp != null) {
//            if (table.containsKey(temp.val))
//                pre.next = temp.next;
//            else {
//                table.put(temp.val, 1);
//                pre = temp;
//            }
//            temp = temp.next;
//        }
//        return pre;
    }
}
