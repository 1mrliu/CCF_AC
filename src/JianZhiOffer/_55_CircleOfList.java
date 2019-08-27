package JianZhiOffer;

/**
 * 链表中环的节点
 *给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class _55_CircleOfList {

    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    // 先判断有没有环
    // 有环的话判断环中有几个数
    // 设置两个指针 间隔环的个数  同时移动 当相遇的时候就找到了环的入口节点
    public ListNode EntryNodeOfLoop(ListNode pHead) {
          if (pHead == null || pHead.next == null) return null;
          if (getCircle(pHead) == null) return null;
          int countCircle = 1;
          ListNode meetNode = getCircle(pHead);
          ListNode p = meetNode;
          while (p.next != meetNode){
              p = p.next;
              ++countCircle;
          }

          // 两个指针移开间隔为环的个数
          ListNode p1 = pHead;
        for (int i = 0; i < countCircle; i++) {
            p1 = p1.next;
        }

        ListNode p2 = pHead;
        while (p1.val != p2.val){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }

    // 判断是不是环
    private ListNode getCircle(ListNode pHead){
        ListNode slow = pHead;
        ListNode quick = pHead.next.next;
        while (quick.next != null && slow.next!=null){
            if (quick.val == slow.val){
                return slow;
            }else {
                quick = quick.next;
                if (quick.next != null) quick = quick.next;
                slow = slow.next;
            }
        }
        return null;
    }
    // 解法2
    // 首先判断是不是一个环
    private ListNode findLoopPort(ListNode head){
        // 先判断像雨点的位置
        ListNode slow = head;
        ListNode fast = head;
        if (fast == null){
            return null;
        }
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow)
                break;
        }
        if (fast == null || fast.next == null)
            return null;

        slow = head;
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
