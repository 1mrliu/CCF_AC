package DataStructure;

import java.util.Stack;

/**
 * 用一个栈实现另外一个栈的排序
 */
public class _24_ {
    public static void sortStackByStack(Stack<Integer> stack){
        Stack<Integer> help = new Stack <>();
        while (!stack.isEmpty()){
            // pop() 移除这个元素
            int cur = stack.pop();
            // 如果cur大于help中的数据，就将help的元素逐个弹出，直至cur小于或者等于help的栈顶元素
            while (!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());
            }
            help.push(cur);
        }

        // 对help中排好序的数据重新放入stack中
        while(!help.isEmpty()){
            stack.push(help.pop());
        }


    }
}
