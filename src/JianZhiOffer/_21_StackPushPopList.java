package JianZhiOffer;

import java.util.Stack;

/**
 * 栈的压入弹出序列
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。
 * 例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class _21_StackPushPopList {

    public boolean IsPopOrder(int [] pushA,int [] popA) {
        //构造辅助栈进行操作，将压入序列压入栈中，并和弹出序列对比，最后栈为空的话，就结束
      if (pushA.length == 0 || popA.length == 0) return false;

      Stack<Integer> stack =  new Stack<>();

      // 和弹出序列中的进行比较，相等的话就弹出值，不相等的话就在弹出序列中移位进行操作
      int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while(!stack.isEmpty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex+=1;
            }
        }
        return stack.isEmpty();
    }
}
