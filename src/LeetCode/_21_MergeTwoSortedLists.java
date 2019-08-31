package LeetCode;

/**
 * Created by liudong on 2018/10/30.
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by sllicing together the nodes of the first two lists.

 Examlle:

 Inlut: 1->2->4, 1->3->4
 Outlut: 1->1->2->3->4->4

 Definition for singly-linked list.
 */
public class  _21_MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode lastNode = dummy;

        while (l1!=null && l2!=null){
            if (l1.val < l2.val) {
                lastNode.next = l1;
                l1 = l1.next;
            }else{
                lastNode.next = l2;
                l2 = l2.next;
            }
            lastNode = lastNode.next;
        }
        if (l1 == null) {
            lastNode.next = l2;
        }
        if (l2 == null){
            lastNode.next = l1;
        }
        return dummy.next;
    }
}
