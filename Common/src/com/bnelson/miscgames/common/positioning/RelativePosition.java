package com.bnelson.miscgames.common.positioning;

/**
 * Created by brnel on 2/28/2017.
 */
public class RelativePosition extends Position {
    public RelativePosition(int x, int y) {
        super(x, y);
    }

    public Position getAbsolutePosition(Position position, HasDirection hasDirection) {
        if (hasDirection.getDirection() == Direction.UP) {
            RelativePosition reverse = getReverse();
            return new Position(position.getX() + reverse.getX(), position.getY() + reverse.getY());
        }
        return new Position(position.getX() + getX(), position.getY() + getY());
    }

    public RelativePosition getReverse(){
        return new RelativePosition(getX()*-1, getY()*-1);
    }
}
