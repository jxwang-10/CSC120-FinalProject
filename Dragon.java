import java.util.ArrayList;
import java.util.Hashtable;

public class Dragon extends Boss{

    /**
     * Constructor, sets requirements, boss attacks, and win response specific to Dragon
     */
    public Dragon(){
        super();
        this.attackRequirement = 2;
        this.defenseRequirement = 3;
        this.recoveryRequirement = 4;
        this.intelligenceRequirement = 2;
        this.speedRequirement = 4;
        // update attacks
        this.bossAttacks = new ArrayList<>();
        this.bossAttacks.add("The Dragon shoots fire at you!");
        this.bossAttacks.add("The Dragon shoots fire at you!");
        this.bossAttacks.add("The Dragon swipes its claws at you!");
        this.bossAttacks.add("The Dragon tries to bite you!");
        this.bossAttacks.add("The Dragon tries to crush you with a claw!");
        // win responses
        this.winRespo = "You beat Dragon!";
        this.intro = "\nThe arena dims ...\nYou look overhead...\nDragon has blocked the lights!\nQuick! Duck!";
    }
    
    /**
     * Sets ending message specific to how character lost to Dragon
     * @param charStats Hashtable<String,Integer> of the character's stats, where the key is the characteristic and the value is the amount of point for that characterisitic
     */
    public void setLoseRespo(Hashtable<String,Integer> charStats){
        int recovery = charStats.get("Recovery");
        int speed = charStats.get("Speed");
        this.loseRespo = "";
        if(recovery < this.recoveryRequirement){
            this.loseRespo = "\nYou failed from recover from Dragon's attacks.";
        }
        if(speed < this.speedRequirement){
            this.loseRespo = this.loseRespo+"\nYou were too slow. Dragon speed-biltzed you.";
        }
        this.loseRespo = this.loseRespo+"\nYou died. Redistribute your points and try again";
    }

    public static void main(String[] args) {
        Character sammy = new Character();
        sammy.setStat("Attack", 2);
        sammy.setStat("Defense", 3);
        sammy.setStat("Recovery",3);
        sammy.setStat("Intelligence", 2);
        sammy.setStat("Speed", 3);
        Dragon theRedDeath = new Dragon();        
      //  theRedDeath.attack();
        theRedDeath.end(sammy.getStats());
    }
}
