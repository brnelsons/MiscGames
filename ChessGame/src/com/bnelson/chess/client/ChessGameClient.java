package com.bnelson.chess.client;

import com.bnelson.chess.common.board.ChessBoard;
import com.bnelson.chess.common.pieces.ChessPieces;
import com.bnelson.chess.common.pieces.IsChessPiece;
import com.bnelson.chess.common.positioning.Position;

import javax.swing.*;
import java.awt.*;
import java.util.Map;

/**
 * Created by brnel on 2/28/2017.
 *
 * GUI thread manager object
 */
public class ChessGameClient extends JFrame{

    ChessBoard chessBoard;

    public ChessGameClient() throws HeadlessException {
        super("Chess Game");
        start();
        setLayout(null);
        setSize(new Dimension(500, 500));
    }

    private void start(){
//        JButton king = new JButton("King");
//        king.setBounds(0, 0, 100, 100);
//        this.getContentPane().add(king);
        this.chessBoard = ChessBoard.newBuilder()
                .addPiece(ChessPieces.KING)
                .build();
    }

    public void update(){
        for (Map.Entry<Position, IsChessPiece> chessPieceEntry : chessBoard.getGameBoard().entrySet()) {
            IsChessPiece piece = chessPieceEntry.getValue();
            JButton pieceButton = new JButton(piece.getIcon());
            pieceButton.setBounds(0,0,50,50);
            pieceButton.setVisible(true);
            getContentPane().add(pieceButton);
        }
        revalidate();
    }
}
