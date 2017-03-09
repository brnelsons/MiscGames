package com.bnelson.miscgames.common.boards;

/**
 * Created by brnel on 3/3/2017.
 */
public interface IsGameBoard {
    void init();
    void start();
    boolean isOver();
    void save();
    void stop();
}
