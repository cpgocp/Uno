package Game;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    private static ArrayList<Card> Deck;
    private static ArrayList<Card> Discard = new ArrayList<Card>();

    private static final int HAND_SIZE = 7;

    private static int turn;
    private static ArrayList<Player> order;

    private static int addCount;

    Random random = new Random();


    public Game(){

        turn = 0;
        addCount = 0;

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

        shuffleDeck();

        Discard.add(Deck.get(Deck.size()-1));
        Deck.remove(Deck.size() - 1);

        int players = 2;

        for(int i = 0; i < players; i++){
            Player player = new Player(HAND_SIZE);
            order.add(player);
        }

        order.get(0).setAuto(false);

    }

    public ArrayList<Player> getOrder(){
        return order;
    }

    public static int getTurn() {
        return turn;
    }

    public static int getAddCount() {
        return addCount;
    }

    public static void resetAddCount(){
        addCount = 0;
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

    public static void addTurn(int n){
        turn += n;
    }

    public static void reverseOrder(){
        ArrayList<Player> reversed = new ArrayList<Player>();
        for(int i = order.size() - 1; i >=0 ; i--){
            reversed.add(order.get(i));
        }
        order = reversed;
    }

    public static boolean hasWinner(){
        boolean winCheck = false;
        for(int i = 0; i < order.size(); i++){
            if(winCheck){
                winCheck = order.get(i).isWinner();
            }
        }
        return winCheck;
    }

    public static boolean playCard(Card card, String color){
        if(card.getColor().equals("Wild")){
            if(card.getNum() == 4){
                addCount+=4;
                Discard.add(card);
                Game.addTurn(1);
            } else {
                Discard.add(card);
                Game.addTurn(1);
            }
            return true;
        }else if (Game.getTop().getColor().equals(card.getColor())){
            Discard.add(card);
            if(card.getNum() == 11){
                addCount+=2;
                Game.addTurn(1);
            } else if (card.getNum() == 10) {
                Game.addTurn(2);
            } else if (card.getNum() == 12){
                Game.reverseOrder();
                Game.addTurn(1);
            } else {
                Game.addTurn(1);
            }
            return true;
        } else if (Game.getTop().getNum() == card.getNum()){
            Discard.add(card);
            if(card.getNum() == 11){
                addCount+=2;
                Game.addTurn(1);
            } else if (card.getNum() == 10) {
                Game.addTurn(2);
            } else if (card.getNum() == 12){
                Game.reverseOrder();
                Game.addTurn(1);
            } else {
                Game.addTurn(1);
            }
            return true;
        } else {
            return false;
        }
    }

}
