package tdd.implementation;

import tdd.MinMaxStack;

import java.util.Stack;

public final class MinMaxStackImpl implements MinMaxStack {

    private final Stack<Integer> stack = new Stack<>();
    private final Stack<Integer> min = new Stack<>();
    private final Stack<Integer> max = new Stack<>();

    @Override
    public void push(final int value) {
        this.stack.push(value);

        if (this.min.isEmpty() || value <= this.min.peek()) {
            this.min.push(value);
        } else {
            this.min.push(min.peek());
        }

        if (this.max.isEmpty() || value >= this.max.peek()) {
            this.max.push(value);
        } else {
            this.max.push(max.peek());
        }
    }

    @Override
    public int pop() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        this.min.pop();
        this.max.pop();
        return this.stack.pop();
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
        if (this.min.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.min.peek();
    }

    @Override
    public int getMax() {
        if (this.max.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.max.peek();
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
