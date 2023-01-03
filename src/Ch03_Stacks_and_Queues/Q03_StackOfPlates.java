package Ch03_Stacks_and_Queues;

import java.util.Stack;

public class Q03_StackOfPlates {
    public static class SetOfStacks {

        private final Stack<Stack<Integer>> set;
        private int size;

        public SetOfStacks(){
            set = new Stack<>();
            set.push(new Stack<>());
            size = 0;
        }

        public void push(Integer data){
            int maxSize = 5;
            if (set.peek().size() == maxSize){
                Stack<Integer> newStack = new Stack<>();
                newStack.push(data);
                set.push(newStack);
            } else {
                set.peek().push(data);
            }
            size++;
        }

        public Integer pop(){
            if (size < 1) return null;

            Integer data = set.peek().pop();
            if (set.peek().isEmpty()){
                set.pop();
            }

            size--;
            return data;
        }
    }

    public static void main(String[] args) {
        SetOfStacks set = new SetOfStacks();
        for (int i = 0; i < 34; i++) {
            set.push(i);
        }
        for (int i = 0; i < 35; i++) {
            System.out.println("Popped " + set.pop());
        }
    }
}
