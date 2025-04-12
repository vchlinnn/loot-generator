package edu.grinnell.csc207.lootgenerator;

import java.io.IOException;
import java.util.Random;

import edu.grinnell.csc207.lootgenerator.GameDataStructures.ArmorData;
import edu.grinnell.csc207.lootgenerator.GameDataStructures.MonsterData;
import edu.grinnell.csc207.lootgenerator.GameDataStructures.TreasureClassData;

public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    private static final String DATA_SET = "data/small";
    MonsterData monsterData;
    TreasureClassData treasureData;
    ArmorData armorData;
    int randIndex;

    public LootGenerator() throws IOException{
        this.monsterData = new MonsterData();
        this.treasureData = new TreasureClassData();
        this.armorData = new ArmorData();
        Random random = new Random();
        this.randIndex = random.nextInt(monsterData.getSize());
    }
    
    public static void main(String[] args) throws IOException {
        LootGenerator game = new LootGenerator();
        String monster = game.pickMonster();
        String treasureClassName = game.fetchTreasureClass();
        String baseItem = game.generateBaseItem(treasureClassName);
        int baseStats = game.generateBaseStats(baseItem);
        
        System.out.println("This program kills monsters and generates loot!");
        System.out.println("Fighting " + monster);
        System.out.println("You have slain " + monster);
        System.out.println(monster + " dropped:");
        System.out.println("\n");
        System.out.println(baseItem);
        System.out.println("Defense: " + baseStats);
        // MonsterData data = new MonsterData();
        // System.out.println(data.getMonsterName(0)); // index is random
        // System.out.println(data.getTreasureClassName(0)); // index is random
        // System.out.println(data.getSize());
    }

    public String pickMonster() {
        String monster = monsterData.getMonsterName(randIndex);
        // System.out.println("pickMonster" + monster);
        return monster;
    }

    public String fetchTreasureClass() {
        String treasure = monsterData.getTreasureClassName(randIndex);
        // System.out.println("fetchTreausure" + treasure);
        return treasure;
    }

    public String generateBaseItem(String treasureClassName){
        String item = treasureData.getTreasureDrop(treasureClassName);

        while (treasureData.isTreasureClass(item)) {
            // System.out.println("inside loop: getting item" + item);
            item = treasureData.getTreasureDrop(item);
        }
        // System.out.println("exit loop: " + item);
        return item;
    }

    public int generateBaseStats(String item) {
        return armorData.getBaseStats(item);
    }

    // public String generateAffix(){

    // }

}
