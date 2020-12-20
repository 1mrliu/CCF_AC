package DataStructure.StringOperation;

/**
 * 判断两个字符串是不是变形字符串，如果两个字符串出现的字符种类一样且每种字符出现的次数也一样
 * 就是变形字符串
 */
public class _1_BianxingString {
    public boolean isDeformation(String str1, String str2) {
        if (str1 == null || str2 == null || str1.length() != str2.length()) return false;
        char[] chas1 = str1.toCharArray();
        char[] chas2 = str2.toCharArray();
        int[] map = new int[256];
        for (int i = 0; i < chas1.length; i++) {
            map[chas1[i]]++;
        }
        for (int i = 0; i < chas2.length; i++) {
            // 遍历到的值小于0 就退出
            if (map[chas2[i]]-- == 0) return false;
        }
        return true;
    }
}
