package LeetCode;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liudong on 2018/11/17.
 * You have an array of logs.  Each log is a space delimited string of words.

 For each log, the first word in each log is an alphanumeric identifier.  Then, either:

 Each word after the identifier will consist only of lowercase letters, or;
 Each word after the identifier will consist only of digits.
 We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.

 Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier,
 with the identifier used in case of ties.  The digit-logs should be put in their original order.

 Return the final order of the logs.



 Example 1:

 Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]


 Note:

 0 <= logs.length <= 100
 3 <= logs[i].length <= 100
 logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */
public class _937_ReorderLogFiles {
    public String[] reorderLogFiles(String[] logs) {
        //日志分组 字母日志和数字日志
        List<String> letterLogs = new LinkedList<>();
        List<String>  digitLogs = new LinkedList<>();

        //日志分组
        for(String log:logs){
            char c = log.charAt(log.indexOf(" ")+1);
            // ASCII 48-->0  57-->9
            if(c >= 48 && c <= 57){
                digitLogs.add(log);
            }else{
                letterLogs.add(log);
            }
        }
        //字母日志排序
        letterLogs.sort(new Comparator<String>(){

            @Override
            public int compare(String o1, String o2){
                String log1 =  o1.substring(o1.indexOf(" "));
                String log2 =  o2.substring(o2.indexOf(" "));
                return log1.compareTo(log2);
            }
        });
        //聚合日志
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(logs);
    }
}

