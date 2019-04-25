package JianZhiOffer;

/**
 * 矩形覆盖
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class _10_JuXingFuGai {
    // 8个2*1的矩形放置  两种放置方式  横着放f(6)和竖着放f(7)
    // f(8) = f(6) + f(7)

    public int RectCover(int target) {
        if (target <= 1) {
            return target;
        }
        if (target == 2){
            return  2;
        }else if (target == 3){
            return 3;
        }else {
            return  RectCover(target -2) + RectCover(target-1);
        }

    }
}
