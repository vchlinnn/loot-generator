package edu.grinnell.csc207.lootgenerator.GameObjects;

public class Monster {
    private String monsterClass;
    private String treasureClass;

    /**
     * Constructor for the Monster class
     * 
     * @param monsterClass the name of the monster class
     * @param treasureClass the name of the treasure class
     */
    public Monster(String monsterClass, String treasureClass){
        this.monsterClass = monsterClass;
        this.treasureClass = treasureClass;
    }

    /**
     * Get the name of the monster class
     * 
     * @return the name of the monster class
     */
    public String getMonsterClass(){
        return monsterClass;
    }

    /**
     * Get the name of the treasure class
     * 
     * @return the name of the treasure class
     */
    public String getTreasureClass() {
        return treasureClass;
    }
}
