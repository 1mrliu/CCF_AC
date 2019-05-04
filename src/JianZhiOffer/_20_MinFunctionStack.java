package JianZhiOffer;
import java.util.Stack;

/**
 * 包含min函数的栈
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 * 知识点 集合的操作（Stack queue map） 主要使用 foreach 进行
 */
public class _20_MinFunctionStack {

    Stack<Integer> stack = new Stack<Integer>();
    public void push(int node) {
        stack.push(node);
    }

    public void pop() {
        stack.pop();
        
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        int min = stack.peek();
        for(Integer i:stack){
            if(min > i)
                min = i;
        }
        return min;
    }
}
