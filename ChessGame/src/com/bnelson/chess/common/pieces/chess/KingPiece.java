package com.bnelson.chess.common.pieces.chess;

import com.bnelson.chess.common.IsTeam;
import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.pieces.ChessPiece;
import com.bnelson.chess.common.positioning.RelativePosition;
import com.bnelson.chess.common.utils.Util;

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
        icon = Util.getResourceImage(getClass(), Util.ImageResource.KING_BLACK);
        movements = new ArrayList<>();
        for(int x = -1; x < 2; x++) {
            for (int y = -1; y < 2; y++) {
                if(x == 0 && y ==0)
                    continue;
                movements.add(new RelativePosition(x, y));
//                System.out.println("King movement = " + x + ", " + y);
            }
        }
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
