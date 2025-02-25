package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tdd.implementation.SmartDoorLockImpl;

import static org.junit.jupiter.api.Assertions.*;

public final class SmartDoorLockTest {

    private static final int PIN = 1644;
    private static final int MAX_ATTEMPTS = 10;

    private SmartDoorLock smartDoorLock;

    @BeforeEach
    void beforeEach() {
        this.smartDoorLock = new SmartDoorLockImpl(MAX_ATTEMPTS);
    }

    @Test
    void testInitialState() {
        assertAll(
            () -> assertFalse(this.smartDoorLock.isLocked()),
            () -> assertEquals(0, this.smartDoorLock.getFailedAttempts())
        );
    }

    @Test
    void testLockDoorWithUnsetPin() {
        assertThrows(IllegalStateException.class, () -> this.smartDoorLock.lock());
    }

    @Test
    void testLockDoor() {
        this.smartDoorLock.setPin(PIN);
        this.smartDoorLock.lock();
        assertTrue(this.smartDoorLock.isLocked());
    }

    @Test
    void testUnlockDoorWithCorrectPin() {
        this.smartDoorLock.setPin(PIN);
        this.smartDoorLock.lock();
        this.smartDoorLock.unlock(PIN);
        assertAll(
            () -> assertFalse(this.smartDoorLock.isLocked()),
            () -> assertEquals(0, this.smartDoorLock.getFailedAttempts())
        );
    }

    @Test
    void testUnlockDoorWithIncorrectPin() {
        this.smartDoorLock.setPin(PIN);
        this.smartDoorLock.lock();
        this.smartDoorLock.unlock(1234);
        assertAll(
            () -> assertTrue(this.smartDoorLock.isLocked()),
            () -> assertEquals(1, this.smartDoorLock.getFailedAttempts())
        );
    }

    @Test
    void testUnlockAlreadyUnlockedDoorWithCorrectPin() {
        this.smartDoorLock.setPin(PIN);
        this.smartDoorLock.unlock(PIN);
        assertAll(
            () -> assertFalse(this.smartDoorLock.isLocked()),
            () -> assertEquals(0, this.smartDoorLock.getFailedAttempts())
        );
    }

    @Test
    void testUnlockAlreadyUnlockedDoorWithIncorrectPin() {
        this.smartDoorLock.setPin(PIN);
        this.smartDoorLock.unlock(1234);
        assertAll(
            () -> assertFalse(this.smartDoorLock.isLocked()),
            () -> assertEquals(0, this.smartDoorLock.getFailedAttempts())
        );
    }

}
