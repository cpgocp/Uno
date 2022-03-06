package Game;

public class Card {
    private String color;
    private int num;
    private boolean wild = false;

    public Card (int c, int n){
        switch(c){
            case 0:
                color = "Red";
                break;
            case 1:
                color = "Blue";
                break;
            case 2:
                color = "Green";
                break;
            case 3:
                color = "Yellow";
                break;
            case 4:
                color = "Wild";
                wild = true;
                break;
        }
        num = n;
    }

    public String getColor() {
        return this.color;
    }

    public int getNum() {
        return this.num;
    }

    public boolean isWild() {
        return this.wild;
    }

    public String toString(){
        if(this.num == 10){
            return this.color.substring(0,1) + "S";
        } else if (this.num == 11){
            return this.color.substring(0,1) + "+2";
        } else if (this.num == 12){
            return this.color.substring(0,1) + "R";
        } else if (wild && this.num == 4){
            return this.color.substring(0,1) + "+4";
        } else {
            return this.color.substring(0, 1) + this.num;
        }
    }
}
