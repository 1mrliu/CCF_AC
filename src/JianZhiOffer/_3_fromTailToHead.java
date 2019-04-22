package JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 */

public class _3_fromTailToHead {
    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if (listNode == null || listNode.next == null) {
            return new ArrayList<>();
        }
        ListNode head = listNode;
        Stack<ListNode> stack = new Stack<>();
        while(head.next != null){
            stack.push(head);
            head = head.next;
        }
        stack.push(head);
        ArrayList<Integer> arrayList = new ArrayList<>();
        while(!stack.isEmpty()){
            arrayList.add(stack.pop().val);
        }
        return arrayList;
    }

}
