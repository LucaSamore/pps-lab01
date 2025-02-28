package tdd.implementation;

import tdd.CircularQueue;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public final class CircularQueueImpl implements CircularQueue {

    private final Queue<Integer> queue;
    private final int capacity;

    public CircularQueueImpl(final int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.queue = new ArrayDeque<>(capacity);
        this.capacity = capacity;
    }

    @Override
    public void enqueue(final int value) {
        this.queue.add(value);
    }

    @Override
    public int dequeue() {
        return 0;
    }

    @Override
    public int peek() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
}
