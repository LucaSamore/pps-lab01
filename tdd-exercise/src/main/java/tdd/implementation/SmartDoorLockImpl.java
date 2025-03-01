package tdd.implementation;

import tdd.SmartDoorLock;

interface Pin {}

public final class SmartDoorLockImpl implements SmartDoorLock {

    private record FourDigitPin(int pin) implements Pin {
        public FourDigitPin {
            if (pin <= 1000 || pin > 9999) {
                throw new IllegalArgumentException("PIN must be a 4-digit number");
            }
        }
    }

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
    public void setPin(final int pin) throws IllegalArgumentException {
        this.pin = new FourDigitPin(pin);
    }

    @Override
    public void unlock(final int pin) throws IllegalArgumentException {
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
        this.lockState = LockState.LOCKED;
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

    private boolean pinIsIncorrect(final int pin) throws IllegalArgumentException {
        final var givenPin = new FourDigitPin(pin);
        return !this.pin.equals(givenPin);
    }

    private void handleFailedAttempt() {
        this.failedAttempts++;
        if (this.failedAttempts >= this.maxAttempts) {
            this.lockState = LockState.BLOCKED;
        }
    }
}
