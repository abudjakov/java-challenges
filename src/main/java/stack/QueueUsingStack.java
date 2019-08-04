package stack;

import java.util.Stack;

/*
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
* */
public class QueueUsingStack {

    Stack<Integer> a = new Stack<>();
    Stack<Integer> b = new Stack<>();

    public QueueUsingStack() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        a.push(x);
    }

    private void transfer() {
        if (b.empty())  {
            while (!a.empty()) {
                b.push(a.pop());
            }
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        transfer();

        return b.pop();
    }

    /** Get the front element. */
    public int peek() {
        transfer();

        return b.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return a.empty() && b.empty();
    }

    public static void main(String[] args) {
        QueueUsingStack queue = new QueueUsingStack();
        queue.push(10);
        queue.push(20);
        System.out.println(queue.pop()); //20
        System.out.println(queue.peek()); //10
        System.out.println(queue.empty()); //false
        System.out.println(queue.pop()); //10
        System.out.println(queue.empty()); //true
    }

}
