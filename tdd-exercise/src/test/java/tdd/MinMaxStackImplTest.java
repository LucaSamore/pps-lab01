package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementation.MinMaxStackImpl;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

final class MinMaxStackImplTest {

    private static final int VALUE = 10;

    private MinMaxStack stack;

    @BeforeEach
    void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    void testInitialState() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void testPushElement() {
        this.stack.push(VALUE);
        assertEquals(1, this.stack.size());
    }

    @Test
    void testPopElement() {
        this.stack.push(VALUE);
        assertAll(
            () -> assertEquals(VALUE, this.stack.pop()),
            () -> assertTrue(this.stack.isEmpty())
        );
    }

    @Test
    void testPopEmptyStack() {
        assertThrows(IllegalStateException.class, () -> this.stack.pop());
    }

    @Test
    void testPopFollowsLIFOPolicy() {
        this.stack.push(1);
        this.stack.push(2);
        this.stack.push(3);
        assertAll(
            () -> assertEquals(3, this.stack.pop()),
            () -> assertEquals(2, this.stack.pop()),
            () -> assertEquals(1, this.stack.pop())
        );
    }

    @Test
    void testPeekElement() {
        this.stack.push(VALUE);
        assertAll(
            () -> assertEquals(VALUE, this.stack.peek()),
            () -> assertFalse(this.stack.isEmpty())
        );
    }

    @Test
    void testPeekEmptyStack() {
        assertThrows(IllegalStateException.class, () -> this.stack.peek());
    }

    @Test
    void testGetMin() {
        List.of(1, 2, 3).forEach(this.stack::push);
        assertEquals(1, this.stack.getMin());
    }

    @Test
    void testGetMinWithEmptyStack() {
        assertThrows(IllegalStateException.class, () -> this.stack.getMin());
    }

    @Test
    void testGetMax() {
        List.of(1, 2, 3).forEach(this.stack::push);
        assertEquals(3, this.stack.getMax());
    }

    @Test
    void testGetMaxWithEmptyStack() {
        assertThrows(IllegalStateException.class, () -> this.stack.getMax());
    }

    @Test
    void testGetMinWithDifferentStackStatus() {
        List.of(3, 2, 1).forEach(this.stack::push);
        assertAll(
            () -> assertEquals(1, this.stack.getMin()),
            () -> assertEquals(1, this.stack.pop()),
            () -> assertEquals(2, this.stack.getMin())
        );
    }

    @Test
    void testGetMaxWithDifferentStackStatus() {
        List.of(1, 2, 3).forEach(this.stack::push);
        assertAll(
            () -> assertEquals(3, this.stack.getMax()),
            () -> assertEquals(3, this.stack.pop()),
            () -> assertEquals(2, this.stack.getMax())
        );
    }

}