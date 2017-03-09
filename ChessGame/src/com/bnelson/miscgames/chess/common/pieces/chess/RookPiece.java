package com.bnelson.miscgames.chess.common.pieces.chess;

import com.bnelson.miscgames.chess.common.pieces.ChessPiece;
import com.bnelson.miscgames.chess.common.utils.Util;
import com.bnelson.miscgames.common.positioning.Position;
import com.bnelson.miscgames.common.positioning.RelativePosition;
import com.bnelson.miscgames.common.positioning.Side;
import com.bnelson.miscgames.common.teams.IsTeam;

import javax.swing.ImageIcon;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class RookPiece extends ChessPiece {

    private final ImageIcon icon;
    private final Side side;
    private final List<RelativePosition> movements;

    public RookPiece(IsTeam isTeam, Side side, ImageIcon icon) {
        super("Rook", isTeam, side.equals(Side.RIGHT) ? new Position(0,0) : new Position(7,0));
        this.icon = icon;
        this.side = side;
        movements = new ArrayList<>();
        movements.addAll(Util.getRepeatedHorizontalMoves(8));
        movements.addAll(Util.getRepeatedVerticalMoves(8));
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

        RookPiece rookPiece = (RookPiece) o;

        if (icon != null ? !icon.equals(rookPiece.icon) : rookPiece.icon != null) return false;
        return side == rookPiece.side;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (side != null ? side.hashCode() : 0);
        return result;
    }
}
