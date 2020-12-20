package DataStructure;

/**
 * 约瑟夫环的问题
 *  围坐在一起的人 如果报数是m就进行删除这个数值，问最后剩余的是
 */
public class _19_ {
    public class Node{
        public int value;
        public Node next;
        public Node(int data){
            this.value = data;
        }
    }
    // 报数等于m就进行删除
    public Node josephusKill(Node head, int m){

        if (head == null || head.next == head || m<1) return head;

        Node last = head;
        while (last.next != head){
            last = last.next;
        }
        int count = 0;
        while (head != last){
            if (++count == m){
                last.next = head.next;
                count = 0;
            }else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}
