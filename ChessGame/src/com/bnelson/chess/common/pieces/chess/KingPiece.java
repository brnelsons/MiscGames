package com.bnelson.chess.common.pieces.chess;

import com.bnelson.chess.common.IsTeam;
import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.pieces.ChessPiece;
import com.bnelson.chess.common.positioning.RelativePosition;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class KingPiece extends ChessPiece {

    private final ImageIcon icon;
    private final List<RelativePosition> movements;

    private Position position;

    public KingPiece(IsTeam isTeam) {
        super("King", isTeam);
        icon = new ImageIcon(getClass().getResource("../../resources/king_blk.png"));
        position = getDefaultPosition();
        movements = new ArrayList<>();
    }

    @Override
    public Position getDefaultPosition() {
        return new Position(4,0);
    }

    @Override
    public List<RelativePosition> getMovements() {
        return movements;
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
