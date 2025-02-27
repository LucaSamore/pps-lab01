package tdd.implementation;

import tdd.MinMaxStack;

import java.util.Stack;

public final class MinMaxStackImpl implements MinMaxStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> minStack = new Stack<>();
    private final Stack<Integer> maxStack = new Stack<>();

    @Override
    public void push(final int value) {
        stack.push(value);

        if (minStack.isEmpty() || value <= minStack.peek()) {
            minStack.push(value);
        } else {
            minStack.push(minStack.peek());
        }

        if (maxStack.isEmpty() || value >= maxStack.peek()) {
            maxStack.push(value);
        } else {
            maxStack.push(maxStack.peek());
        }
    }

    @Override
    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        minStack.pop();
        maxStack.pop();
        return stack.pop();
    }

    @Override
    public int peek() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.stack.peek();
    }

    @Override
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.peek();
    }

    @Override
    public int getMax() {
        if (maxStack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return maxStack.peek();
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
