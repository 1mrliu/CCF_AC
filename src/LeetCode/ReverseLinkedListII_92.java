package LeetCode;

/**
 * Created by liudong on 2019/2/24.
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
 */
public class ReverseLinkedListII_92 {
    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val = x;
        }
    }
    private boolean stop;
    private ListNode left;

    public void recurseAndReverse(ListNode right, int m, int n) {
        //bade case
        if(n == 1){
            return ;
        }
        //moving right pointer one step forward until (n==1)
        right = right.next;

        if(m >1){
            this.left = this.left.next;
        }

        this.recurseAndReverse(right, m-1,n-1);
        if(this.left == right || right.next == this.left){
            this.stop = true;
        }
        if(!this.stop){
            int t = this.left.val;
            this.left.val = right.val;
            right.val = t;
            this.left = this.left.next;
        }

    }
    public ListNode reverseBetween(ListNode head,int m, int n){
        this.left = head;
        this.stop = false;
        this.recurseAndReverse(head,m,n);
        return head;
    }

}
