package com.bnelson.miscgames.chess.common;

import com.bnelson.miscgames.chess.common.pieces.ChessPiece;
import com.bnelson.miscgames.chess.common.pieces.HasChessPieces;
import com.bnelson.miscgames.common.players.IsPlayer;
import com.bnelson.miscgames.common.positioning.Direction;
import com.bnelson.miscgames.common.teams.IsTeam;

import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessPlayer implements IsPlayer, HasChessPieces {

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
