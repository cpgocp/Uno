package Game;

import java.util.Scanner;

public class PTUI {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Game game = new Game();
        int players = 2;
        Player current;
        Player other;
        String message = "";
        int extraC;
        int extraO;

        while(!game.hasWinner()){
            message = "";

            current = game.getOrder().get((game.getTurn()%players));
            other = game.getOrder().get(((game.getTurn() + 1)%players));

            Card last = game.getTop();

            if(current.isAuto()){
                if(game.getAddCount() != 0 && !current.hasPlus()){
                    current.countAdd(game.getAddCount());
                    message += "Bot drew " + game.getAddCount() + "\n";
                    game.resetAddCount();
                }
                Card tmp = current.chooseCard();
                if(tmp != null && !tmp.getColor().equals("Wild")){
                    message += "Bot played " + tmp + "\n";
                } else if (tmp != null && tmp.isWild()){
                    message += "Both played a Wild" + tmp.getNum() + " as a " + tmp + "\n";
                }
                if(game.getAddCount() != 0 && !((tmp.isWild() && tmp.getNum() == 4)||(tmp.getNum() == 11))){
                    current.countAdd(game.getAddCount());
                    message = "Bot drew " + game.getAddCount() + "\n" + message;
                    game.resetAddCount();
                }

                System.out.println(message);
                extraC = current.getHandSize() - 8;
                if(extraC>0){
                    System.out.print(" ## ## ## ## ## ## ## ## +" + extraC);
                } else {
                    for( int i = 0; i < current.getHandSize() ; i++) {
                        System.out.print(" ##");
                    }
                }
                System.out.print("\n");
                System.out.println(" ");
                System.out.println("          ##    " + game.getTop());
                System.out.println(" ");
                System.out.print(" Dr ");
                extraO = other.getHandSize() - 7;
                if(extraO>0){
                    System.out.print("## ## ## ## ## ## ## +" + extraO);
                    System.out.print(" Mo");
                } else {
                    for(int i = 0; i < 7; i++){
                        System.out.print(other.getHand().get(i) + " ");
                    }
                }

            } else {

            }


        }

    }
}
