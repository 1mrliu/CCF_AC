package JianZhiOffer;

/**
 * 数字在排序数组中出现的次数
 * 统计一个数字在排序数组中出现的次数。
 *
 * 解答：
 * 因为是有序的数组，因此考虑二分法进行查找  通过第一个出现和最后一次出现的坐标位置进行求解个数
 */
public class _37_GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        int length = array.length;
        if (length == 0) return 0;
        int firstK = getFirstK(array,k,0,length-1);
        int lastK = getLastK(array,k,0,length-1);
        if (firstK != -1 && lastK != -1)
            return lastK-firstK+1;

        return 0;
    }

    private int getFirstK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start+end)/2;
        // 非递归的写法
        while(start <= end){
            if (array[mid] > k){
                end = mid-1;
            }else if (array[mid] < k){
                start = mid+1;
            }else if(mid-1 >= 0 && array[mid-1] == k){
                end = mid-1;
            }else {
                return mid;
            }
            mid = (start+end)/2;
        }
        return -1;

    }

    public int getLastK(int[] array, int k, int start, int end) {
        int length = array.length;
        int mid = (start + end) >> 1;
        // 非递归的写法
        while(start <= end){
            if(array[mid] > k){
                end = mid-1;
            }else if(array[mid] < k){
                start = mid+1;
            }else if(mid+1 < length && array[mid+1] == k){
                start = mid+1;
            }else{
                return mid;
            }
            mid = (start + end) >> 1;
        }
        return -1;




    }
}
