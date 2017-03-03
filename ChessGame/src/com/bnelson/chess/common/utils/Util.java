package com.bnelson.chess.common.utils;

import javax.swing.ImageIcon;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.net.URL;

/**
 * Created by brnel on 2/28/2017.
 */
public class Util {

    private static final String IMAGE_PATH = "images/";

    public enum ImageResource {
        KING_BLACK("king_blk.png");

        private final String src;

        ImageResource(String src){
            this.src = src;
        }

        public String getSrc() {
            return src;
        }
    }

    public static Image getScaledImage(ImageIcon srcImg, int w, int h){
        BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = resizedImg.createGraphics();

        g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2.drawImage(srcImg.getImage(), 0, 0, w, h, null);
        g2.dispose();

        return resizedImg;
    }

    public static ImageIcon getResourceImage(Class<?> clazz, ImageResource img){
        return new ImageIcon(getResource(clazz, IMAGE_PATH + img.getSrc()));
    }

    public static URL getResource(Class<?> clazz, String relativePath){
        return clazz.getResource("/com/bnelson/chess/common/resources/"+relativePath);
    }
}
