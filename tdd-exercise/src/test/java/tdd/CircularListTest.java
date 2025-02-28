package tdd;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementation.CircularQueueImpl;
import tdd.implementation.MinMaxStackImpl;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
final class CircularListTest {

    private static final int CAPACITY = 10;

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

}
