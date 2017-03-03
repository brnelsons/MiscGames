package com.bnelson.chess.common;

import com.bnelson.chess.common.pieces.HasPieces;
import com.bnelson.chess.common.pieces.interfaces.HasName;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.chess.common.positioning.Direction;
import com.bnelson.chess.common.positioning.HasDirection;

import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessPlayer implements HasTeam, HasName, HasInverse, HasDirection, HasPieces {

    private final String name;
    private final IsTeam team;
    private final List<IsChessPiece> pieces;

    public ChessPlayer(String playerName, IsTeam isTeam, List<IsChessPiece> pieces) {
        this.name = playerName;
        this.team = isTeam;
        this.pieces = pieces;
    }

    @Override
    public boolean isInverse() {
        return team.isInverse();
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
    public List<IsChessPiece> getPieces() {
        return pieces;
    }
}
