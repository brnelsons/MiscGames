package com.bnelson.chess.common.positioning;

/**
 * Created by brnel on 2/28/2017.
 */
public class Position {
    private final int x,y;

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
}
