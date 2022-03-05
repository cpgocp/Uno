package Game;

public class Card {
    private String color;
    private int num;

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
                break;
        }
        num = n;
    }

    public String getColor() {
        return color;
    }

    public Character getLetter() {
        return color.charAt(0);
    }

    public int getNum() {
        return num;
    }
}
