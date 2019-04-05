package LeetCode;

import java.util.*;

/**
 * Created by liudong on 2019/4/5.
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation
 * sequence from beginWord to endWord, such that:

 Only one letter can be changed at a time.
 Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 Note:

 Return 0 if there is no such transformation sequence.
 All words have the same length.
 All words contain only lowercase alphabetic characters.
 You may assume no duplicates in the word list.
 You may assume beginWord and endWord are non-empty and are not the same.
 Example 1:

 Input:
 beginWord = "hit",
 endWord = "cog",
 wordList = ["hot","dot","dog","lot","log","cog"]

 Output: 5

 Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.
 Example 2:

 Input:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]

 Output: 0

 Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 使用双向 BFS进行处理
 */
public class _127_WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>();
        for (String word: wordList)
            dict.add(word);
        // Collections.addAll(wordList);

        if (!dict.contains(endWord))
            return 0;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        // 实现转化的String的长度要相同
        int l = beginWord.length();
        int steps = 0;

        while(!q1.isEmpty() && !q2.isEmpty()){
            ++steps;
            // 照顾那个最小的序列 当一个前进一步，另外一个也前进一步
            if (q1.size() > q2.size()){
                Set<String> tmp = q1;
                q1 = q2;
                q2 = tmp;
            }

            Set<String> q = new HashSet<>();

            for (String w: q1){
                // q1中的String转化为数组
                char[] chs = w.toCharArray();

                for (int i = 0; i < l; i++) {
                    char ch = chs[i];
                    // 每一位都要测试a-z的数值
                    for (char c = 'a'; c < 'z'; c++) {
                        chs[i] = c;
                        String t = new String(chs);
                        if (q2.contains(t))
                            return steps+1;
                        if (!dict.contains(t))
                            continue;

                        dict.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }
            q1 = q;
        }
        return 0;
    }

    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = new ArrayList<>();

    }

}
