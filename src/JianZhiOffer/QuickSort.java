package JianZhiOffer;

import java.util.Arrays;

/**
 * 快速排序  是用最小的值作为基准
 */
public class QuickSort {

    public void sort(int[] arr,int low,int high){
        if (low < high) {
            // 第一次找到的点进行排序
            int pivot = Partition(arr, low, high);
            // 对左边的数据进行排序
            sort(arr, low, pivot - 1);
            // 对右边的数据进行排序
            sort(arr, pivot + 1, high);
        }
    }

    private void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int Partition(int[] arr,int low, int high){
        //使用第一个子节点
        int pivot = arr[low];

        while (low < high){
            while (low < high && arr[high] >= pivot){
                high--;
            }
            swap(arr,low,high);
            while (low < high && arr[low] <= pivot){
                low++;
            }
            swap(arr,low,high);
        }
        //  当low == high 的时候   返回枢轴所在的位置
        return high;// low or high
    }

    public static void main(String[] args){
        int [] array = {8,7,6,5,4,3,2,0};
        QuickSort ss = new QuickSort();
        ss.sort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
