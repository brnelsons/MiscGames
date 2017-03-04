package com.bnelson.miscgames.chess.common.board;

import com.bnelson.miscgames.chess.common.pieces.HasChessPieces;
import com.bnelson.miscgames.common.positioning.Position;
import com.bnelson.miscgames.chess.common.pieces.ChessPiece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessBoard implements HasBoardTiles{

    public static final int TILE_SIZE = 50;
    public static final int TILE_COUNT_X = 8;
    public static final int TILE_COUNT_Y = 8;

    private Map<Position, ChessPiece> gameBoard;

    private ChessBoard(Map<Position, ChessPiece> gameBoard){
        this.gameBoard = gameBoard;
    }

    public Map<Position, ChessPiece> getGameBoard() {
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

        private Map<Position, ChessPiece> board;

        private Builder(){
            board = new HashMap<>();
        }

        public <T extends HasChessPieces> Builder addAllPieces(List<T> hasChessPieces){
            for(T hasChessPiece : hasChessPieces){
                addAllPieces(hasChessPiece);
            }
            return this;
        }

        public Builder addAllPieces(HasChessPieces hasChessPieces){
            for(ChessPiece chessPiece : hasChessPieces.getPieces()) {
                board.put(chessPiece.getPosition(), chessPiece);
            }
            return this;
        }

        public ChessBoard build(){
            return new ChessBoard(board);
        }
    }

}
