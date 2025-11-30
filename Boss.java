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

    // Constructor
    public Boss(){
        this.attackRequirement = 0;
        this.defenseRequirement = 0;
        this.recoveryRequirement = 0;
        this.intelligenceRequirement = 0;
        this.speedRequirement = 0;
        this.bossAttacks = new ArrayList<>();
        this.playerWin = false;
    }

    public void canWin(Hashtable<String,Integer> charStats){
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
    }

    public void attack(ArrayList<String> retaliations){
        // go through every attack, ask user how to respond
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int rounds = this.bossAttacks.size();
        for(int i = 0; i < rounds; i ++){
            int randomIndex = random.nextInt(this.bossAttacks.size());
            System.out.println(this.bossAttacks.get(randomIndex));            // prints attack
            System.out.println("How do you want to respond?"); // let user pick response
            

            for(int j = 0; j < retaliations.size(); j ++){ // Print and display attacks and their indexes
                System.out.println(j+1 + ":"
                               + "\t"
                               + retaliations.get(j));
            }
            int response = input.nextInt();
            if(response > retaliations.size()){ // if response exists
                System.out.println("Response does not exist. You stand there awkwardly.");
                this.playerWin = false; // auto lose
                break;
            }else{
                System.out.println(retaliations.get(response)); // give default retaliation for that response
            }
            this.bossAttacks.remove(randomIndex);
        }
        input.close();
    }

    public void end(Hashtable<String,Integer> charStats){
        this.canWin(charStats);
        if (this.playerWin){
            System.out.println(this.winRespo);
        } else{
            System.out.println(this.loseRespo);
        }
    }

    public static void main(String[] args) {
        Character legend = new Character();
        Boss dragon = new Dragon();
       
        dragon.canWin(legend.getStats());
        dragon.attack(legend.charAttacks);
       // dragon.end();
    }

}
