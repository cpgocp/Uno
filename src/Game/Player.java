package Game;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> Hand;

    public Player(int initial){
        for (int i = 0; i < initial; i++){
            Hand.add(Game.drawDeck());
        }
    }

}
