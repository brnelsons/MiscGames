package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.positioning.HasDefaultPosition;
import com.bnelson.chess.common.positioning.HasMovements;
import com.bnelson.chess.common.positioning.HasPosition;

/**
 * Created by brnel on 2/28/2017.
 */
public interface IsChessPiece extends HasMovements, HasPosition, HasIcon, HasDefaultPosition, HasName {
}
