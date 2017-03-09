package com.bnelson.miscgames.memorymatch;

import com.bnelson.miscgames.common.boards.IsGameBoard;
import com.bnelson.miscgames.common.positioning.Position;
import com.bnelson.miscgames.common.positioning.Size;

import javax.swing.JFrame;
import javax.swing.WindowConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by brnel on 3/7/2017.
 */
public class MemoryMatchManager extends JFrame implements IsGameBoard {

    private static final String PLACE_HOLDER = "?";

    private final Size cardSize = new Size(150, 100);
    private final List<String> values = new ArrayList<>();
    private final List<Card> showingCards = new ArrayList<>(2);
    private final List<Card> foundCards = new ArrayList<>();
    private int winningValueSize;
    private int gridX, gridY;

    @Override
    public void init() {
        gridX = 4;
        gridY = 4;
        values.add("Cat");
        values.add("Cat");
        values.add("Dog");
        values.add("Dog");
        values.add("Squid");
        values.add("Squid");
        values.add("Hamster");
        values.add("Hamster");
        values.add("Mouse");
        values.add("Mouse");
        values.add("Rat");
        values.add("Rat");
        values.add("Elephant");
        values.add("Elephant");
        values.add("Squirrel");
        values.add("Squirrel");
        winningValueSize = values.size();
        setLayout(null);
        setSize(new Dimension(cardSize.getWidth() * gridX + 50, cardSize.getHeight() * gridY));
    }

    @Override
    public void start() {
        for (int x = 0; x < gridX; x++) {
            for (int y = 0; y < gridY; y++) {
                int padding = 5;
                Position cardPosition = new Position(
                        x * (cardSize.getWidth() + padding),
                        y * (cardSize.getHeight() + padding)
                );
                Card card = new Card(
                        cardSize,
                        cardPosition,
                        PLACE_HOLDER,
                        getRandomValue(),
                        Color.LIGHT_GRAY
                );
                card.addActionListener(e -> {
                    if (!card.isShowingValue()) {
                        card.setShowingValue(true);
                        showingCards.add(card);
                    }
                    checkVisibleCards(card);
                });
                getContentPane().add(card);
            }
        }
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        setVisible(true);
        repaint();
        revalidate();
    }

    private String getRandomValue() {
        Random r = new Random();
        int Low = 0;
        int High = values.size();
        int rng = r.nextInt(High - Low) + Low;
        String value = values.get(rng);
        values.remove(rng);
        return value;
    }

    @Override
    public boolean isOver() {
        return !isVisible();
    }

    /**
     * @return true if the game is over
     */
    private boolean winConditionIsMet() {
        return foundCards.size()==winningValueSize;
    }

    private void checkVisibleCards(Card clickedCard){
        //TODO switch to switch
        if(showingCards.size() == 2){
            Card first = showingCards.get(0);
            Card second = showingCards.get(1);
            if(first.getValue().equals(second.getValue())){
                first.setMatchFound();
                second.setMatchFound();
                foundCards.add(first);
                foundCards.add(second);
                showingCards.clear();
            }
        }else if(showingCards.size() > 2){
            for(Card c : showingCards){
                c.setShowingValue(false);
            }
            showingCards.clear();
            showingCards.add(clickedCard);
            clickedCard.setShowingValue(true);
        }

        if(winConditionIsMet()){
            setVisible(false);
        }
    }

    @Override
    public void save() {

    }

    @Override
    public void stop() {

    }
}
