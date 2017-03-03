package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;

import java.util.List;

/**
 * Created by brnel on 3/2/2017.
 */
public interface HasPieces {
    List<IsChessPiece> getPieces();
}
