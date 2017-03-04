package com.bnelson.miscgames.chess.common.pieces.chess;

import com.bnelson.miscgames.common.teams.IsTeam;
import com.bnelson.miscgames.chess.common.pieces.ChessPiece;
import com.bnelson.miscgames.common.positioning.Position;
import com.bnelson.miscgames.common.positioning.RelativePosition;
import com.bnelson.miscgames.chess.common.utils.Util;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class PawnPiece extends ChessPiece {

    private final ImageIcon icon;
    private final List<RelativePosition> movements;
    private final int x;

    public PawnPiece(int x, IsTeam isTeam) {
        super("Pawn", isTeam, new Position(x,1));
        this.icon = Util.getResourceImage(getClass(), Util.ImageResource.KING_BLACK);
        this.x = x;
        movements = new ArrayList<>();
        movements.add(new RelativePosition(0, 1));
        movements.add(new RelativePosition(0, 2));
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        PawnPiece pawnPiece = (PawnPiece) o;

        return x == pawnPiece.x;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + x;
        return result;
    }
}
