package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementation.MinMaxStackImpl;
import tdd.implementation.SmartDoorLockImpl;

import static org.junit.jupiter.api.Assertions.*;

final class MinMaxStackImplTest {

    private MinMaxStack stack;

    @BeforeEach
    void beforeEach() {
        this.stack = new MinMaxStackImpl();
    }

    @Test
    void testInitialState() {
        assertTrue(stack.isEmpty());
    }


}