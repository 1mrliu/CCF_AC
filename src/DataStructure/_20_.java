package DataStructure;

import java.util.Stack;

/**
 * getMin()
 * 设计一个具有获取最小值的栈
 * pop() push() getMin的操作都是O(1)的时间
 */
public class _20_ {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    // 构造对象
    public _20_(){
        this.stackData = new Stack <>();
        this.stackMin  = new Stack <>();
    }

    // 插入栈
    public void push(int newNum){
        if (this.stackMin.isEmpty()){
            this.stackMin.push(newNum);
        }else if (newNum <= this.getmin()){
            this.stackMin.push(newNum);
        }
        this.stackData.push(newNum);
    }

    // 弹出栈
    public int pop(){
        if (this.stackData.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        int value = this.stackData.pop();
        if (value == this.getmin()){
            this.stackMin.pop();
        }
        return value;
    }

    //查询当前栈的最小值
    public int getmin(){
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("You stack is empty");
        }
        return this.stackMin.peek();
    }





}
