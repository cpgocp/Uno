package Game;

public class Card {
    private String color;
    private int num;

    public Card (String c, int n){
        color = c;
        num = n;
    }

    public String getColor() {
        return color;
    }

    public int getNum() {
        return num;
    }
}
