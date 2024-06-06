package demo2;

import java.util.Stack;

public class SortedStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> auxStack;

    public SortedStack() {
        mainStack = new Stack<>();
        auxStack = new Stack<>();
    }

    /**压入一个元素并且实现了排序功能，在auxStack中栈顶元素最小，栈底元素最大。
     * 当需要压入一个元素时，只有这个元素大于auxStack的栈顶元素时，通过mainStack实现将其插入到正确的位置*/

    public void push(int val)  {
        while (!auxStack.isEmpty() && val > auxStack.peek()) {
            mainStack.push(auxStack.pop());
        }

        auxStack.push(val);

        while (!mainStack.isEmpty()) {
            auxStack.push(mainStack.pop());
        }
    }

    //弹出最小元素
    public int pop(int val) {
        if (auxStack.isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return auxStack.pop();
    }
}
