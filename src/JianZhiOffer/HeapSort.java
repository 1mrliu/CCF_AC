package JianZhiOffer;

import java.util.ArrayList;

/**
 *  堆排序
 */
public class HeapSort {

    public class  Heap{
        private ArrayList<Integer> A;

        private int heapSize;

        public ArrayList<Integer> getA() {
            return A;
        }

        public void setA(ArrayList<Integer> a) {
            A = a;
        }

        public int getHeapSize() {
            return heapSize;
        }

        public void setHeapSize(int heapSize) {
            this.heapSize = heapSize;
        }

    }
    // 左节点下标
    public int left(int i) {
        return i * 2 + 1;
    }

    // 右节点下标
    public int right(int i) {
        return i * 2 + 2;
    }

    // 父节点下标
    public int parent(int i) {
        return (i - 1) / 2;
    }
    /**
     * 递归实现的堆排序
     * @param heap 堆
     * @param i 当前坐标
     */
    public void MaxHeapify(Heap heap, int i) {
        int l = left(i);
        int r = right(i);
        int largest = i;
        if (l < heap.getHeapSize() && heap.getA().get(l) > heap.getA().get(i)) {
            largest = l;
        }
        if (r < heap.getHeapSize() && heap.getA().get(r) > heap.getA().get(largest)) {
            largest = r;
        }
        if (largest != i) {
            int temp = heap.getA().get(i);
            heap.getA().set(i, heap.getA().get(largest));
            heap.getA().set(largest, temp);
        } else
            return;
        MaxHeapify(heap, largest);
    }

    /**
     * 构建最大堆
     * @param heap 堆
     */
    public void BuildMaxHeap(Heap heap) {
        int heapsize = heap.getHeapSize();
        for (int i = (heapsize - 1) / 2; i>= 0; i--) {
            MaxHeapify(heap, i);
        }
    }

    /**
     * 堆排序算法
     * @param heap 堆
     */
    public void HeapSort_(Heap heap) {
        BuildMaxHeap(heap);
        int length = heap.getA().size(), heapSize = heap.getHeapSize();
        for (int i = length - 1; i > 0; i--) {
            int temp = heap.getA().get(i);
            heap.getA().set(i, heap.getA().get(0));
            heap.getA().set(0,temp);
            heap.setHeapSize(--heapSize);
            MaxHeapify(heap, 0);
        }
    }

//    public void toHeapSort(ArrayList<Integer> list){
//        // 把数组中的左半边的值进行排序
//        for(int i = list.size()/2;i>0;i--){
//            HeapAdjust(list,i,list.size());
//        }
//
//        for (int i = list.size(); i >1 ; i--) {
//            //每个最大的根节点于最后一个进行替换
//            swap(list,1,list.size());
//            // 并重新调整为大顶堆
//            HeapAdjust(list,1,i-1);
//        }
//
//    }
//
//    private void swap(ArrayList<Integer> arr,int i,int j){
//        int temp = arr.get(i);
//        arr.get(i) = arr.get(j);
//        arr.get(j) = temp;
//    }
//
//
//    private void HeapAdjust(ArrayList<Integer> list, int i, int length) {
//        int temp = list.get(i);
//
//        //按照关键字较大的顺序进行筛选
//        for (int j = 2*i ; j <= length; j*=2) {
//            //j为关键字中较大的记录的下标
//            if (j < length && list[j] < list[j+1])
//                 ++j;
//
//             if (temp >= list[j]){
//                 break;
//             }
//
//             list[i] = list[j];
//             i = j;
//        }
//        list[i] = temp;
//    }



}
