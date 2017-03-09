package com.bnelson.miscgames.chess.common.pieces;

import com.bnelson.miscgames.chess.common.pieces.chess.RookPiece;
import com.bnelson.miscgames.chess.common.utils.Util;
import com.bnelson.miscgames.common.positioning.Side;
import com.bnelson.miscgames.common.teams.IsTeam;
import com.bnelson.miscgames.chess.common.pieces.chess.KingPiece;
import com.bnelson.miscgames.chess.common.pieces.chess.PawnPiece;
import com.bnelson.miscgames.chess.common.pieces.chess.QueenPiece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessPieces {

    public static List<ChessPiece> getAll(Class<?> clazz, IsTeam isTeam){
        ArrayList<ChessPiece> pieces = new ArrayList<>();
        pieces.add(new KingPiece(isTeam));
        pieces.add(new QueenPiece(isTeam));
        pieces.add(new RookPiece(isTeam, Side.LEFT, Util.getResourceImage(clazz, Util.ImageResource.ROOK_BLACK)));
        pieces.add(new RookPiece(isTeam, Side.RIGHT, Util.getResourceImage(clazz, Util.ImageResource.ROOK_BLACK)));
        for(int i = 0;i<8;i++){
            pieces.add(new PawnPiece(i, isTeam));
        }
        return pieces;
    }
}
