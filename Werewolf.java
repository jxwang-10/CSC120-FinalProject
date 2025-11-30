import java.util.ArrayList;
import java.util.Hashtable;

public class Werewolf extends Boss{
    
    public Werewolf(Hashtable<String,Integer> charStats){
        super();
        this.attackRequirement = 2;
        this.defenseRequirement = 3;
        this.recoveryRequirement = 2;
        this.intelligenceRequirement = 2;
        this.speedRequirement = 3;
        // update attacks
        this.bossAttacks = new ArrayList<>();
        this.bossAttacks.add("The Werewolf lunges at you, teeth bared!");
        this.bossAttacks.add("The Werewolf howls to harness the power of the moon!");
        this.bossAttacks.add("The Werewolf claws at you!");
        this.bossAttacks.add("The Werewolf jumps at you!");
        // win responses
        this.winRespo = "You beat the Werewolf!";
        // lose responses
        this.setLoseRespo(charStats);
    }

    public void setLoseRespo(Hashtable<String,Integer> charStats){
        int defense = charStats.get("Defense");
        int speed = charStats.get("Speed");
        this.loseRespo = "";
        if(defense < this.defenseRequirement){
            this.loseRespo = this.loseRespo + "\nYour shield broke under Werewolf's claws.";
        }
        if(speed < this.speedRequirement){
            this.loseRespo = this.loseRespo + "\nWerewolf bit you in the heart and you were to slow to avoid it.";
        }
        this.loseRespo = this.loseRespo+"\nYou died.";
    }

}
