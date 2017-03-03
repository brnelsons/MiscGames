package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.IsTeam;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.chess.common.positioning.Direction;
import com.bnelson.chess.common.positioning.Position;

/**
 * Created by brnel on 2/28/2017.
 */
public abstract class ChessPiece implements IsChessPiece {

    private String name;
    private IsTeam isTeam;
    private boolean isSelected;
    private Position position;

    private final Position defaultPosition;

    public ChessPiece(String name,
                      IsTeam isTeam,
                      Position defaultPosition){
        this.name = name;
        this.isTeam = isTeam;
        this.defaultPosition = isTeam.getDirection() == Direction.UP ? defaultPosition.getInverse(7) : defaultPosition;
        this.position = this.defaultPosition;
    }

    @Override
    public boolean isSelected() {
        return isSelected;
    }

    @Override
    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public IsTeam getTeam() {
        return isTeam;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public Position getDefaultPosition() {
        return defaultPosition;
    }

    @Override
    public boolean isInverse() {
        return getTeam().isInverse();
    }

    @Override
    public Direction getDirection() {
        return getTeam().getDirection();
    }

    @Override
    public void move(Position position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChessPiece that = (ChessPiece) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (isTeam != null ? !isTeam.equals(that.isTeam) : that.isTeam != null) return false;
        return defaultPosition != null ? defaultPosition.equals(that.defaultPosition) : that.defaultPosition == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (isTeam != null ? isTeam.hashCode() : 0);
        result = 31 * result + (defaultPosition != null ? defaultPosition.hashCode() : 0);
        return result;
    }
}
