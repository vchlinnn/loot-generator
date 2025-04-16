package edu.grinnell.csc207.lootgenerator.GameObjects;

public class Armor {
    private String armor;
    private int minac;
    private int maxac;

    /**
     * Constructor for the Armor class
     * 
     * @param armor the name of the armor
     * @param minac the minimum armor class value
     * @param maxac the maximum armor class value
     */
    public Armor(String armor, int minac, int maxac) {
        this.armor = armor;
        this.minac = minac;
        this.maxac = maxac;
    }

    /**
     * Get the name of the armor
     * 
     * @return the name of the armor
     */
    public String getArmor() {
        return armor;
    }

    /**
     * Get the defense value of the armor
     * 
     * @return the randomly generated defense value between minac and maxac
     */
    public int getDefenseValue() {
        return minac + (int)(Math.random() * ((maxac - minac) + 1));
    }
}
