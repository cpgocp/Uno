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
            Card tmp;

            if(current.isAuto()){ // autobot section
                if(game.getAddCount() != 0 && !current.hasPlus()){
                    current.countAdd(game.getAddCount());
                    message += "Bot drew " + game.getAddCount() + "\n";
                    game.resetAddCount();
                }
                tmp = current.chooseCard(); // bot picks card + plays card
                if(tmp != null && !tmp.getColor().equals("Wild")){ // messages for autobot
                    message += "Bot played " + tmp + "\n";
                } else if (tmp != null && tmp.isWild()){
                    message += "Bot played a Wild" + tmp.getNum() + " as a " + tmp + "\n";
                } else {
                    message += "Bot drew a card";
                }
                if(game.getAddCount() != 0 && !((tmp.isWild() && tmp.getNum() == 4)||(tmp.getNum() == 11))){
                    current.countAdd(game.getAddCount());
                    message = "Bot drew " + game.getAddCount() + "\n" + message;
                    game.resetAddCount();
                }

                if(current.getHandSize() == 1){
                    message += "Bot Uno!\n";
                } else if (current.getHandSize() == 0){
                    message += "Bot Won!\n";
                    current.setWinner(true);
                }

                //auto printing section
                System.out.println(message);
                extraC = current.getHandSize() - 8; // start of printing auto's cards
                if(extraC>0){
                    System.out.print(" ## ## ## ## ## ## ## ## +" + extraC);
                } else {
                    for( int i = 0; i < current.getHandSize() ; i++) {
                        System.out.print(" ##");
                    }
                }
                System.out.print("\n");
                System.out.println(" ");
                System.out.println("          ##    " + game.getTop()); // draw and discard pile
                System.out.println(" ");
                System.out.print(" Dr "); //start printing player cards + number instructions
                extraO = other.getHandSize() - 7;
                message = "  1 ";
                if(extraO>0){
                    for(int i = 0; i < 7; i++){
                        System.out.print(other.getHand().get(i) + " ");
                        message += " " + (i + 2) + " ";
                    }
                    System.out.print("+" + extraO);
                    System.out.print(" Mo");
                    message += "  9  0";
                } else {
                    for(int i = 0; i < other.getHandSize(); i++){
                        System.out.print(other.getHand().get(i) + " ");
                        message += " " + (i + 2) + " ";
                    }

                }
                System.out.print("\n");
                message += "\n";
                System.out.print(message);
                System.out.println("Press Number-Key to play card or action:");
            } else { // player controled section
                int input = scanner.nextInt();
                String wildC = "";
                boolean move = false;
                while(!move) {
                    if (input == 1) {
                        current.getHand().add(game.drawDeck());
                        move = true;
                    } else if (current.getHandSize()+1 >= input && input >= 2) { //playing a card
                        tmp = current.playPosition(input - 2); //check if can play card
                        if (tmp != null && tmp.getColor().equals("Wild")) { //playing wild card
                            System.out.println(" Which color would you like to select?:");
                            System.out.println("   0: Red  1: Blue  2: Green  3: Yellow");
                            input = scanner.nextInt();
                            switch (input) {
                                case 0:
                                    wildC = "Red";
                                    break;
                                case 1:
                                    wildC = "Blue";
                                    break;
                                case 2:
                                    wildC = "Green";
                                    break;
                                case 3:
                                    wildC = "Yellow";
                                    break;
                            }
                            game.playCard(tmp, wildC);
                            move = true;
                        } else if(tmp != null) { //play color card
                            game.playCard(tmp, "");
                            move = true;
                        } else if (tmp == null){ //can't play card
                            System.out.println("That doesn't work, something else");
                        }
                    } else { //program the more button here...
                        System.out.println("Sorry, try something else");
                    }
                }
            }


        }

    }
}
