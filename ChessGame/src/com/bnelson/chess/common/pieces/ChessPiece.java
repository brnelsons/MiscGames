package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;

/**
 * Created by brnel on 2/28/2017.
 */
public abstract class ChessPiece implements IsChessPiece {

    private String name;
    private boolean isSelected;

    public ChessPiece(String name){
        this.name = name;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChessPiece that = (ChessPiece) o;

        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}
