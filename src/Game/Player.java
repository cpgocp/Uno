package Game;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> Hand = new ArrayList<Card>();
    private boolean auto;
    private boolean winner;

    public Player(int initial){
        for (int i = 0; i < initial; i++){
            Hand.add(Game.drawDeck());
        }
        auto = true;
        winner = false;
    }

    public void setAuto(boolean t){
        auto = t;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isWinner(){
        return winner;
    }

    public void chooseCard(){
        boolean played = false;
        for(int i = 0; i < Hand.size(); i++){
            if(!Hand.get(i).getColor().equals("Wild") && Game.getTop().getColor().equals(Hand.get(i).getColor())){
                Game.playCard(Hand.get(i), "");
                Hand.remove(i);
                played = true;
                break;
            } else if (!Hand.get(i).getColor().equals("Wild") && Game.getTop().getNum() == Hand.get(i).getNum()){
                Game.playCard(Hand.get(i), "");
                Hand.remove(i);
                played = true;
                break;
            } else if (Hand.get(i).getColor().equals("Wild")) {
                Game.playCard(Hand.get(i), mostColor());
                Hand.remove(i);
                played = true;
                break;
            }
        }
        if(played == false){
            Hand.add(Game.drawDeck());
        }
    }

    public String mostColor(){
        int r = 0;
        int b = 0;
        int g = 0;
        int y = 0;
        for (int i = 0; i < Hand.size(); i++){
            switch(Hand.get(i).getColor()){
                case "Red":
                    r++;
                    break;
                case "Blue":
                    b++;
                    break;
                case "Green":
                    g++;
                    break;
                case "Yellow":
                    y++;
                    break;
                default:
                    break;
            }
        }

        if(r >= b && r >= g && r >= y){
            return "Red";
        } else if (b >= r && b >= g && b >= y){
            return "Blue";
        } else if (g >= b && g >= r && g >= y){
            return "Green";
        } else {
            return "Yellow";
        }
    }


}
