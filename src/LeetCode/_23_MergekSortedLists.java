package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by liudong on 2019/4/2.
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.

 Example:

 Input:
 [
 1->4->5,
 1->3->4,
 2->6
 ]
 Output: 1->1->2->3->4->4->5->6
 */
public class _23_MergekSortedLists {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
       }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        for (ListNode node :lists){
            while (node != null){
               list.add(node.val);
               node = node.next;
            }
        }
        // 使用collections对list进行排序
        Collections.sort(list);
        ListNode head = new ListNode(0);
        ListNode p = head;
        for (int i: list){
            p.next = new ListNode(i);
            p = p.next;
        }
        return head.next;
    }
}
