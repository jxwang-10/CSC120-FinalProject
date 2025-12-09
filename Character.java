import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Character {

    private int maxPoints;
    private Hashtable<String,Integer> pointDistribution;
    private ArrayList<String> keys;
    private ArrayList<String> charAttacks;

    /**
     * Constructor, sets default 0s for individual characteristics and 15 for default maxpoints
     */
    public Character(){
        this.maxPoints = 10;
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

    //getters

    /**
     * Gets the point distribution
     * @return Hashtable<String,Integer> of the point distriubtion, where String/key is the characterisitc and the Integer/value is the amount that characteristic has
     */
    public Hashtable<String,Integer> getStats(){
        return this.pointDistribution;
    }
    
    /**
     * gets the list of Attacks 
     * @return ArrayList<String> of each attack the character can do.
     */
    public ArrayList<String> getCharAttacks(){
        return this.charAttacks;
    }

    /**
     * gets the max points you can distribute
     * @return int the total number of points you can use
     */
    public int getMaxPoints(){
        return this.maxPoints;
    }
    
    // setters
    /**
     * Sets the max points
     * @param maxPoints maximum character points
     */
    public void setMaxPoints(int maxPoints){
        this.maxPoints = maxPoints;
    }

    /**
     * Prints the point distribution
     */
    private void viewStats(){
        System.out.println("\nPoint Distribution:");
        for(int i = 0; i < keys.size(); i ++){
            System.out.println(keys.get(i)+": "+pointDistribution.get(keys.get(i)));
        }
    }

    /**
     * Gets the total number of points across stats
     * @return int, the total number of points currently in the distriubtion
     */
    private int getTotalPoints(){
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
    private void setStat(String characteristic, int newAmnt){
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
     * Gets the characteristic from the user that they want to update, to be used when they are chaning stats
     * @param input Scanner object to get user input
     * @return String, the name of the characterisic the user wants to change
     */
    private String getChar(Scanner input){
        while(true){
            int pointsLeft = maxPoints - getTotalPoints();
            System.out.println("\nYou have "+pointsLeft+" out of "+maxPoints+" points left to use");
            System.out.println("What stat would you like to change?\nType Attack, Defense, Recovery, Intelligence, or Speed.");
            String changingChar = input.nextLine();
            boolean charExists = false;
            for(int i = 0; i < keys.size(); i ++){
                String realChar = keys.get(i);
                if(realChar.equals(changingChar)){
                    charExists = true;
                    return changingChar;
                }
            }
            if(charExists == false){
                System.out.println("Characteristic does not exist.");
            }
        }
    }

    /**
     * Gets the amount of points the user wants to assign to the characterisitc
     * @param input Scanner object to get user input
     * @param changingChar String, characteristic to be changed
     * @return int, the amount of points to assign to the characteristic
     */
    private int getChangingAmnt(Scanner input, String changingChar){
        System.out.println("What would you like to change "+changingChar+" to?");
        while(true){
            try{
                int changingAmnt = input.nextInt(); 
                return changingAmnt;
            }catch(RuntimeException e){
                int changingAmnt = 0;
                System.out.println("Type an integer.");
                return changingAmnt;
            }
        }
    }


    /**
     * Interacts with user through terminal to set point distribution
     * @param input Scanner object to get user input
     */
    public void userSetStats(Scanner input){
        while(true){
            this.viewStats();
            String changingChar = this.getChar(input);
            int changingAmnt = this.getChangingAmnt(input, changingChar);
            this.setStat(changingChar, changingAmnt);
            input.nextLine();
            System.out.println("Would you like to set more stats? If yes, type Y. If no, type your favorite battle cry.");
            String keepOn = input.nextLine();
            if(keepOn.equalsIgnoreCase("N")){
                System.out.println("\nOkay, done changing stats");
                break;
            }else if(keepOn.equalsIgnoreCase("Y")){
                continue;
            }else{
                break;
            }
        }
    }
}
