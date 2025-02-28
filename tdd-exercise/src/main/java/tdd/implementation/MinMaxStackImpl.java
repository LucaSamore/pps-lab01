package tdd.implementation;

import tdd.MinMaxStack;

import java.util.ArrayList;
import java.util.List;

public final class MinMaxStackImpl implements MinMaxStack {

    private final List<Integer> stack = new ArrayList<>();

    @Override
    public void push(final int value) {

    }

    @Override
    public int pop() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
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
        return 0;
    }
}
