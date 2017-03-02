package com.bnelson.chess.common.board;

import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.pieces.ChessPiece;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessBoard implements HasBoardTiles{

    private static final int TILE_SIZE = 50;
    private static final int TILE_COUNT_X = 8;
    private static final int TILE_COUNT_Y = 8;

    private Map<Position, IsChessPiece> gameBoard;

    private ChessBoard(Map<Position, IsChessPiece> gameBoard){
        this.gameBoard = gameBoard;
    }

    public Map<Position, IsChessPiece> getGameBoard() {
        return gameBoard;
    }

    public static Builder newBuilder(){
        return new Builder();
    }

    @Override
    public int getVerticalTileCount() {
        return TILE_COUNT_Y;
    }

    @Override
    public int getHorizontalTileCount() {
        return TILE_COUNT_X;
    }

    @Override
    public int getTileSize() {
        return TILE_SIZE;
    }

    public static class Builder{

        private Map<Position, IsChessPiece> board;

        private Builder(){
            board = new HashMap<>();
        }

        public Builder addPiece(Position position, ChessPiece chessPiece){
            board.put(position, chessPiece);
            return this;
        }

        public Builder addPiece(IsChessPiece chessPiece){
            board.put(chessPiece.getPosition(), chessPiece);
            return this;
        }

        public Builder addAllPieces(List<IsChessPiece> chessPieces){
            for(IsChessPiece chessPiece : chessPieces) {
                board.put(chessPiece.getPosition(), chessPiece);
            }
            return this;
        }

        public ChessBoard build(){
            return new ChessBoard(board);
        }
    }

}
