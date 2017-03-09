package com.bnelson.miscgames.chess.common.pieces;

import com.bnelson.miscgames.common.positioning.Position;

import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

/**
 * Created by brnel on 3/4/2017.
 */
public class DrawableSquare extends JComponent {

    private final Position position;
    private final int size;

    public DrawableSquare(Position position, int size) {
        this.position = position;
        this.size = size;
        setBackground(null);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawRect(position.getX(), position.getY(), size, size);
        g.fillRect(position.getX(), position.getY(), size, size);
    }

    public Dimension getPreferredSize() {
        return new Dimension(size, size); // appropriate constants
    }
}
