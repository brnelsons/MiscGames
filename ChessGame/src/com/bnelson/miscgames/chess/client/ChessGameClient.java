package com.bnelson.miscgames.chess.client;

import com.bnelson.miscgames.chess.common.ChessPlayer;
import com.bnelson.miscgames.chess.common.pieces.HasChessPieces;
import com.bnelson.miscgames.common.boards.IsGameBoard;
import com.bnelson.miscgames.common.teams.IsTeam;
import com.bnelson.miscgames.chess.common.board.ChessBoard;
import com.bnelson.miscgames.chess.common.pieces.ChessPiece;
import com.bnelson.miscgames.chess.common.pieces.ChessPieces;
import com.bnelson.miscgames.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.miscgames.common.positioning.Direction;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by brnel on 2/28/2017.
 * <p>
 * GUI thread manager object
 */
public class ChessGameClient extends JFrame implements IsGameBoard {

    private static final int IMAGE_PADDING = 20;

    private ChessBoard chessBoard;
    private List<JButton> movementCache;
    private int tileSize;
    private Map<Position, JButton> movementButtonMap;
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
        setLayout(null);
        setSize(new Dimension(500, 500));
    }

    @Override
    public void init() {
        movementButtonMap = new HashMap<>();
        movementCache = new ArrayList<>();
        contentPane = getContentPane();
        //default is 2 players
        ChessPlayer player1 = new ChessPlayer("Player 1", Teams.BLACK, ChessPieces.getAll(getClass(), Teams.BLACK));
        ChessPlayer player2 = new ChessPlayer("Player 2", Teams.WHITE, ChessPieces.getAll(getClass(), Teams.WHITE));
        List<HasChessPieces> players = new ArrayList<>(2);
        players.add(player1);
        players.add(player2);
        this.chessBoard = ChessBoard.newBuilder()
                .addAllPieces(players)
                .build();
        tileSize = chessBoard.getTileSize();
        setupCache();
    }

    @Override
    public void start() {

    }

    @Override
    public boolean isOver() {
        return false;
    }

    @Override
    public void save() {

    }

    @Override
    public void stop() {
        //TODO dump the cache
    }

    private void setupCache() {
        int imageSize = chessBoard.getTileSize() - IMAGE_PADDING;
        for (ChessPiece chessPiece : chessBoard.getGameBoard().values()) {
            Icon scaledImage = new ImageIcon(Util.getScaledImage(chessPiece.getImageIcon(), imageSize, imageSize));
            chessPiece.setIcon(scaledImage);
            contentPane.add(chessPiece, 0);
        }

        for (int i = 0; i < chessBoard.getHorizontalTileCount(); i++) {
            for (int j = 0; j < chessBoard.getHorizontalTileCount(); j++) {
                addInvisibleMovementButton(new Position(i, j));
            }
        }
    }

    private void addInvisibleMovementButton(Position position) {
        JButton movement = new JButton("M");
        movement.setVisible(false);
        movement.setBounds(
                position.getX() * tileSize,
                position.getY() * tileSize,
                tileSize,
                tileSize
        );
        contentPane.add(movement, 3);
        movementButtonMap.put(position, movement);
    }

    public void update() {
        for (IsChessPiece chessPiece : chessBoard.getGameBoard().values()) {
            if (chessPiece.isSelected()) {
                if (selectedPiece != null) {
                    selectedPiece.setIsSelected(false);
                }
                selectedPiece = chessPiece;
            }

            //show selected movement options;
            if (selectedPiece != null && selectedPiece.isSelected()) {
                //hideAll
                for (JButton movement : movementButtonMap.values()) {
                    movement.setVisible(false);
                }
                //show new ones
                for (RelativePosition relativePos : selectedPiece.getMovements()) {
                    Position absolutePosition = relativePos.getAbsolutePosition(selectedPiece.getPosition(), selectedPiece);
                    JButton jButton = movementButtonMap.get(absolutePosition);
                    if (jButton != null) {
                        jButton.setVisible(true);
                    }
                }
            }
        }
        redraw();
    }

    private void redraw() {
        repaint();
        revalidate();
    }
}
