import java.util.Stack;

/**
 * @authour winner
 * @Date 2020/4/28 22:55
 */
public class MinStack {

    private Stack<Integer> stackMin;
    private Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stackMin = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (stackMin.empty()) {
            stackMin.push(x);
        } else {
            if (stackMin.peek() > x) {
                stackMin.push(x);
            } else {
                stackMin.push(stackMin.peek());
            }
        }
    }

    public void pop() {
        stack.pop();
        stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.min());

    }
}
