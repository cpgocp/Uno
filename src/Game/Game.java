package Game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private ArrayList<Card> Deck;
    private ArrayList<Card> Discard;

    private static int HAND_SIZE = 7;

    Random random = new Random();

    public Game(){
        for(int i = 0; i < 4; i++){ //4 suits
            for(int j = 0; j < 13 ; j++ ){ //colored cards
                Card card1 = new Card(i,j);
                Card card2 = new Card(i,j);
                Deck.add(card1);
                Deck.add(card2);
            }
            Card card3 = new Card(4,0);
            Card card4 = new Card(4,4);
            Deck.add(card3);
            Deck.add(card4);
        }

        for(int i = 0; i < Deck.size(); i++){

        }
    }


}
