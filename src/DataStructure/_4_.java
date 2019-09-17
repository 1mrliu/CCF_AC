package DataStructure;

/**
 * 链表是否有环
 */

public class _4_ {
    private static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    private static boolean isCycle(Node head){
        Node p1 = head;
        Node p2 = head;
        while (p1.next != null && p2.next!=null){
            p1 = p1.next;
            p2 = p2.next.next;
            if(p1 == p2) return true;
        }
        return false;

    }

}
