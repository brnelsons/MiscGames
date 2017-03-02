package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.IsTeam;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.chess.common.positioning.Position;

/**
 * Created by brnel on 2/28/2017.
 */
public abstract class ChessPiece implements IsChessPiece {

    private String name;
    private IsTeam isTeam;
    private boolean isSelected;
    private Position position;

    public ChessPiece(String name, IsTeam isTeam){
        this.name = name;
        this.isTeam = isTeam;
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
}
