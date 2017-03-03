package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.IsTeam;
import com.bnelson.chess.common.board.ChessBoard;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.chess.common.positioning.Direction;
import com.bnelson.chess.common.positioning.Position;

import javax.swing.JButton;
import java.awt.Color;

/**
 * Created by brnel on 2/28/2017.
 */
public abstract class ChessPiece extends JButton implements IsChessPiece {

    private static final Color FOCUS_COLOR = new Color(0, 255, 0, 50);

    private String name;
    private IsTeam isTeam;
    private boolean isSelected;
    private Position position;
    private boolean hasMoved;
    private final Position defaultPosition;

    public ChessPiece(String name,
                      IsTeam isTeam,
                      Position defaultPosition){
        super();
        this.name = name;
        this.isTeam = isTeam;
        this.defaultPosition = isTeam.getDirection() == Direction.UP ? defaultPosition.getInverse(7) : defaultPosition;
        this.position = this.defaultPosition;

        setVisible(true);
        setBackground(null);
        setBounds(this.position.getX(), this.position.getY());

        addActionListener(e -> {
            if (isSelected()) {
                //unselect it
                setBackground(null);
                setIsSelected(false);
            } else {
                setBackground(FOCUS_COLOR);
                setIsSelected(true);
            }
        });
    }

    private void setBounds(int x, int y) {
        setBounds(
                x * ChessBoard.TILE_SIZE,
                y * ChessBoard.TILE_SIZE,
                ChessBoard.TILE_SIZE,
                ChessBoard.TILE_SIZE
        );
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
    public Direction getDirection() {
        return getTeam().getDirection();
    }

    @Override
    public void move(Position position) {
        this.position = position;
        //update bounds
        setBounds(position.getX(), position.getY());
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
