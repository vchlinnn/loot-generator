package edu.grinnell.csc207.lootgenerator.GameObjects;

public class TreasureClass {
    private String treasureClass;
    private String[] drops;

    public TreasureClass(String treasureClass){
        this.treasureClass = treasureClass;
        this.drops = new String[3];
    }

    public String getTreasureClass(){
        return treasureClass;
    }

    public String[] getDrops(){
        return drops;
    }
}
