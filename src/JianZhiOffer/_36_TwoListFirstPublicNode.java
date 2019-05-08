package JianZhiOffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 两个链表的第一个公共结点
 * 输入两个链表，找出它们的第一个公共结点。
 */
public class _36_TwoListFirstPublicNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();

        while (pHead1!=null){
            stack1.add(pHead1);
            pHead1 = pHead1.next;
        }

        while (pHead2 != null){
            stack2.add(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode result = null;
        while(!stack1.isEmpty() && !stack2.isEmpty() && stack1.peek() == stack2.peek()){
           stack2.pop();
           result = stack1.pop();
        }

        return result;




    }
}
