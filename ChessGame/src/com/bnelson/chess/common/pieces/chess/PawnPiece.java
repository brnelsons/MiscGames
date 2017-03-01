package com.bnelson.chess.common.pieces.chess;

import com.bnelson.chess.common.pieces.ChessPiece;
import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.positioning.RelativePosition;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class PawnPiece extends ChessPiece {

    private final ImageIcon icon;
    private final int x;

    private Position position;

    public PawnPiece(int x) {
        super("Queen");
        this.x = x;
        this.icon = new ImageIcon(getClass().getResource("../../resources/king_blk.png"));
        this.position = getDefaultPosition();
    }

    @Override
    public Position getDefaultPosition() {
        return new Position(x,1);
    }

    @Override
    public List<RelativePosition> getMovements() {
        ArrayList<RelativePosition> relativePositions = new ArrayList<>();
        relativePositions.add(new RelativePosition(-2, 0));
        relativePositions.add(new RelativePosition(-1, 0));
        return relativePositions;
    }

    @Override
    public ImageIcon getImageIcon() {
        return icon;
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
