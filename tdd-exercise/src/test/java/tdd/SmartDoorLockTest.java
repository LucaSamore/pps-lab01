package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementation.SmartDoorLockImpl;

import static org.junit.jupiter.api.Assertions.*;

public final class SmartDoorLockTest {

    private static final int MAX_ATTEMPTS = 10;

    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach() {
        this.smartDoorLock = new SmartDoorLockImpl(MAX_ATTEMPTS);
    }

    @Test
    void testDoorIsInitiallyUnlocked() {
        assertFalse(this.smartDoorLock.isLocked());
    }

    @Test
    void testLockDoorWithUnsetPin() {
        assertThrows(IllegalStateException.class, () -> this.smartDoorLock.lock());
    }

    @Test
    void testLockDoor() {
        this.smartDoorLock.setPin(1644);
        this.smartDoorLock.lock();
        assertTrue(this.smartDoorLock.isLocked());
    }
}
