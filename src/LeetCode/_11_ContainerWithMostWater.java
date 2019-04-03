package LeetCode;

/**
 * Created by liudong on 2019/1/26.
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container and n is at least 2.
 Input: [1,8,6,2,5,4,8,3,7]
 Output: 49
 */
public class _11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int result =0;
        for (int i = 0; i < height.length-1; i++) {
            for (int j = i+1; j < height.length; j++) {
                result = Math.max(result,(j - i)* Math.min(height[i],height[j]));
            }
        }
        return  result;
    }
    public static void main(String[] args){
        int[]  a = {1,8,6,2,5,4,8,3,7};
        _11_ContainerWithMostWater cc = new _11_ContainerWithMostWater();
        System.out.print(cc.maxArea(a));

    }
}
