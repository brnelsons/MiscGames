package com.bnelson.miscgames.common.positioning;

/**
 * Created by brnel on 2/28/2017.
 */
public class Position {
    private final int x,y;

    public Position(RelativePosition relativePosition, Position currentPosition){
        this.x = currentPosition.getX() + relativePosition.getX();
        this.y = currentPosition.getY() + relativePosition.getY();
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Position getInverse(int n){
        return new Position(n-x, n-y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (x != position.x) return false;
        return y == position.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
