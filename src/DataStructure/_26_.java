package DataStructure;

/**
 * 给定一个不包含重复数值的数组，
 * 找到每一个i位置左边和右边距离i位置最近的且比arr[i]小的位置
 * 返回所有位置的信息
 */
public class _26_ {
    // 这个方法的时间复杂度为O(N^2) 时间复杂度较大
    public int[][] rightWay(int[] arr){
        int[][] res = new int[arr.length][2];
        for (int i = 0; i < arr.length; i++) {
            int leftLessIndex = -1;
            int rightLessIndex = -1;
            //左边
            int cur = i-1;
            while (cur >=0){
                if (arr[cur] < arr[i]){
                    leftLessIndex = cur;
                    break;
                }
                cur--;
            }
            // 右边
            cur = i+1;
            while(cur < arr.length){
                if (arr[cur] < arr[i]){
                    rightLessIndex = cur;
                    break;
                }
                cur++;
            }
            res[i][0] = leftLessIndex;
            res[i][1] = rightLessIndex;
        }
        return res;
    }

}
