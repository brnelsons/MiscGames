package com.bnelson.chess.common.pieces.chess;

import com.bnelson.chess.common.IsTeam;
import com.bnelson.chess.common.pieces.ChessPiece;
import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.positioning.RelativePosition;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class PawnPiece extends ChessPiece {

    private final ImageIcon icon;

    public PawnPiece(int x, IsTeam isTeam) {
        super("Pawn", isTeam, new Position(x,1));
        this.icon = new ImageIcon(getClass().getResource("../../resources/king_blk.png"));
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
}
