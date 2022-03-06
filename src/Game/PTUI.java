package Game;

import java.util.Scanner;

public class PTUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        int players = 2;
        String message = "";

        while(!game.hasWinner()){
            if(game.getOrder().get((game.getTurn()%players)).isAuto()){
                Card tmp = game.getOrder().get((game.getTurn()%players)).chooseCard();
                if(tmp != null && !tmp.getColor().equals("Wild")){
                    message = "Bot played " + tmp.toString();
                } else if (tmp != null && tmp.getColor().equals("Wild")){
                    message = "Both played a Wild" + tmp.getNum() + " as a ";
                }
            } else {

            }

            System.out.println();
        }

    }
}
