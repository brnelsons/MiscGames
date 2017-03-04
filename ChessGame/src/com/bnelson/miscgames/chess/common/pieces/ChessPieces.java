package com.bnelson.miscgames.chess.common.pieces;

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

    public static List<ChessPiece> getAll(IsTeam isTeam){
        ArrayList<ChessPiece> pieces = new ArrayList<>();
        pieces.add(new KingPiece(isTeam));
        pieces.add(new QueenPiece(isTeam));
        for(int i = 0;i<8;i++){
            pieces.add(new PawnPiece(i, isTeam));
        }
        return pieces;
    }
}
