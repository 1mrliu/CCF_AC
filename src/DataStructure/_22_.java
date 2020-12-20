package DataStructure;

import java.util.Stack;

/**
 * 仅使用递归函数逆序输出一个栈
 * 设计了两个递归函数
 *    --- 返回栈底的元素
 *    --- 实现逆序输出
 */
public class _22_ {
    // 递归函数将栈底元素返回并移除
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.empty()){
            return result;
        }else{
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }
    // 递归函数实现逆序一个栈
    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }

    // test
    public static void main(String[] args){
        Stack<Integer> stack = new Stack <Integer>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        reverse(stack);
        for(Integer e:stack){
            System.out.print(e);
        }
    }
}
