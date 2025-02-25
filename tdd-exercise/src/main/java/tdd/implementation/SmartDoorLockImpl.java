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
        if (!isLocked()) {
            return;
        }
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
        return this.lockState == LockState.BLOCKED;
    }

    @Override
    public int getMaxAttempts() {
        return this.maxAttempts;
    }

    @Override
    public int getFailedAttempts() {
        return this.failedAttempts;
    }

    @Override
    public void reset() {
        this.pin = null;
        this.failedAttempts = 0;
        this.lockState = LockState.UNLOCKED;
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
