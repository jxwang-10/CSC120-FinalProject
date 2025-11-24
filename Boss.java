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

    public void attack(){
        System.out.println("Booyah!");
    }

    public static void main(String[] args) {
        Character legend = new Character();
        Boss goblin = new Boss();
        boolean playerWin = goblin.canWin(legend.getStats());
        System.out.println(playerWin);
    }
}
