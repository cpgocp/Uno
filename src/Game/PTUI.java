package Game;

import java.util.Scanner;

public class PTUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        int players = 2;

        while(!game.hasWinner()){
            if(game.getOrder().get((game.getTurn()%players)).isAuto()){
                game.getOrder().get((game.getTurn()%players)).chooseCard();
            } else {

            }
        }

    }
}
