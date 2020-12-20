package DataStructure;

import java.util.PriorityQueue;

/**
 * 分金条的最小代价
 *
 */
public class _18_ {
    public int getMinSplitCost(int[] arr){
        if (arr == null || arr.length<2) return 0;
        // 优先队列就是小顶堆结构
        PriorityQueue<Integer> minHeap = new PriorityQueue <>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
        }

        int ans = 0;
        while (minHeap.size() != 1){
            int sum = minHeap.poll() + minHeap.poll();
            ans += sum;
            minHeap.add(sum);
        }
        return ans;
    }
}
