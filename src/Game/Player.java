package Game;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> Hand;

    public Player(int initial){
        for (int i = 0; i < initial; i++){
            Hand.add(Game.drawDeck());
        }
    }

    public Card chooseCard(){
        if(Game.getTop().getNum() < 10){
            for(int i = 0; i < Hand.size(); i++){
                if(Game.getTop().getColor().equals(Hand.get(i).getColor())){

                } else if (Game.getTop().getNum() == Hand.get(i).getNum()){

                }
            }
        }
    }


}
