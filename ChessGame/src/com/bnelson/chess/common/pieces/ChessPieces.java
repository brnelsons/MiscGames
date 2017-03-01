package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.pieces.chess.KingPiece;
import com.bnelson.chess.common.pieces.chess.PawnPiece;
import com.bnelson.chess.common.pieces.chess.QueenPiece;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessPieces {

    public static List<IsChessPiece> getAll(){
        ArrayList<IsChessPiece> pieces = new ArrayList<>();
        pieces.add(new KingPiece());
        pieces.add(new QueenPiece());
        for(int i = 0;i<8;i++){
            pieces.add(new PawnPiece(i));
        }
        return pieces;
    }
}
