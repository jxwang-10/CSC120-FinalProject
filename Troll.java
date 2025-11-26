import java.util.ArrayList;
import java.util.Hashtable;


public class Troll extends Boss{

    public Troll(){
        super();
        this.attackRequirement = 2;
        this.defenseRequirement = 2;
        this.recoveryRequirement = 2;
        this.intelligenceRequirement = 2;
        this.speedRequirement = 2;
        // update attacks
        this.bossAttacks = new ArrayList<>();
        // set up hashtable of user options and retaliations
    }

}
