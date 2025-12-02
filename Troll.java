import java.util.ArrayList;
import java.util.Hashtable;


public class Troll extends Boss{

    /**
     * Constructor, sets requirements, boss attacks, and win response specific to Troll
     */
    public Troll(){
        super();
        this.attackRequirement = 2;
        this.defenseRequirement = 2;
        this.recoveryRequirement = 2;
        this.intelligenceRequirement = 2;
        this.speedRequirement = 2;
        // update attacks
        this.bossAttacks = new ArrayList<>();
        this.bossAttacks.add("The Troll stomps on you!");
        this.bossAttacks.add("The Troll punches you!");
        this.bossAttacks.add("The Troll blows its nasty breath in your face!");
        // win responses
        this.winRespo = "You beat the Troll!";
        this.intro = "\nEw! Whats the smell?\nHere comes the Troll!\nLook out!";
    }

    /**
     * Sets ending message specific to how character lost to Troll
     * @param charStats Hashtable<String,Integer> of the character's stats, where the key is the characteristic and the value is the amount of point for that characterisitic
     */
    public void setLoseRespo(Hashtable<String,Integer> charStats){
        int attack = charStats.get("Attack");
        int defense = charStats.get("Defense");
        int recovery = charStats.get("Recovery");
        int intelligence = charStats.get("Intelligence");
        int speed = charStats.get("Speed");
        this.loseRespo = "";
        if(attack < this.attackRequirement){
            this.loseRespo = this.loseRespo + "\nTroll dodged your attacks.";
        }
        if(defense < this.defenseRequirement){
            this.loseRespo = this.loseRespo + "\nTroll threw a punch you were unable to defend.";
        }
        if(recovery < this.recoveryRequirement){
            this.loseRespo = this.loseRespo + "\nYou were unable to recover from Troll's attacks.";
        }
        if(intelligence < this.intelligenceRequirement){
            this.loseRespo = this.loseRespo + "\nYou couldn't think of a way to dodge Troll's attacks.";
        }
        if(speed < this.speedRequirement){
            this.loseRespo = this.loseRespo + "\nTroll kicked you becuase you were too slow to evade it.";
        }
        this.loseRespo = this.loseRespo+"\nYou died. Redistribute your points and try again.";
    }

}
