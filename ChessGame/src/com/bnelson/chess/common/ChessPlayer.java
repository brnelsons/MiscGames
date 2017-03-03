package com.bnelson.chess.common;

import com.bnelson.chess.common.pieces.ChessPiece;
import com.bnelson.chess.common.pieces.HasChessPieces;
import com.bnelson.chess.common.pieces.interfaces.HasName;
import com.bnelson.chess.common.positioning.Direction;
import com.bnelson.chess.common.positioning.HasDirection;

import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessPlayer implements HasTeam, HasName, HasDirection, HasChessPieces {

    private final String name;
    private final IsTeam team;
    private final List<ChessPiece> pieces;

    public ChessPlayer(String playerName, IsTeam isTeam, List<ChessPiece> pieces) {
        this.name = playerName;
        this.team = isTeam;
        this.pieces = pieces;
    }

    @Override
    public IsTeam getTeam() {
        return team;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Direction getDirection() {
        return team.getDirection();
    }

    @Override
    public List<ChessPiece> getPieces() {
        return pieces;
    }
}
