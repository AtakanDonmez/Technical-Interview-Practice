package Ch03_Stacks_and_Queues;

import java.util.Stack;

public class Q02_StackMin extends Stack<Integer>{
    Stack<Integer> s2;

    public Q02_StackMin() {
        s2 = new Stack<Integer>();
    }

    public void push(int value){
        if (value <= min()) {
            s2.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == min()) {
            s2.pop();
        }
        return value;
    }

    public int min() {
        if (s2.isEmpty()) {
            return Integer.MAX_VALUE;
        } else {
            return s2.peek();
        }
    }

    public static void main(String[] args) {
        Q02_StackMin stack = new Q02_StackMin();
        int[] array = {2, 1, 3, 1};
        for (int value : array) {
            stack.push(value);
            System.out.print(value + ", ");
        }
        System.out.println('\n');
        for (int i = 0; i < array.length; i++) {
            System.out.println("Popped " + stack.pop().intValue());
            System.out.println("New min is " + stack.min());
        }
    }
}
