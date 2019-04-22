package JianZhiOffer;

/**
 * Created by liudong on 2019/1/29.
 *替换空格
 *
 *  请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 *  例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class _2_TiHuanKongGe {
    public String replaceSpace(StringBuffer str) {
        // 自带函数的方法一
        // return str.toString().replaceAll(" ","%20");
        // 方法二
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' '){
                count++;
            }
        }
        int indexold = str.length() -1;
        int newlength = str.length() + count*2;
        int indexnew = newlength - 1;
        str.setLength(newlength);
        for (;indexold >= 0 && indexold < newlength ; --indexold) {
            if (str.charAt(indexold) == ' ') {
                str.setCharAt(indexnew--,'0');
                str.setCharAt(indexnew--,'2');
                str.setCharAt(indexnew--,'%');
            }else{
                str.setCharAt(indexnew--, str.charAt(indexold));
            }
        }
        return str.toString();
    }

}
