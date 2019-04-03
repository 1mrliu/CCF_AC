package LeetCode;

import java.util.PriorityQueue;

/**
 * Created by liudong on 2018/11/5.
 *Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.

 Example:

 int k = 3;
 int[] arr = [4,5,8,2];
 KthLargest kthLargest = new KthLargest(3, arr);
 kthLargest.add(3);   // returns 4
 kthLargest.add(5);   // returns 5
 kthLargest.add(10);  // returns 5
 kthLargest.add(9);   // returns 8
 kthLargest.add(4);   // returns 8
 Note:
 You may assume that nums' length ≥ k-1 and k ≥ 1.
 *
 */
public class _703_KthLargestElementInAStream {
    final PriorityQueue<Integer> q;
    final int k;
    public _703_KthLargestElementInAStream(int k, int[] nums) {
        this.k = k;
        q = new PriorityQueue<>(k);
        for(int n: nums)
            add(n);
    }

    public int add(int val) {
        if(q.size() < k)
            q.offer(val);
        else if(q.peek() < val){
            q.poll();
            q.offer(val);
        }
        return q.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */