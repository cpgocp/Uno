package Game;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> Hand;

    private int order;

    public Player(int initial, int o){
        order = o;
        for (int i = 0; i < initial; i++){
            Hand.add(Game.drawDeck());
        }
    }

    public Card pickCard(){
        if(Game.getTop().getNum() < 10){
            for(int i = 0; i < Hand.size(); i++){
                if(Game.getTop().getColor().equals(Hand.get(i).getColor()) || Game.getTop().getNum() == Hand.get(i).getNum()){

                }
            }
        }
    }


}
