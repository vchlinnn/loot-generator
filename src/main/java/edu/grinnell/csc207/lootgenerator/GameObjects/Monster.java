package edu.grinnell.csc207.lootgenerator.GameObjects;

public class Monster {
    private String monsterClass;
    private String treasureClass;

    public Monster(String monsterClass, String treasureClass){
        this.monsterClass = monsterClass;
        this.treasureClass = treasureClass;
    }

    public String getMonsterClass(){
        return monsterClass;
    }

    public String getTreasureClass() {
        return treasureClass;
    }
}
