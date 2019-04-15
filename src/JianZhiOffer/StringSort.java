package JianZhiOffer;

/**
 *  对String字符串使用冒泡排序进行排序
 */
public class StringSort {
        public static void main(String[] args) {
            String s = "basckd";

            // 把字符串变成字符数组
            char[] chs = s.toCharArray();

            // 对字符数组进行排序
            bubbleSort(chs);

            // 把排序后的字符数组转换成字符串
            //方法1 构造方法
            //String result = new String(chs);
            //System.out.println(result);
            //方法2 静态方法 valueOf()
            System.out.println(String.valueOf(chs));
        }

        public static void bubbleSort(char[] chs) {
            for (int x = 0; x < chs.length - 1; x++) {
                for (int y = 0; y < chs.length - 1 - x; y++) {
                    if (chs[y] > chs[y + 1]) {
                        char ch = chs[y];
                        chs[y] = chs[y + 1];
                        chs[y + 1] = ch;
                    }
                }
            }
        }
    }
