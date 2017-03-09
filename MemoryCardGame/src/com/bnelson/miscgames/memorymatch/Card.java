package com.bnelson.miscgames.memorymatch;

import com.bnelson.miscgames.common.positioning.Position;
import com.bnelson.miscgames.common.positioning.Size;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;

/**
 * Created by brnel on 3/7/2017.
 */
public class Card extends JButton {

    private final String placeHolder;
    private String value;
    private Color color;
    private boolean isShowingValue=false;
    private boolean matchFound=false;

    public Card(Size size,
                Position position,
                String placeHolder,
                String value,
                Color color) {
        super(placeHolder);
        this.value = value;
        this.placeHolder = placeHolder;
        this.color = color;
        setVisible(true);
        setBounds(position.getX(), position.getY(), size.getWidth(), size.getHeight());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        Graphics2D g2d = (Graphics2D) g;
//        g.drawRect(position.getX(), position.getY(), size.getWidth(), size.getHeight());

    }

    public boolean isShowingValue() {
        return isShowingValue;
    }

    public void setShowingValue(boolean showingValue) {
        if(!matchFound) {
            if (showingValue) {
                setText(value);
                setBackground(Color.WHITE);
            } else {
                setText(placeHolder);
                setBackground(null);
            }
            isShowingValue = showingValue;
        }
    }

    public String getValue() {
        return value;
    }

    public boolean isMatchFound() {
        return matchFound;
    }

    public void setMatchFound() {
        this.matchFound = true;
        setBackground(Color.GREEN);
    }
}
