
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;
import java.util.Random;

public class Boss {
    //Attributes
    int attackRequirement;
    int defenseRequirement;
    int recoveryRequirement;
    int intelligenceRequirement;
    int speedRequirement;
    ArrayList<String> bossAttacks;
    boolean playerWin;
    String winRespo;
    String loseRespo;
    String intro;
    int drop;

    // Constructor

    /**
     * Constructor sets requirments equal to 0, creates empty ArrayList<> for bossAttacks, and sets playerWin as false
     */
    public Boss(){
        this.attackRequirement = 0;
        this.defenseRequirement = 0;
        this.recoveryRequirement = 0;
        this.intelligenceRequirement = 0;
        this.speedRequirement = 0;
        this.bossAttacks = new ArrayList<>();
        this.playerWin = false;
        this.intro = "";
    }

    /**
     * Compares character's stats and boss's requirements to determine if character can beat boss
     * @param charStats Hashtable<String,Integer> of the character's stats, where the key is the characteristic and the value is the amount of point for that characterisitic
     * @return boolean, if the character is capable of beating the boss
     */
    public boolean canWin(Hashtable<String,Integer> charStats){
        int attack = charStats.get("Attack");
        int defense = charStats.get("Defense");
        int recovery = charStats.get("Recovery");
        int intelligence = charStats.get("Intelligence");
        int speed = charStats.get("Speed");
        if(attack >= this.attackRequirement){
            if(defense >= this.defenseRequirement){
                if(recovery >= recoveryRequirement){
                    if(intelligence >= this.intelligenceRequirement){
                        if(speed >= this.speedRequirement){
                            this.playerWin = true;
                        }
                    }
                }

            }

        }
        return this.playerWin;
    }

    /**
     * Loops through every attack the boss has and gets a player retaliation for each one
     * @param retaliations ArrayList<String> of possible retaliations from the character fighting the boss
     * @param input Scanner object to get user input
     * @param charStats Hashtable<String,Integer> of the character's stats, where the key is the characteristic and the value is the amount of point for that characterisitic
     */
    public void attack(ArrayList<String> retaliations, Scanner input, Hashtable<String,Integer> charStats){
        this.canWin(charStats);
        System.out.println();
        System.out.println("Starting fight.");
        // go through every attack, ask user how to respond
        Random random = new Random();
        int rounds = this.bossAttacks.size();
        // create new attack list
        ArrayList<String> attacks = new ArrayList<>();
        for(int i = 0; i < rounds; i ++){
            attacks.add(this.bossAttacks.get(i));
        }
        for(int i = 0; i < rounds; i ++){
            int randomIndex = random.nextInt(attacks.size());
            System.out.println(attacks.get(randomIndex));            // prints attack
            System.out.println("How do you want to respond? (Enter Integer)"); // let user pick response
            

            for(int j = 0; j < retaliations.size(); j ++){ // Print and display attacks and their indexes
                System.out.println(j+1 + ":"
                               + "\t"
                               + retaliations.get(j));
            }
            int response;
            try{
                response = input.nextInt()-1;
            }catch(RuntimeException e){  
                response = retaliations.size() + 1;
            }

            if(response > retaliations.size()-1){ // if response does not exist
                System.out.println("Response does not exist. You stand there awkwardly.");
                this.playerWin = false; // auto lose
                break;
            
            }else if (response <= retaliations.size()-1){
                System.out.println("You " + retaliations.get(response).toLowerCase() + "."); // give default retaliation for that response
            }
            attacks.remove(randomIndex);
        }
    }

    /**
     * Gives the ending response to let the player know if they won or lost
     * @param charStats Hashtable<String,Integer> of the character's stats, where the key is the characteristic and the value is the amount of point for that characterisitic
     */
    public void end(Hashtable<String,Integer> charStats){
        this.setLoseRespo(charStats);
        if (this.playerWin){
            System.out.println(this.winRespo);
        }else{
            System.out.println(this.loseRespo);
        }
    }
    
    /**
     * Sets the ending message if the character loses so that it gives hints to that stats the character needs to change
     * @param charStats Hashtable<String,Integer> of the character's stats, where the key is the characteristic and the value is the amount of point for that characterisitic
     */
    public void setLoseRespo(Hashtable<String,Integer> charStats){}

    public static void main(String[] args) {}

}
