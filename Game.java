import java.util.Hashtable;
import java.util.Scanner;

public class Game {

    // Attributes
    String intro = "\nWelcome to the arena!\nYou have three bosses to beat ...\nThe Troll ... \nThe Werewolf ...\nAnd ... THE DRAGON!\nYour character is composed of 5 attributes: Attack, Defense, Recovery, Intelligence, and Speed\nChoose your strengths and weaknesses wisely...\nType ^C to rage quit.";
    String close = "GG!\nCongrats on surviving!";

    /**
     * Constructor
     */
    public Game(){}

    /**
     * Runs a loop were character sets their stats before attacking a boss
     * @param boss the boss for teh character to fight
     * @param character the character to fight the boss
     * @param input Scanner object to get user input
     */
    public void bossLoop(Boss boss, Character character, Scanner input){
        Hashtable<String,Integer> ogStats = new Hashtable<>();
        for(int i = 0; i < character.keys.size(); i ++){
            String key = character.keys.get(i);
            ogStats.put(key,character.pointDistribution.get(key));
        }
        while(true){
            character.userSetStats(input);
            // boss's intro
            System.out.println(boss.intro);
            boss.attack(character.charAttacks, input, character.getStats());
            boss.end(character.getStats());
            if(boss.playerWin == true){
                input.nextLine();
                break;
            }else{
                // print that user is redoing it
                character.pointDistribution = ogStats;
                input.nextLine();
                continue;
            }
        }
    }

    /**
     * Runs game loop
     */
    public void play(){
        System.out.println(this.intro);
        Scanner input = new Scanner(System.in);
        Character character = new Character();
        Troll troll = new Troll();        
        this.bossLoop(troll, character, input);
        character.maxPoints = character.maxPoints + 2;
        System.out.println("Nice Job! You gained 2 points. Assign them now!");
        Werewolf werewolf = new Werewolf();
        this.bossLoop(werewolf, character, input);
        character.maxPoints = character.maxPoints + 3;
        System.out.println("Nice Job! You gained 3 points. Assign them now!");
        Dragon dragon = new Dragon();
        this.bossLoop(dragon, character, input);
        System.out.println(this.close);
        input.close();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
