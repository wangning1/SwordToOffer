import java.util.Stack;

/**
 * @Description:
 * @CreateDate: 2020/4/22 14:00
 * @Author: wangning
 */
public class CQueue {

    Stack<Integer> inStack;
    Stack<Integer> outStack;

    public CQueue() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void appendTail(int value) {
        inStack.add(value);
    }

    public int deleteHead() {
        if (!outStack.empty()) {
            return outStack.pop();
        } else {
            if (!inStack.empty()) {
                while (!inStack.empty()) {
                    outStack.add(inStack.pop());
                }
                return outStack.pop();
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        System.out.println(cQueue.deleteHead());
        cQueue.appendTail(3);
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
        System.out.println(cQueue.deleteHead());
    }
}
