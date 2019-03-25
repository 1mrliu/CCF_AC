package JianZhiOffer;

/**
 * Created by liudong on 2019/3/25.
 * 对单链表进行排序操作
 */
public class DanLianBiaoSort {
    public class Node{
        int data;
        Node next = null;
        public Node(int data){
            this.data = data;
        }
    }
    //单链表进行排序
    public Node sortNodeList(Node head){
        //记录每次循环的最小值
        int temp;
        Node curNode = head;
        while (curNode != null){
            Node nextNode = curNode.next;
            while(nextNode != null){
                //比外层循环小的值放在前边
                 if (nextNode.data < curNode.data){
                     temp = nextNode.data;
                     nextNode.data = curNode.data;
                     curNode.data = temp;
                 }
                 nextNode = nextNode.next;
            }
            curNode = curNode.next;
        }
        return head;
    }
}
