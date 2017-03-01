package com.bnelson.chess.client;

import com.bnelson.chess.common.board.ChessBoard;
import com.bnelson.chess.common.pieces.ChessPieces;
import com.bnelson.chess.common.pieces.PieceButton;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.positioning.RelativePosition;
import com.bnelson.chess.common.utils.Util;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by brnel on 2/28/2017.
 *
 * GUI thread manager object
 */
public class ChessGameClient extends JFrame{

    private ChessBoard chessBoard;
    private Map<IsChessPiece, Icon> iconCache;
    private Map<IsChessPiece, PieceButton> buttonCache;
    private int tileSize;

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
                .addAllPieces(ChessPieces.getAll())
                .build();
        setupImageCache();
    }

    private void setupImageCache() {
        iconCache = new HashMap<>();
        buttonCache = new HashMap<>();
        tileSize = chessBoard.getTileSize();
        int imageSize = chessBoard.getTileSize()-20;
        for (IsChessPiece isChessPiece : chessBoard.getGameBoard().values()) {
            Image scaledImage = Util.getScaledImage(isChessPiece.getImageIcon(), imageSize, imageSize);
            iconCache.put(isChessPiece, new ImageIcon(scaledImage));
            PieceButton pieceButton = new PieceButton(isChessPiece, iconCache.get(isChessPiece), tileSize, tileSize, tileSize);
            pieceButton.setBounds(
                    isChessPiece.getPosition().getX()* tileSize,
                    isChessPiece.getPosition().getY()* tileSize,
                    tileSize,
                    tileSize
            );
            pieceButton.setVisible(true);
            buttonCache.put(isChessPiece, pieceButton);
            getContentPane().add(pieceButton);
        }
    }

    public void update(){
        for (Map.Entry<Position, IsChessPiece> chessPieceEntry : chessBoard.getGameBoard().entrySet()) {
            IsChessPiece piece = chessPieceEntry.getValue();
            updateButtonPosition(piece);
            if(piece.isSelected()){
                showPotentialMoves(piece);
            }
        }
        revalidate();
    }

    private void showPotentialMoves(IsChessPiece piece) {
        for (RelativePosition position : piece.getMovements()) {
            Position newPosition = new Position(position, piece.getPosition());

        }
    }

    private void updateButtonPosition(IsChessPiece piece) {
        JButton pieceButton = buttonCache.get(piece);
        pieceButton.setBounds(
                piece.getPosition().getX()* tileSize,
                piece.getPosition().getY()* tileSize,
                tileSize,
                tileSize
        );
    }
}
