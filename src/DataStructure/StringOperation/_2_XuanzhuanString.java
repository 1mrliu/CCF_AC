package DataStructure.StringOperation;

/**
 * 判断两个字符串是否互为旋转词
 * 把一个字符串前边任意的部分挪到后面形成的字符串叫做str的旋转词
 */

public class _2_XuanzhuanString {
    public boolean isRoattion(String a, String b){
        if (a==null || b == null || a.length() != b.length())
            return false;

        String b2 = b + b;
        return getIndexOf(b2,a) != -1;
    }

    public int getIndexOf(String s, String m){
        if (s == null || m == null || s.length() < m.length() || m.length()<1)
            return -1;
        char[] ss = s.toCharArray();
        char[] ms = m.toCharArray();
        int si = 0;
        int mi = 0;
        int[] next = getNextArray(ms);
        while(si < ss.length && mi < ms.length){
            if (ss[si] == ms[mi]){
                si++;
                mi++;
            }else if (next[mi] == -1){
                si++;
            }else {
                mi = next[mi];
            }
        }
        return mi == ms.length ? si-mi:-1;
    }

    public int[] getNextArray(char[] ms){
        if (ms.length == 1){
            return new int[]{-1};
        }
        int[] next = new int[ms.length];
        next[0] = -1;
        next[1] = 0;
        int pos = 2;
        int cn = 0;
        while (pos < next.length){
            if (ms[pos-1] == ms[cn]){
                next[pos++] = ++cn;
            }else if (cn > 0){
                cn = next[cn];
            }else {
                next[pos++] = 0;
            }
        }
        return next;
    }

    //test
    public static void main(String[] args){
        _2_XuanzhuanString res = new _2_XuanzhuanString();
        System.out.print(res.isRoattion("1ab2","ab12"));
    }


}
