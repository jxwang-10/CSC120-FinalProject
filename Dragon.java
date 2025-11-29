import java.util.ArrayList;
import java.util.Hashtable;

public class Dragon extends Boss{

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
        // loose responses

    }

    public void setLooseRespo(Hashtable<String,Integer> charStats){
        int recovery = charStats.get("Recovery");
        int speed = charStats.get("Speed");
        this.looseRespo = "";
        if(recovery < this.recoveryRequirement){
            this.looseRespo = "You failed from recover from Dragon's attacks.";
        }
        if(speed < this.speedRequirement){
            this.looseRespo = this.looseRespo+" You failed were too slow. Dragon speed-biltzed you.";
        }
        this.looseRespo = this.looseRespo+" You died.";
    }
}
