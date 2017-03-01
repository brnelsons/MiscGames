package com.bnelson.chess.common.pieces.chess;

import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.pieces.ChessPiece;

import javax.swing.*;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class KingPiece extends ChessPiece {

    public KingPiece() {
        super("King");
    }

    @Override
    public Position getDefaultPosition() {
        return new Position(4,0);
    }

    @Override
    public List<Position> getMovements() {
        return null;
    }

    @Override
    public Icon getIcon() {
        return new ImageIcon(getClass().getResource("../../resources/king_blk.png"));
    }
}
