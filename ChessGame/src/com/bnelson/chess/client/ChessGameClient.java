package com.bnelson.chess.client;

import com.bnelson.chess.common.ChessPlayer;
import com.bnelson.chess.common.IsTeam;
import com.bnelson.chess.common.board.ChessBoard;
import com.bnelson.chess.common.pieces.ChessPieces;
import com.bnelson.chess.common.pieces.PieceButton;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.positioning.RelativePosition;
import com.bnelson.chess.common.utils.Util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private List<ChessPlayer> players;

    enum Teams implements IsTeam{
        BLACK("Black", false),
        WHITE("White", true);

        private final String name;
        private final boolean isInverse;

        Teams(String name, boolean isInverse) {
            this.name = name;
            this.isInverse = isInverse;
        }

        @Override
        public boolean isInverse() {
            return isInverse;
        }

        @Override
        public String getName() {
            return name;
        }
    }

    public ChessGameClient() throws HeadlessException {
        super("Chess Game");
        start();
        setLayout(null);
        setSize(new Dimension(500, 500));
        players = new ArrayList<>(2);
        players.add(new ChessPlayer("Player 1", Teams.BLACK));
        players.add(new ChessPlayer("Player 2", Teams.WHITE));
    }

    private void start(){
        this.chessBoard = ChessBoard.newBuilder()
                .addAllPieces(ChessPieces.getAll(Teams.BLACK))
                .addAllPieces(ChessPieces.getAll(Teams.WHITE))
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
            PieceButton pieceButton = createChessPieceButton(isChessPiece);
            pieceButton.setVisible(true);
            buttonCache.put(isChessPiece, pieceButton);
            getContentPane().add(pieceButton);
        }
    }

    private PieceButton createChessPieceButton(IsChessPiece isChessPiece) {
        PieceButton pieceButton = new PieceButton(isChessPiece, iconCache.get(isChessPiece));
        Position position = isChessPiece.getPosition();
        pieceButton.setBounds(
                position.getX()* tileSize,
                position.getY()* tileSize,
                tileSize,
                tileSize
        );
        System.out.println("Creating chess piece button " + isChessPiece.getName() + " at " + position.getX() + ", " + position.getY());
        return pieceButton;
    }

    private JButton createMovementButton(Position position) {
        JButton movement = new JButton("M");
        movement.setBounds(
                position.getX()* tileSize,
                position.getY()* tileSize,
                tileSize,
                tileSize
        );
        return movement;
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
            getContentPane().add(createMovementButton(newPosition));
        }
    }

    private void updateButtonPosition(IsChessPiece piece) {
        JButton pieceButton = buttonCache.get(piece);
        pieceButton.setVisible(true);
        pieceButton.setBounds(
                piece.getPosition().getX()* tileSize,
                piece.getPosition().getY()* tileSize,
                tileSize,
                tileSize
        );
    }
}
