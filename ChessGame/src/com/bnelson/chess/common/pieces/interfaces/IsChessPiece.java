package com.bnelson.chess.common.pieces.interfaces;

import com.bnelson.chess.common.CanMove;
import com.bnelson.chess.common.HasInverse;
import com.bnelson.chess.common.HasTeam;
import com.bnelson.chess.common.positioning.HasDefaultPosition;
import com.bnelson.chess.common.positioning.HasDirection;
import com.bnelson.chess.common.positioning.HasMovements;
import com.bnelson.chess.common.positioning.HasPosition;

/**
 * Created by brnel on 2/28/2017.
 */
public interface IsChessPiece extends HasMovements, HasPosition, HasImageIcon, HasDefaultPosition, HasName, HasTeam, IsSelectable, HasInverse, HasDirection, CanMove{
}
