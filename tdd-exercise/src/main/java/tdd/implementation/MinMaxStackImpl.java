package tdd.implementation;

import tdd.MinMaxStack;

import java.util.ArrayList;
import java.util.List;

public final class MinMaxStackImpl implements MinMaxStack {

    private final List<Integer> stack = new ArrayList<>();

    @Override
    public void push(final int value) {
        this.stack.add(value);
    }

    @Override
    public int pop() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.stack.remove(this.stack.size() - 1);
    }

    @Override
    public int peek() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return this.stack.get(this.stack.size() - 1);
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
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
