package JianZhiOffer;

/**
 * 圆圈中最后剩下的数
 * 0，1....n-1这n个数子排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求这个圆圈里剩下的最后一个数字
 * 请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 */
public class _46_CircleShengXiaNumber {
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1|| m<1) return -1;
        int last = 0;
        for (int i = 2; i <=n ; i++) {
            last = (last+m)%i;
        }

        return last;

    }
}
