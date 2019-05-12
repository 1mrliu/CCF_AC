package JianZhiOffer;

/**
 * 翻转单词顺序列
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。
 * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 */
public class _44_ReverseSentence {
    //先翻转整体的部分，然后再翻转空格分开的单词
    public String ReverseSentence(String str) {
        //str.split(" ");
        char[] chars = str.toCharArray();
        // 翻转整体
        reverse(0,chars.length-1,chars);
        // 翻转空格分开的单词
        int start = 0,end = 0;
        int i = 0;
        while (i < chars.length) {
            // 注意判断条件
            while(i < chars.length && chars[i] == ' ')
                i++;
            start = end = i;
            while(i < chars.length &&chars[i] != ' '){
                i++;
                end++;
            }
            reverse(start,end-1,chars);
        }
        return String.valueOf(chars);

    }


    public void reverse(int start,int end,char[] chars){
        char temp;
        while (start < end){
            temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }

}
