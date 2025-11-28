import java.util.ArrayList;

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

}
}
