package Game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private static ArrayList<Card> Deck;
    private static ArrayList<Card> Discard;

    private static final int HAND_SIZE = 7;

    private int turn;

    Random random = new Random();

    public Game(){

        turn = 0;

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

    }

    public void shuffleDeck(){
        for(int i = Deck.size(); i > 1; i--){
            int j = random.nextInt(i);
            Card hold = Deck.get(i);
            Deck.set(i,Deck.get(j));
            Deck.set(j,hold);
        }
    }

    public static Card drawDeck(){
        Card drawn = Deck.get(Deck.size() - 1);
        Deck.remove(Deck.size() - 1);
        return drawn;
    }

    public static Card getTop(){
        Card top = Discard.get(Deck.size() - 1);
        return top;
    }

    public void addTurn(int n){
        turn += n;
    }

}
