package JianZhiOffer;

/**
 *输入一个链表，输出该链表中倒数第k个结点。
 */
public class _14_LianBiaoDaoShu {
        public class ListNode {
            int val;
            ListNode next = null;

            ListNode(int val) {
                this.val = val;
        }
        public ListNode FindKthToTail(ListNode head,int k) {
            /**
             * 使用两个快慢指针进行处理 两个指针间隔为 k
             */

            if (head==null || k<=0) return null;
            ListNode fast = head;
            for (int i = 1; i < k; i++) {
                if (fast.next != null){
                    fast = fast.next;
                }else{
                    return null;
                }
            }
            ListNode slow = head;
            while (fast.next != null){
                fast = fast.next;
                slow = slow.next;
            }

            return slow;

        }

        }
}
