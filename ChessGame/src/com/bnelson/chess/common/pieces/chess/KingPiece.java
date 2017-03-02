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

    private static final Position DEFAULT_POS = new Position(4,0);

    public KingPiece(IsTeam isTeam) {
        super("King", isTeam, DEFAULT_POS);
        icon = new ImageIcon(getClass().getResource("../../resources/king_blk.png"));
        movements = new ArrayList<>();
    }

    @Override
    public List<RelativePosition> getMovements() {
        return movements;
    }

    @Override
    public ImageIcon getImageIcon() {
        return icon;
    }
}
