package com.bnelson.miscgames.chess.common.pieces.chess;

import com.bnelson.miscgames.common.teams.IsTeam;
import com.bnelson.miscgames.chess.common.pieces.ChessPiece;
import com.bnelson.miscgames.common.positioning.Position;
import com.bnelson.miscgames.common.positioning.RelativePosition;
import com.bnelson.miscgames.chess.common.utils.Util;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class QueenPiece extends ChessPiece {

    private final ImageIcon icon;
    private final List<RelativePosition> movements;

    public QueenPiece(IsTeam isTeam) {
        super("Queen", isTeam, new Position(3,0));
        icon = Util.getResourceImage(getClass(), Util.ImageResource.QUEEN_BLACK);
        movements = new ArrayList<>();
        movements.addAll(Util.getRepeatedDiagonalMoves(7));
        movements.addAll(Util.getRepeatedHorizontalMoves(7));
        movements.addAll(Util.getRepeatedVerticalMoves(7));
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
