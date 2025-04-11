package edu.grinnell.csc207.lootgenerator.GameObjects;

public class Armor {
    private String armor;
    private int minac;
    private int maxac;
    private boolean isBaseItem;

    public Armor(String armor, int minac, int maxac) {
        this.armor = armor;
        this.minac = minac;
        this.maxac = maxac;
    }

    public String getArmor() {
        return armor;
    }

    public int getDefenseValue() {
        return minac + (int)(Math.random() * ((maxac - minac) + 1));
    }

    public boolean isBaseItem() {
        return true;
    }
}
