package JianZhiOffer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 */
public class _16_MergeTwoSortedList {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode Merge(ListNode list1,ListNode list2) {

        // 链表为空
        if (list1 == null) return list2;

        if (list2 == null ) return list1;

        ListNode mergeHead;

        if (list1.val > list2.val){
            mergeHead = list2;
            mergeHead.next = Merge(list1,list2.next);
        }else {
            mergeHead = list1;
            mergeHead.next = Merge(list1.next,list2);
        }


        return mergeHead;
    }
}
