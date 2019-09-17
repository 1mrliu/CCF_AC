package DataStructure;

/**
 * 求两个数的最大公约数
 * 辗转相除法
 */
public class _5_ {
    public static int getGreatestCommonDivision(int a, int b){
        int big = a >b ? a:b;
        int small = a<b ? a:b;
        if (big%small == 0) return small;
        return getGreatestCommonDivision(big%small, small);
    }


    public static void main(String[] args){
        System.out.print(getGreatestCommonDivision(25,5));
    }
}
