package com.bnelson.chess.common.positioning;

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
}
