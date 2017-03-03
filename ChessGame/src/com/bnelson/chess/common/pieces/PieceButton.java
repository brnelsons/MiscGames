package com.bnelson.chess.common.pieces;

import com.bnelson.chess.common.pieces.interfaces.HasChessPiece;
import com.bnelson.chess.common.pieces.interfaces.IsChessPiece;
import com.bnelson.chess.common.positioning.Position;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by brnel on 2/28/2017.
 */
public class PieceButton extends JButton implements HasChessPiece {

    private IsChessPiece chessPiece;

    public PieceButton(IsChessPiece chessPiece, Icon icon, int size) {
        super(icon);
        this.chessPiece = chessPiece;
        final Color defaultColor = null;
        final Color focusedColor = new Color(0, 255, 0, 50);
        setVisible(true);
        setBackground(defaultColor);
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                setBackground(focusedColor);
                chessPiece.setIsSelected(true);
            }

            @Override
            public void focusLost(FocusEvent e) {
                setBackground(defaultColor);
                chessPiece.setIsSelected(false);
            }
        });
        Position position = chessPiece.getPosition();
        setBounds(
                position.getX()* size,
                position.getY()* size,
                size,
                size
        );
    }

    @Override
    public void setPiece(IsChessPiece piece) {
        this.chessPiece = piece;
    }

    @Override
    public IsChessPiece getPiece() {
        return chessPiece;
    }
}
