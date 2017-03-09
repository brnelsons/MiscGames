package com.bnelson.miscgames.memorymatch;

/**
 * Created by brnel on 3/7/2017.
 */
public class MemoryMatchMain {
    public static void main(String[] args) throws InterruptedException {
        MemoryMatchManager game = new MemoryMatchManager();
        game.init();
        game.start();
        while(!game.isOver()){
            //do nothing
            Thread.sleep(1000/60);
        }
        System.exit(0);
    }
}
