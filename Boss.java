import java.util.ArrayList;
import java.util.Hashtable;

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

    public void attack(){
        System.out.println("Booyah!");
        if (this.playerWin){
            System.out.println("You Win!");
        } else{
            System.out.println("You Lose LOL");
        }
    }

    public static void main(String[] args) {
        Character legend = new Character();
        Boss goblin = new Boss();
        goblin.canWin(legend.getStats());
        goblin.attack();
    }

}
