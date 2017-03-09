package com.bnelson.miscgames.chess;

import com.bnelson.miscgames.chess.client.ChessGameClient;

import javax.swing.*;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessGameMain {

    public static void main(String[] args) throws InterruptedException {

        ChessGameClient client = new ChessGameClient();
        client.init();
        client.start();
        client.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        client.setVisible(true);
        while(client.isVisible()){
            Thread.sleep(1000/60);
            client.update();
        }
        System.exit(0);
    }
}
