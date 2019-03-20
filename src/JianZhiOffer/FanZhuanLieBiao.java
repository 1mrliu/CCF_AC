package JianZhiOffer;

/**
 * Created by liudong on 2019/3/20.
 *
 * 面试题：：反转单链表
 * 递归反转法：在反转当前节点之前先反转后续节点。这样从头结点开始，层层深入直到尾结点才开始反转指针域的指向。
 * 简单的说就是从尾结点开始，逆向反转各个结点的指针域指向
 *
 */
public class FanZhuanLieBiao {

    //定义链表的节点结构
    class Node {
        private int Data;// 数据域
        private Node Next;// 指针域

        public Node(int Data) {
            // super();
            this.Data = Data;
        }

        public int getData() {
            return Data;
        }

        public void setData(int Data) {
            this.Data = Data;
        }

        public Node getNext() {
            return Next;
        }

        public void setNext(Node Next) {
            this.Next = Next;
        }
    }
    /**
     * 递归  在反转当前节点之前先反转后续节点
     */
    public static Node Reversel(Node head){
        // head 看做是前一节点，head.getNext() 是当前节点
        // reHead 是反转后新链表的头结点

        // 如果为空或者当前节点在尾节点 则直接返回
        if (head == null || head.getNext() == null) {
            return head;
        }
        // 先反转后续节点 head.getNext()
        Node reHead = Reversel(head.getNext());
        // 将当前节点的指针域指向前一节点
        head.getNext().setNext(head);
        //前一节点的指针域令为null
        head.setNext(null);
        // 反转后新链表的头结点
        return reHead;
    }

}
