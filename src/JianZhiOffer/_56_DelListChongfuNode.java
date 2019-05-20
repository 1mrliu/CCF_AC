package JianZhiOffer;

/**
 *
 * 删除链表中重复的节点
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class _56_DelListChongfuNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        ListNode result;
        ListNode temp = pHead;
        ListNode index = new ListNode(0);
        index.next = pHead;
        result = index;

        while(temp != null){
            if (temp.next != null && temp.next.val == temp.val){
                // 为了处理链表中都是一样的数的情况
                while (temp.next != null && temp.next.val == temp.val){
                    temp = temp.next;
                }

                temp = temp.next;
                index.next = temp;
            }else {
                index=index.next;
                temp=temp.next;
            }
        }
        return result.next;
    }

}
