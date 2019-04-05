package LeetCode;

/**
 * Created by liudong on 2019/4/5.
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:

 'A' -> 1
 'B' -> 2
 ...
 'Z' -> 26
 Given a non-empty string containing only digits, determine the total number of ways to decode it.

 Example 1:

 Input: "12"
 Output: 2
 Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 Example 2:

 Input: "226"
 Output: 3
 Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

 */
public class _91_DecodeWays {
    // DP  time  O(N)
    //     space  O(1)
    public int numDecodings(String s) {
       char[] array =  s.toCharArray();
       if (array.length == 0 || array[0] == '0') return 0;
       if (array.length == 1) return 1;

       int n = array.length;
       // DP 数组
       int w1 = 1;
       int w2 = 1;

        for (int i = 1; i < n; i++) {
            int w = 0;
            // 不合法
            if (!isValid(array[i]) && !isValid(array[i-1],array[i])) return 0;
            //
            if (isValid(array[i])) w = w1;
            if (isValid(array[i-1],array[i])) w += w2;
            w2 = w1;
            w1 = w;
        }
        return w1;
    }

    public boolean isValid(char c){
        return c != '0';
    }

    public boolean isValid(char c1, char c2){
       int num = (c1 - '0')*10 + (c2-'0');
       return num >= 10 && num <= 26;
    }
}
