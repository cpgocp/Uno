package Game;

import java.util.ArrayList;

public class Player {
    private ArrayList<Card> Hand = new ArrayList<Card>();
    private boolean auto;
    private boolean winner;

    public Player(int initial){
        for (int i = 0; i < initial; i++){
            this.Hand.add(Game.drawDeck());

        }
        this.auto = true;
        this.winner = false;
    }

    public void setAuto(boolean t){
        this.auto = t;
    }

    public boolean isAuto() {
        return this.auto;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public boolean isWinner(){
        return this.winner;
    }

    public Card chooseCard(){
        for(int i = 0; i < this.Hand.size(); i++){
            if(!this.Hand.get(i).getColor().equals("Wild") && Game.getTop().getColor().equals(this.Hand.get(i).getColor())){
                Game.playCard(this.Hand.get(i), "");
                Card tmp = this.Hand.get(i);
                this.Hand.remove(i);
                return tmp;
            } else if (!this.Hand.get(i).getColor().equals("Wild") && Game.getTop().getNum() == this.Hand.get(i).getNum()){
                Game.playCard(this.Hand.get(i), "");
                Card tmp = this.Hand.get(i);
                this.Hand.remove(i);
                return tmp;
            } else if (this.Hand.get(i).getColor().equals("Wild")) {
                Game.playCard(this.Hand.get(i), mostColor());
                Card tmp = this.Hand.get(i);
                this.Hand.remove(i);
                return tmp;
            }
        }
        this.Hand.add(Game.drawDeck());
        return null;
    }

    public String mostColor(){
        int r = 0;
        int b = 0;
        int g = 0;
        int y = 0;
        for (int i = 0; i < this.Hand.size(); i++){
            switch(this.Hand.get(i).getColor()){
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
