package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementation.SmartDoorLockImpl;

import static org.junit.jupiter.api.Assertions.*;

public final class SmartDoorLockTest {

    private static final int DEFAULT_PIN = 1234;
    private static final int MAX_ATTEMPTS = 10;

    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach() {
        this.smartDoorLock = new SmartDoorLockImpl(DEFAULT_PIN, MAX_ATTEMPTS);
    }

    @Test
    void testLockIsInitiallyUnlocked() {
        assertFalse(smartDoorLock.isLocked());
    }

}
