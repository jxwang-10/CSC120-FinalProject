import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Character {

    int maxPoints;
    Hashtable<String,Integer> pointDistribution;
    int attack;
    int defense;
    int recovery;
    int intelligence;
    int speed;
    ArrayList<String> keys;
    ArrayList<String> charAttacks;

    /**
     * Constructor, sets default 0s for individual characteristics and 15 for default maxpoints
     */
    public Character(){
        this.maxPoints = 15;
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
        this.charAttacks = new ArrayList<>();
        this.charAttacks.add("Swing your sword");
        this.charAttacks.add("Cast a fire spell");
        this.charAttacks.add("Cast an ice spell");
        this.charAttacks.add("Cast a confusion spell");
        this.charAttacks.add("Cast a blinding spell");  
        this.charAttacks.add("Retreat a few paces");
        this.charAttacks.add("Try to dodge");
    }

    /**
     * Gets the point distribution
     * @return Hashtable<String,Integer> of the point distriubtion, where String/key is the characterisitc and the Integer/value is the amount that characteristic has
     */
    public Hashtable<String,Integer> getStats(){
        return this.pointDistribution;
    }

    /**
     * Prints the point distribution
     */
    public void viewStats(){
        System.out.println("Point Distribution:");
        for(int i = 0; i < keys.size(); i ++){
            System.out.println(keys.get(i)+": "+pointDistribution.get(keys.get(i)));
        }
    }

    /**
     * Gets the total number of points across stats
     * @return int, the total number of points currently in the distriubtion
     */
    public int getTotalPoints(){
        int total = 0;
        for(int i = 0; i < keys.size(); i ++){
            total = total + pointDistribution.get(keys.get(i));
        }
        return total;
    }

    // Setting individual stats

    /**
     * Assigns an amount to an individual characteristic
     * @param characteristic the characteristic to update in the point distribution
     * @param newAmnt the new amount for the characteristic
     */
    public void setStat(String characteristic, int newAmnt){
        int total = this.getTotalPoints();
        int currentAmnt = pointDistribution.get(characteristic);
        if((total - currentAmnt + newAmnt) <= this.maxPoints){
            this.pointDistribution.replace(characteristic, newAmnt);
        }else{
            System.out.println("You do not have enough points. Try assigning a different number of points to this characteristic.");
        }
    }

    // Setting all stats

    /**
     * Interacts with user through terminal to set point distribution
     */
    public void userSetStats(){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.println("What stat would you like to change?");
            String changingChar = input.nextLine();
            boolean charExists = false;
            for(int i = 0; i < keys.size(); i ++){
                String realChar = keys.get(i);
                if(realChar.equals(changingChar)){
                    charExists = true;
                    break;
                }
            }
            if(charExists == false){
                System.out.println("Characteristic does not exist.");
                break;
            }
            System.out.println("What would you like to change "+changingChar+" to?");
            int changingAmnt = input.nextInt(); // could more gracefullly catch exception here
            input.nextLine();
            this.setStat(changingChar, changingAmnt);
            System.out.println("Updated Stats:");
            this.viewStats();
            System.out.println("Would you like to set more stats? Type N for no and Y for yes");
            String keepOn = input.nextLine();
            if(keepOn.equalsIgnoreCase("N")){
                System.out.println("Okay, done changing stats");
                input.close();
                break;
            }else if(keepOn.equalsIgnoreCase("Y")){
                continue;
            }else{
                break;
            }
        }
    }

    public static void main(String[] args) {
        Character legend = new Character();
        legend.viewStats();
        System.out.println(legend.getTotalPoints());
        System.out.println(legend.maxPoints);
      //  legend.maxPoints = 14;
     //   legend.setAttack(15);
        legend.setStat("Attack", 15);
        System.out.println("("+legend.getTotalPoints()+"-"+legend.pointDistribution.get("Attack")+"+"+15+")>"+legend.maxPoints);
        legend.viewStats();

        legend.userSetStats();

        // make stats an enum?
    }
}
