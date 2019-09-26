package DataStructure;

public class _10_ {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    /**
     * 两两翻转链表中的数值
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode cur = head;

        while (cur.next != null && cur.next.next != null){
            ListNode node1 = cur.next;
            ListNode node2 = cur.next.next;

            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;

            cur = node1;
        }
        return pre.next;

    }
}