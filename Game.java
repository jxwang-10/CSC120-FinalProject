import java.util.Hashtable;
import java.util.Scanner;

public class Game {

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
            boolean canWin = boss.canWin(character.getStats());
            boss.attack(character.charAttacks, input);
            boss.end(character.getStats());
            if(canWin == true){
                input.nextLine();
                break;
            }else if(canWin == false){
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
        Scanner input = new Scanner(System.in);
        Character character = new Character();
        Troll troll = new Troll();        
        this.bossLoop(troll, character, input);
        character.maxPoints = character.maxPoints + 2;
        Werewolf werewolf = new Werewolf();
        this.bossLoop(werewolf, character, input);
        character.maxPoints = character.maxPoints + 3;
        character.userSetStats(input);
        Dragon dragon = new Dragon();
        this.bossLoop(dragon, character, input);
        input.close();
    }
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
