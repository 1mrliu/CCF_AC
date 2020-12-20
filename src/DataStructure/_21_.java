package DataStructure;

import java.util.Stack;

/**
 * 使用两个栈实现队列操作
 */
public class _21_ {
    public Stack<Integer> stackPush;
    public Stack<Integer> stackPop;

    public _21_(){
        stackPop = new Stack <>();
        stackPush = new Stack <>();
    }

    // push 栈向pop栈压入数据
    private void pushToPop(){
        if (stackPop.empty()){
            while(!stackPush.empty()){
                stackPop.push(stackPush.pop());
            }
        }
    }
    // 添加新的数据
    public void add(int pushInt){
         stackPush.push(pushInt);
         pushToPop();
    }
    //
    public int poll(){
         if (stackPop.empty() && stackPush.empty()){
             throw new RuntimeException("Queue is empty");
         }
         pushToPop();
         return stackPop.pop();
    }

    public int peek(){
        if (stackPop.empty() && stackPush.empty()){
            throw new RuntimeException("Queue is empty");
        }
        pushToPop();
        return stackPop.peek();
    }

}
