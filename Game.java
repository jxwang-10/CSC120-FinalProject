import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Game {

    // Attributes
    String intro = "\nWelcome to the arena!\nYou have three bosses to beat ...\nThe Troll ... \nThe Werewolf ...\nAnd ... THE DRAGON!\nYour character is composed of 5 attributes: Attack, Defense, Recovery, Intelligence, and Speed\nChoose your strengths and weaknesses wisely...\nType ^C to rage quit.";
    String close = "GG!\nCongrats on surviving!";
    ArrayList<Boss> bosses;

    /**
     * Constructor
     */
    public Game(){
        this.bosses = new ArrayList<>();
    }

    /**
     * Runs a loop were character sets their stats before attacking a boss
     * @param boss the boss for teh character to fight
     * @param character the character to fight the boss
     * @param input Scanner object to get user input
     */
    public void bossLoop(Boss boss, Character character, Scanner input){
        while(true){
            character.userSetStats(input);
            // boss's intro
            System.out.println(boss.intro);
            boss.attack(character.charAttacks, input, character.getStats()); // battle start
            boss.end(character.getStats()); // print ending hints
            if(boss.playerWin == true){
                input.nextLine();
                break;
            }else{
                // print that user is redoing it
                input.nextLine();
                continue;
            }
        }
    }

    public void makeBosses(){
        Troll troll = new Troll();   
        Werewolf werewolf = new Werewolf();
        Dragon dragon = new Dragon();
        this.bosses.add(troll);
        this.bosses.add(werewolf);
        this.bosses.add(dragon);
    }

    /**
     * Runs game loop
     */
    public void play(){
        System.out.println(this.intro);
        Scanner input = new Scanner(System.in);
        Character character = new Character(); //make new character
        this.makeBosses();
        for(int i = 0; i < this.bosses.size(); i ++){
            Boss boss = this.bosses.get(i);
            this.bossLoop(boss, character, input);
            character.maxPoints = character.maxPoints + boss.drop;
            System.out.println("Nice Job! You gained \boss.drop points. Assign them now!");
        }
        System.out.println(this.close);
        input.close();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
