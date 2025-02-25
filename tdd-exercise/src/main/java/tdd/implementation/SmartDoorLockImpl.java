package tdd.implementation;

import tdd.SmartDoorLock;

public final class SmartDoorLockImpl implements SmartDoorLock {

    private record Pin(int pin) { }

    private enum LockState {
        LOCKED, UNLOCKED, BLOCKED
    }

    private Pin pin;
    private LockState lockState;
    private int failedAttempts = 0;
    private final int maxAttempts;

    public SmartDoorLockImpl(final int maxAttempts) {
        this.lockState = LockState.UNLOCKED;
        this.maxAttempts = maxAttempts;
    }

    @Override
    public void setPin(final int pin) {
        this.pin = new Pin(pin);
    }

    @Override
    public void unlock(final int pin) {
        // ! TODO: check if door is locked
        if (pinIsIncorrect(pin)) {
            handleFailedAttempt();
            return;
        }
        this.lockState = LockState.UNLOCKED;
    }

    @Override
    public void lock() throws IllegalStateException {
        if (pinIsNotSet()) {
            throw new IllegalStateException("PIN is not set");
        }
        lockState = LockState.LOCKED;
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
        return this.failedAttempts;
    }

    @Override
    public void reset() {

    }

    private boolean pinIsNotSet() {
        return this.pin == null;
    }

    private boolean pinIsIncorrect(final int pin) {
        final var givenPin = new Pin(pin);
        return !this.pin.equals(givenPin);
    }

    private void handleFailedAttempt() {
        this.failedAttempts++;
        if (this.failedAttempts >= this.maxAttempts) {
            this.lockState = LockState.BLOCKED;
        }
    }
}
