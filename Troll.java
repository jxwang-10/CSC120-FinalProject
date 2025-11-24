import java.util.ArrayList;
import java.util.Hashtable;


public class Troll extends Boss{

    ArrayList<String> attacks;
    Hashtable<String, String> retaliations;

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

    public void attack(){
        // go through every attack, ask user how to respond
        // let user pick response
        // give default retaliation for that response
        // you win or you loose (hints)
    }
}
