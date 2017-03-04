package com.bnelson.miscgames.chess.common.pieces.interfaces;

import com.bnelson.miscgames.common.HasImageIcon;
import com.bnelson.miscgames.common.HasName;
import com.bnelson.miscgames.common.teams.HasTeam;
import com.bnelson.miscgames.common.positioning.HasDefaultPosition;
import com.bnelson.miscgames.common.positioning.HasDirection;
import com.bnelson.miscgames.common.positioning.HasMovements;
import com.bnelson.miscgames.common.positioning.HasPosition;

/**
 * Created by brnel on 2/28/2017.
 */
public interface IsChessPiece extends
        HasMovements,
        HasPosition,
        HasImageIcon,
        HasDefaultPosition,
        HasName,
        HasTeam,
        IsSelectable,
        HasDirection{
}
