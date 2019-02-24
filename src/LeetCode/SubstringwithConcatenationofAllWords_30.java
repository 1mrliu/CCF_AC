package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liudong on 2019/2/17.
 * You are given a string, s, and a list of words, words, that are all of the same length.
 * Find all starting indices of substring(s) in s that is a concatenation of each word in
 * words exactly once and without any intervening characters.
 * Example 1:
 * Input:
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * Output: [0,9]
 * Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
 * The output order does not matter, returning [9,0] is fine too.
 * 使用HashMap来进行处理， 省去了words中的单词的排列组合问题，直接判断出现的次数就可以解决
 */
public class SubstringwithConcatenationofAllWords_30 {
    public List<Integer> findSubstring(String s, String[] words) {
       final Map<String, Integer> counts = new HashMap<>();
        for (final String word : words) {
             counts.put(word, counts.getOrDefault(word,0)+1);
             //Map的新方法getOrDefault(Object,V)允许调用者在代码语句中规定获得在map中符合提供的键的值，
             // 否则在没有找到提供的键的匹配项的时候返回一个“默认值”。
        }
        final List<Integer> indexes = new ArrayList<>();
        final int n = s.length();
        final int num = words.length;
        if (num == 0){
            return indexes;
        }
        final int len = words[0].length();
        for (int i = 0; i < n - num * len + 1; i++) {
            final Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            while(j < num){
                final String word = s.substring(i+j*len, i+ (j+1)*len);
                if (counts.containsKey(word)) {
                    seen.put(word,seen.getOrDefault(word, 0) + 1);
                    if (seen.get(word) > counts.getOrDefault(word, 0)) {
                        break;
                    }
                }else {
                    break;
                }
                j++;
            }
            if (j == num) {
                indexes.add(i);
            }
        }
    return indexes;
    }

    public static void main(String[] args){
     String s = "barfoothefoobarman";
     String[] words = {"foo","bar"};
     SubstringwithConcatenationofAllWords_30 ss = new SubstringwithConcatenationofAllWords_30();
     List<Integer> sss = ss.findSubstring(s,words);
     System.out.print(sss);
    }
}
