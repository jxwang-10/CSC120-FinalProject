import java.util.ArrayList;
import java.util.Scanner;

public class Game {

    // Attributes
    private String intro = "\nWelcome to the arena!\nYou have three bosses to beat ...\nThe Troll ... \nThe Werewolf ...\nAnd ... THE DRAGON!\nYour character is composed of 5 attributes: Attack, Defense, Recovery, Intelligence, and Speed\nChoose your strengths and weaknesses wisely...\nType ^C to rage quit.";
    private String close = "GG!\nCongrats on surviving!";
    private ArrayList<Boss> bosses; // bosses to beat in this game

    /**
     * Constructor
     */
    Game(){
        // create the list of bosses that will need to be beaten to win the game
        this.bosses = new ArrayList<>();
        Troll troll = new Troll();   
        Werewolf werewolf = new Werewolf();
        Dragon dragon = new Dragon();
        this.bosses.add(troll);
        this.bosses.add(werewolf);
        this.bosses.add(dragon);
    }

    /**
     * Runs a loop were character sets their stats before attacking a boss
     * @param boss the boss for teh character to fight
     * @param character the character to fight the boss
     * @param input Scanner object to get user input
     */
    private void bossLoop(Boss boss, Character character, Scanner input){
        while(true){
            // boss's intro
            System.out.println(boss.getIntro());
            character.userSetStats(input);
            boss.attack(character.getCharAttacks(), input, character.getStats()); // battle start
            boss.end(character.getStats()); // print ending hints
            if(boss.getPlayerWin() == true){
                input.nextLine();
                break;
            }else{
                // print that user is redoing it
                input.nextLine();
                continue;
            }
        }
    }

    /**
     * Runs game loop
     */
    private void play(Scanner input){
        Character character = new Character(); //make new character
        for(int i = 0; i < this.bosses.size(); i ++){
            Boss boss = this.bosses.get(i);
            this.bossLoop(boss, character, input);
            character.setMaxPoints(character.getMaxPoints() + boss.getDrop());
            if(boss.getDrop() > 0){
                System.out.println("\nNice Job! You gained "+boss.getDrop()+" points Assign them now!");
            }
        }
        System.out.println(this.close);
    }
    public static void main(String[] args) {
        boolean stillPlaying = true; // flag for the do-while loop
        Game game = new Game();
        System.out.println(game.intro);
        Scanner input = new Scanner(System.in);
        do{
            game.play(input);
            System.out.println("To keep playing press 1. To quit game type your victory cry.");
            int userContinue;
            try{
                userContinue = input.nextInt();
            }catch(RuntimeException e){ // if the user types anything else besides a 1
                userContinue = 2; // then the user will not continue
            }
            if(userContinue == 1){
                input.nextLine();
                stillPlaying = true; // the loop continues
            }else{
                stillPlaying = false; // the loop breaks
            }
        }while(stillPlaying);
        // clean up
        input.close();
    }
}
