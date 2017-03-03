package com.bnelson.chess.common.positioning;

import java.util.List;

/**
 * Created by brnel on 2/28/2017.
 */
public interface HasMovements{
    List<RelativePosition> getMovements();
    void move(Position position);
}
