package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.positioning.Position;

import javax.swing.*;

/**
 * Created by brnel on 2/28/2017.
 */
public abstract class ChessPiece implements IsChessPiece{

    private Position position;
    private String name;

    public ChessPiece(String name){
        this.name = name;
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
    public String getName() {
        return name;
    }
}
