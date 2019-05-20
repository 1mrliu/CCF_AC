package JianZhiOffer;

/**
 *正则表达式匹配
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class _52_ZhengZeMatch {
    public boolean match(char[] str, char[] pattern) {

        //两个都是空
        if (str == null || pattern == null) return false;

        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str,strIndex,pattern,patternIndex);
    }

    /**
     * 当模式中的第二个字符不是“*”时：
     * 1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
     * 2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
     *
     * 而当模式中的第二个字符是“*”时：
     * 如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。
     * 如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
     * 1、模式后移2字符，相当于x*被忽略；
     * 2、字符串后移1字符，模式后移2字符；
     * 3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
     *
     * 这里需要注意的是：Java里，要时刻检验数组是否越界。
     */

    private boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex) {

        if(patternIndex == pattern.length)//pattern遍历完了
            return str.length == strIndex;//如果str也完了，返回true，不然false
        //注意数组越界问题，以下情况都保证数组不越界
        if(patternIndex < pattern.length - 1 && pattern[patternIndex + 1] == '*') {//下一个是*
            if(str.length != strIndex && //当前匹配
                    (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.')) //匹配
                return matchCore(str,strIndex,pattern,patternIndex + 2) || matchCore(str,strIndex + 1,pattern,patternIndex);
            else//当前不匹配
                return matchCore(str,strIndex,pattern,patternIndex + 2);
        }
        //下一个不是“*”，当前匹配
        if(str.length != strIndex && (str[strIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'))
            return matchCore(str,strIndex + 1,pattern,patternIndex + 1);
        return false;
    }


}
