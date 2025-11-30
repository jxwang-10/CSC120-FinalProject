import java.util.Hashtable;

public class Game {

    public Game(){
        Character character = new Character();
        Troll troll = new Troll(character.getStats());        
        this.bossLoop(troll, character);
        character.maxPoints = character.maxPoints + 2;
        Werewolf werewolf = new Werewolf(character.getStats());
        this.bossLoop(werewolf, character);
        character.maxPoints = character.maxPoints + 3;
        character.userSetStats();
        Dragon dragon = new Dragon(character.getStats());
        this.bossLoop(dragon, character);
    }

    public Character bossLoop(Boss boss, Character character){
        Hashtable<String,Integer> ogStats = character.getStats();
        while(true){
            character.userSetStats();
            // boss's intro
            boolean canWin = boss.canWin(character.getStats());
            boss.attack(character.charAttacks);
            boss.end(character.getStats());
            if(canWin == true){
                break;
            }else if(canWin == false){
                // print that user is redoing it
                character.pointDistribution = ogStats;
                continue;
            }
        }
        return character;
    }
    public static void main(String[] args) {
        Game game = new Game();
    }
}
