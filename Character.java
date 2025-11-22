import java.util.ArrayList;
import java.util.Hashtable;

public class Character {

    int totalPoints;
    Hashtable<String,Integer> pointDistribution;
    int attack;
    int defense;
    int recovery;
    int intelligence;
    int speed;
    ArrayList<String> keys;
    
    public Character(){
        this.totalPoints = 15;
        this.pointDistribution = new Hashtable<>();
        pointDistribution.put("Attack", 0);
        pointDistribution.put("Defense", 0);
        pointDistribution.put("Recovery", 0);
        pointDistribution.put("Intelligence", 0);
        pointDistribution.put("Speed", 0);
        this.keys = new ArrayList<String>();
        keys.add("Attack");
        keys.add("Defense");
        keys.add("Recovery");
        keys.add("Intelligence");
        keys.add("Speed");
    }

    public Hashtable<String,Integer> getStats(){
        return this.pointDistribution;
    }

    public void viewStats(){
        System.out.println("\nPoint Distribution:");
        for(int i = 0; i < keys.size(); i ++){
            System.out.println(keys.get(i)+": "+pointDistribution.get(keys.get(i)));
        }
    }

    // Setting individual stats

    // private void setAttackPower(){}

    // private void setDefense(){}
    
    // private void setRecovery(){}

    // private void setIntelligence(){}

    // private void setSpeed(){}

    // Setting all stats

    public void setStats(int attackPower, int defense, int recovery, int speed){
        
    }

    public static void main(String[] args) {
        // Character legend = new Character();
        // legend.viewStats();
    }
