package org.example.enums;

public enum Direction {
    RIGHT,
    LEFT,
    UP,
    DOWN;

    public Direction opposite() {
        switch (this) {
            case UP:
                return DOWN;
            case DOWN:
                return UP;
            case LEFT:
                return RIGHT;
            case RIGHT:
                return LEFT;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
    }
}
