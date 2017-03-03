package com.bnelson.chess.client;

import com.bnelson.chess.common.CanMove;
import com.bnelson.chess.common.ChessPlayer;
import com.bnelson.chess.common.IsTeam;
import com.bnelson.chess.common.board.ChessBoard;
import com.bnelson.chess.common.pieces.ChessPieces;
import com.bnelson.chess.common.pieces.PieceButton;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.chess.common.positioning.Direction;
import com.bnelson.chess.common.positioning.Position;
import com.bnelson.chess.common.positioning.RelativePosition;
import com.bnelson.chess.common.utils.Util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
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
    private List<JButton> movementCache;
    private int tileSize;
    private List<ChessPlayer> players;
    private IsChessPiece selectedPiece;
    private Container contentPane;

    enum Teams implements IsTeam{
        BLACK("Black", false, Direction.UP),
        WHITE("White", true, Direction.DOWN);

        private final String name;
        private final boolean isInverse;
        private final Direction direction;

        Teams(String name, boolean isInverse, Direction direction) {
            this.name = name;
            this.isInverse = isInverse;
            this.direction = direction;
        }

        @Override
        public boolean isInverse() {
            return isInverse;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public Direction getDirection() {
            return direction;
        }
    }

    public ChessGameClient() throws HeadlessException {
        super("Chess Game");
        ChessPlayer player1 = new ChessPlayer("Player 1", Teams.BLACK, ChessPieces.getAll(Teams.BLACK));
        ChessPlayer player2 = new ChessPlayer("Player 2", Teams.WHITE, ChessPieces.getAll(Teams.WHITE));
        players = new ArrayList<>(2);
        players.add(player1);
        players.add(player2);
        start(players);
        setLayout(null);
        setSize(new Dimension(500, 500));
    }

    private void start(List<ChessPlayer> players){
        ChessBoard.Builder builder = ChessBoard.newBuilder();
        for(ChessPlayer player : players){
            builder.addAllPieces(player);
        }
        this.chessBoard = builder.build();
        setupImageCache();
    }

    private void setupImageCache() {
        iconCache = new HashMap<>();
        buttonCache = new HashMap<>();
        movementCache = new ArrayList<>();
        contentPane = getContentPane();
        tileSize = chessBoard.getTileSize();
        int imageSize = chessBoard.getTileSize()-20;
        for (IsChessPiece isChessPiece : chessBoard.getGameBoard().values()) {
            Image scaledImage = Util.getScaledImage(isChessPiece.getImageIcon(), imageSize, imageSize);
            iconCache.put(isChessPiece, new ImageIcon(scaledImage));
            PieceButton pieceButton = new PieceButton(isChessPiece, iconCache.get(isChessPiece), tileSize);
            buttonCache.put(isChessPiece, pieceButton);
            contentPane.add(pieceButton);
        }
    }

    public void update(){
        for (Map.Entry<Position, IsChessPiece> chessPieceEntry : chessBoard.getGameBoard().entrySet()) {
            IsChessPiece piece = chessPieceEntry.getValue();
            updateButtonPosition(piece);
            if(piece.isSelected()&& !piece.equals(selectedPiece)){
                for (JButton btn : movementCache) {
                    contentPane.remove(btn);
                }
                movementCache.clear();
                selectedPiece = piece;
                for (JButton jButton : getPotentialMoves(piece)) {
                    movementCache.add(jButton);
                    contentPane.add(jButton);
                }

            }
        }
        redraw();
    }

    private void redraw() {
        repaint();
        revalidate();
    }

    private List<JButton> getPotentialMoves(IsChessPiece piece) {
        List<JButton> buttons = new ArrayList<>();
        for (RelativePosition relativePos : piece.getMovements()) {
            Position absolutePosition = relativePos.getAbsolutePosition(piece.getPosition(), piece);
            buttons.add(newButton(absolutePosition, piece));
        }
        return buttons;
    }

    private JButton newButton(final Position absolutePosition,
                              final CanMove canMove) {
        JButton movement = new JButton("M");
        movement.setVisible(true);
        movement.setBounds(
                absolutePosition.getX()* tileSize,
                absolutePosition.getY()* tileSize,
                tileSize,
                tileSize
        );
        movement.addActionListener(e -> canMove.move(absolutePosition));
        return movement;
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
