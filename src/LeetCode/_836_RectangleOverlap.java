package LeetCode;

/**
 * Created by liudong on 2018/11/21.
 * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1) are the coordinates of its bottom-left corner, and (x2, y2) are the coordinates of its top-right corner.

 Two rectangles overlap if the area of their intersection is positive.  To be clear, two rectangles that only touch at the corner or edges do not overlap.

 Given two (axis-aligned) rectangles, return whether they overlap.

 Example 1:

 Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 Output: true
 Example 2:

 Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 Output: false
 Notes:

 Both rectangles rec1 and rec2 are lists of 4 integers.
 All coordinates in rectangles will be between -10^9 and 10^9.

 */
public class _836_RectangleOverlap {
    private boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        boolean result = false;
        if (rec1[0] < rec2[2] && rec2[0] < rec1[2] && rec1[1] < rec2[3] && rec2[1] < rec1[3])
            result = true;
    return result;
    }

    public static void main(String[] args){
       int[] rec1 = {5,15,8,18};
       int[] rec2 = {0,3,7,9};
       _836_RectangleOverlap rr = new _836_RectangleOverlap();
       boolean result = rr.isRectangleOverlap(rec1,rec2);
       System.out.print(result);

    }
}
