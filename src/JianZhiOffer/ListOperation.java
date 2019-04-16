package JianZhiOffer;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

/**
 * 对链表的操作进行整理
 */

public class ListOperation {
    public class Node{
        int data;
        Node next;
        public Node(int val){
            this.data = val;
        }
    }

    Node head = null;

    /**
     * 向链表中插入数据
     * @param d 数据的内容
     */
   public void addNode(int d){
       Node newNode = new Node(d);
       if (head == null) {
           head = newNode;
           return;
       }

       Node tmp = head;
       while(tmp.next != null){
         tmp = tmp.next;
       }

       //add node to end
       tmp.next = newNode;
   }

    /**
     * 删除链表中的结点
     * @param index 删除第index的结点
     * @return 成功返回true  不成功返回false
     */
   public boolean deleteNode(int index){
       if (index < 1 || index > length()) {
           return false;
       }
       //删除链表第一个元素
       if (index == 1){
           head = head.next;
           return true;
       }

       int i = 2;
       Node preNode = head;
       Node curNode = preNode.next;
       while(curNode != null){
           if (i == index){
               preNode.next = curNode.next;
               return true;
           }
           preNode = curNode;
           curNode = curNode.next;
           i++;
       }
       return true;
   }

    /**
     *
     * @return 返回结点的长度
     */
   public int length(){
       int length = 0;
       Node tmp = head;
       while (tmp !=null){
           length++;
           tmp = tmp.next;
       }

       return length;
   }

    /**
     * 对链表进行排序
     * @return
     */
   public Node orderList(){
       Node nextNode = null;
       int temp = 0;
       Node curNode = head;
       while (curNode.next != null){
           nextNode = curNode.next;

           while (nextNode != null){
               if (curNode.data > nextNode.data){
                  temp = curNode.data;
                  curNode.data = nextNode.data;
                  nextNode.data = temp;
               }
               nextNode = nextNode.next;
           }

          curNode = curNode.next;
       }
       return head;
   }

    /**
     * 从链表中删除重复数据
     * @param head
     */
   public void deleteDuplicate(Node head){
       Hashtable<Integer,Integer> table = new Hashtable<>();
       Node tmp  =head;
       Node pre = null;
       while (tmp != null){
           if (table.containsKey(tmp.data)){
               pre.next = tmp.next;
           }else{
               table.put(tmp.data,1);
               pre = tmp;
           }

           tmp = tmp.next;
       }
   }

    /**
     * 双重循环遍历   从链表中删除重复数据
     * @param head
     */
   public void deleteDuplicate_1(Node head){
       Node p = head;
       while(p != null){
           Node q = p;
           while (q.next != null){
               if (q.data == q.next.data){
                   q.next =  q.next.next;
               }else {
                   q = q.next;
               }
           }

           p = p.next;
       }
   }

    /**
     * 反转列表 实现非递归方法进行反转
     * @param
     */
   public void reverse(){
       Node pReversedHead = head;
       Node pNode = head;
       Node pPrev = null;

       while (pNode != null){
           Node pNext = pNode.next;
           if (pNext == null)
               pReversedHead = pNode;

           pNode.next = pPrev;
           pPrev = pNode;
           pNode = pNext;
       }
       this.head = pReversedHead;

   }




   public void printList(){
       Node tmp = head;
       while(tmp != null ){
           System.out.println(tmp.data);
           tmp = tmp.next;
       }
   }


   public static void main(String[] args){
       ListOperation list = new ListOperation();
       list.addNode(5);
       list.addNode(3);
       list.addNode(1);
       list.addNode(3);
       System.out.println("ListLength="+list.length());
       System.out.println("before sort");
       list.printList();
       list.orderList();
       System.out.println("after sort");
       list.printList();
       System.out.println("reverse sort");
       list.reverse();
       list.printList();


   }





}
