package JianZhiOffer;

/**
 * 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，
 * 请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单
 */
public class _43_LeftRotateString {
    public String LeftRotateString(String str,int n) {
        // 通过n的位置将字符串分为两部分，先将两部分各自进行反转，然后再对整个字符串进行反转
        char[] chars  = str.toCharArray();
        if (chars.length<n) return "";
        reverse(0,n-1,chars);
        reverse(n,chars.length-1,chars);
        reverse(0,chars.length-1,chars);
        return String.valueOf(chars);

    }


    public void reverse(int start,int end,char[] chars){
        while (start < end){
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
