package DataStructure;

import java.util.LinkedList;

/**
 * 生成窗口最大值数组
 * 从数组中按照固定的窗口大小，每次移动一位，取窗口中最大的值
 * 输出这些最大的值
 *
 */
public class _25_ {
    public int[] getMaxWindow(int[] arr, int w){
        if (arr == null || w < 1 || arr.length < w) return null;
        // 相对于 ArrayList 集合，LinkedList 集合多实现了一个 Deque 接口，
        // 这是一个双向队列接口，双向队列就是两端都可以进行增加和删除操作。
        LinkedList<Integer> qmax = new LinkedList <>();
        int[] res = new int[arr.length-w+1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
                qmax.pollLast();
            }
            qmax.addLast(i);
            if (qmax.peekFirst() == i-w){
                qmax.pollFirst();
            }
            if (i >= w-1){
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }

    // test
    public static void main(String[] args){
        int[] arr = {4,3,5,4,3,3,6,7};
        int w = 3;
        _25_ rr = new _25_();
        int[] result = rr.getMaxWindow(arr, w);
        for (Integer e:result)
            System.out.print(e);
    }
}
