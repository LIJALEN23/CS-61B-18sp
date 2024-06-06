package demo1;

import java.util.Stack;
public class QueueUsingStack <T>{
    private Stack<T> inputStack;
    private Stack<T> outputStack;

    public QueueUsingStack() {
        inputStack = new Stack<>();
        outputStack = new Stack<>();
    }

    public void push(T item) {
        inputStack.push(item);
    }

    //将inputStack中的元素弹出并压入outputStack中，弹出一个outputStack中的元素
    public T poll() {
        if (outputStack.isEmpty()) {
            while (!inputStack.isEmpty()) {
                outputStack.push(inputStack.pop());
            }
        }
        return outputStack.isEmpty() ? null : outputStack.pop();
    }
}
