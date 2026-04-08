package Day2.Queue;

import java.util.Stack;

class MyQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        while(!stack1.isEmpty()){
            int item = stack1.pop();
            stack2.push(item);
        }
        stack1.push(x);
        while(!stack2.isEmpty()){
            int item = stack2.pop();
            stack1.push(item);
        }
    }

    public int pop() {
        return stack1.pop();
    }

    public int peek() {
        return stack1.peek();
    }

    public boolean empty() {
        return stack1.isEmpty();
    }
}
