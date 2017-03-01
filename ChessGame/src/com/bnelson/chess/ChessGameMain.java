package com.bnelson.chess;

import com.bnelson.chess.client.ChessGameClient;

import javax.swing.*;

/**
 * Created by brnel on 2/28/2017.
 */
public class ChessGameMain {

    public static void main(String[] args){

        ChessGameClient client = new ChessGameClient();
        client.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        client.setVisible(true);
        while(client.isVisible()){
            client.update();
        }
        System.exit(0);
    }
}
