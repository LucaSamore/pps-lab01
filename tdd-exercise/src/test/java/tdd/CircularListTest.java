package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementation.CircularQueueImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
final class CircularListTest {

    private static final int CAPACITY = 3;

    private CircularQueue queue;

    @BeforeEach
    void beforeEach() {
        this.queue = new CircularQueueImpl(CAPACITY);
    }

    @Test
    void testCreateNewQueue() {
        assertAll(
            () -> assertTrue(this.queue.isEmpty()),
            () -> assertEquals(0, queue.size()),
            () -> assertEquals(CAPACITY, queue.getCapacity())
        );
    }

    @Test
    void testCreateQueueWithInvalidCapacity() {
        assertThrows(IllegalArgumentException.class, () -> new CircularQueueImpl(-12));
    }

    @Test
    void testEnqueue() {
        this.queue.enqueue(1);
        assertAll(
            () -> assertFalse(this.queue.isEmpty()),
            () -> assertEquals(1, this.queue.size())
        );
    }

    @Test
    void testDequeue() {
        this.queue.enqueue(1);
        this.queue.dequeue();
        assertAll(
            () -> assertTrue(this.queue.isEmpty()),
            () -> assertEquals(0, queue.size())
        );
    }

    @Test
    void testDequeueAnEmptyQueue() {
        assertThrows(IllegalStateException.class, () -> this.queue.dequeue());
    }

    @Test
    void testEnqueueWhenQueueIsFull() {
        List.of(1, 2, 3).forEach(this.queue::enqueue);
        this.queue.enqueue(4);
        assertAll(
            () -> assertEquals(2, this.queue.dequeue()),
            () -> assertEquals(3, this.queue.dequeue()),
            () -> assertEquals(4, this.queue.dequeue()),
            () -> assertTrue(this.queue.isEmpty())
        );
    }

}
