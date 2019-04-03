package LeetCode;

/**
 * Created by liudong on 2019/2/23.
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.

 Example 1:

 Input: 1->2->3->4->5->NULL, k = 2
 Output: 4->5->1->2->3->NULL
 Explanation:
 rotate 1 steps to the right: 5->1->2->3->4->NULL
 rotate 2 steps to the right: 4->5->1->2->3->NULL
 Example 2:

 Input: 0->1->2->NULL, k = 4
 Output: 2->0->1->NULL
 Explanation:
 rotate 1 steps to the right: 2->0->1->NULL
 rotate 2 steps to the right: 1->2->0->NULL
 rotate 3 steps to the right: 0->1->2->NULL
 rotate 4 steps to the right: 2->0->1->NULL
 因为与列表的长度相比，n可能是大数。所以我们需要知道链表的长度。之后，将第（ln％l）个节点之后的列表移到前面以完成轮换。

 例如：{1,2,3} k = 2将第一个节点后的列表移到前面

 例如：{1,2,3} k = 5，在这种情况下，将（3-5％3 = 1）st节点后的列表移到前面。

 所以代码有三个部分。

 得到长度

 移至第（ln％l）个节点

 3）做旋转
 */
public class _61_RotateList {
    public class ListNode {
       int val;
       ListNode next;
       ListNode(int x) { val = x; }
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next == null)
            return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int i;
        // get the length of list
        for(i=0;fast.next !=null;i++){
            fast = fast.next;
        }
        // i-k%i the node
        for(int j=i-k%i;j>0;j--){
            slow = slow.next;
        }

        // rotation
        fast.next = dummy.next;
        dummy.next = slow.next;
        slow.next = null;


        return dummy.next;
    }
    }

