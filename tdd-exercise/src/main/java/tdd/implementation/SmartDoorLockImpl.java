package tdd.implementation;

import tdd.SmartDoorLock;

public final class SmartDoorLockImpl implements SmartDoorLock {

    private enum LockState {
        LOCKED, UNLOCKED, BLOCKED
    }

    private int pin;
    private LockState lockState;
    private int failedAttempts = 0;
    private final int maxAttempts;

    public SmartDoorLockImpl(final int pin, final int maxAttempts) {
        this.pin = pin;
        this.lockState = LockState.UNLOCKED;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void setPin(int pin) {

    }

    @Override
    public void unlock(int pin) {

    }

    @Override
    public void lock() {

    }

    @Override
    public boolean isLocked() {
        return this.lockState == LockState.LOCKED;
    }

    @Override
    public boolean isBlocked() {
        return false;
    }

    @Override
    public int getMaxAttempts() {
        return 0;
    }

    @Override
    public int getFailedAttempts() {
        return 0;
    }

    @Override
    public void reset() {

    }
}
