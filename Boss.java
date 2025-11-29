import java.util.ArrayList;
import java.util.Enumeration;
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
    //ArrayList<String> playerAttacks;
    ArrayList<String> bossAttacks;
    boolean playerWin;
    String winRespo;
    String looseRespo;

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

    public void attack(Hashtable<String, String> retaliations){
        // go through every attack, ask user how to respond
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        for(int i = 0; i < this.bossAttacks.size(); i ++){
            int randomIndex = random.nextInt(this.bossAttacks.size());
            System.out.println(this.bossAttacks.get(randomIndex));            // prints attack
            System.out.println("How do you want to respond?"); // let user pick response
            Enumeration<String> e = retaliations.elements();
            while(e.hasMoreElements()){
                System.out.println(e.nextElement());
            }
            String response = input.nextLine();
            if(retaliations.containsKey(response)){             // if response exists
                System.out.println(retaliations.get(response)); // give default retaliation for that response
            }else{
                System.out.println("Response does not exist");
                break;
            }
            this.bossAttacks.remove(randomIndex);
        }
        if (this.playerWin){
            System.out.println("Congrats! You win!");
        } else{
            System.out.println("You lost :( Stats insufficent.");
        }
        input.close();
    }

    public static void main(String[] args) {
        Character legend = new Character();
        Boss goblin = new Boss();
        goblin.canWin(legend.getStats());
    }

}
