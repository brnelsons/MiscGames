package com.bnelson.miscgames.chess.client;

import com.bnelson.miscgames.chess.common.ChessPlayer;
import com.bnelson.miscgames.common.teams.IsTeam;
import com.bnelson.miscgames.chess.common.board.ChessBoard;
import com.bnelson.miscgames.chess.common.pieces.ChessPiece;
import com.bnelson.miscgames.chess.common.pieces.ChessPieces;
import com.bnelson.miscgames.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.miscgames.common.positioning.Direction;
import com.bnelson.miscgames.common.positioning.HasMovements;
import com.bnelson.miscgames.common.positioning.Position;
import com.bnelson.miscgames.common.positioning.RelativePosition;
import com.bnelson.miscgames.chess.common.utils.Util;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 *
 * GUI thread manager object
 */
public class ChessGameClient extends JFrame{

    private ChessBoard chessBoard;
    private List<JButton> movementCache;
    private int tileSize;
    private List<ChessPlayer> players;
    private IsChessPiece selectedPiece;
    private Container contentPane;

    enum Teams implements IsTeam {
        BLACK("Black", Direction.UP),
        WHITE("White", Direction.DOWN);

        private final String name;
        private final Direction direction;

        Teams(String name, Direction direction) {
            this.name = name;
            this.direction = direction;
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
        this.chessBoard = ChessBoard.newBuilder()
                .addAllPieces(players)
                .build();
        setupImageCache();
    }

    private void setupImageCache() {
        movementCache = new ArrayList<>();
        contentPane = getContentPane();
        tileSize = chessBoard.getTileSize();
        int imageSize = chessBoard.getTileSize()-20;
        for (ChessPiece chessPiece : chessBoard.getGameBoard().values()) {
            Icon scaledImage =new ImageIcon(Util.getScaledImage(chessPiece.getImageIcon(), imageSize, imageSize));
            chessPiece.setIcon(scaledImage);
            contentPane.add(chessPiece, 0);
        }
    }

    public void update(){
        for (IsChessPiece chessPiece : chessBoard.getGameBoard().values()) {
            if(chessPiece.isSelected()){
                if(selectedPiece != null){
                    selectedPiece.setIsSelected(false);
                }
                selectedPiece = chessPiece;
            }

            //show selected movement options;
            if(selectedPiece != null && selectedPiece.isSelected()){
                clearMovements();
                for (JButton jButton : getPotentialMoves(selectedPiece)) {
                    movementCache.add(jButton);
                    contentPane.add(jButton, 1);
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
                              final HasMovements hasMovements) {
        JButton movement = new JButton("M");
        movement.setVisible(true);
        movement.setBounds(
                absolutePosition.getX()* tileSize,
                absolutePosition.getY()* tileSize,
                tileSize,
                tileSize
        );
        movement.addActionListener(e -> {
            hasMovements.move(absolutePosition);
            clearMovements();
        });
        return movement;
    }

    private void clearMovements() {
        for (JButton btn : movementCache) {
            contentPane.remove(btn);
        }
        movementCache.clear();
    }
}
