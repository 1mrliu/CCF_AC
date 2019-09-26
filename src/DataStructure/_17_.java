package DataStructure;

/**
 * 合并两个有序链表
 *
 */
public class _17_ {
    public class Node{
        public  int value;
        public Node next;
        private Node(int data){
            this.value = data;
        }
    }

    public Node merge(Node head1, Node head2){
        if (head1 == null || head2 == null)
            return head1 != null ? head1:head2;

        Node mergeHead = null;

        if (head1.value < head2.value){
            mergeHead = head1;
            mergeHead.next = merge(head1.next,head2);
        }else {
            mergeHead.next = head2;
            mergeHead.next = merge(head1,head2.next);
        }
        return mergeHead;
    }
}
