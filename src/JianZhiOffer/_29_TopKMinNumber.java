package JianZhiOffer;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 最小的K个数
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */

public class _29_TopKMinNumber {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {


        ArrayList<Integer> result = new ArrayList<Integer>();
        if (input.length<k) return result;
        Arrays.sort(input);
        for (int i = 0; i < k; i++) {
            result.add(input[i]);
        }
        return result;

        /**
         * 使用堆进行处理 O(nlogK)
         * ArrayList<Integer> res = new ArrayList<>();
         *         if (input == null || k <= 0 || k > input.length) {
         *             return res;
         *         }
         *         // 使用优先队列（PriorityQueue）进行处理  优先队列的作用是能保证每次取出的元素都是队列中权值最小的
         *         // Java的优先队列每次取最小元素   C++m每次取出最大的元素
         *         Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());
         *
         *         for (int i = 0; i < input.length; i++) {
         *
         *             if (queue.size() < k) {
         *                 queue.add(input[i]);
         *             } else {
         *                 if (input[i] < queue.peek()) {
         *                     queue.remove();
         *                     queue.add(input[i]);
         *                 }
         *             }
         *         }
         *         while (!queue.isEmpty()) {
         *             res.add(queue.remove());
         *         }
         *         return res;
         */

    }
}
