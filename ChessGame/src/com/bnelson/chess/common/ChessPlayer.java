package com.bnelson.chess.common;

import com.bnelson.chess.common.pieces.interfaces.HasName;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessPlayer implements HasTeam, HasName, HasInverse{

    private final String name;
    private final IsTeam team;

    public ChessPlayer(String playerName, IsTeam isTeam) {
        this.name = playerName;
        this.team = isTeam;
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
}
