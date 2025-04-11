package edu.grinnell.csc207.lootgenerator;

import java.io.IOException;

import edu.grinnell.csc207.lootgenerator.GameDataStructures.MonsterData;

public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    private static final String DATA_SET = "data/small";
    
    public static void main(String[] args) throws IOException {
        System.out.println("This program kills monsters and generates loot!");
        MonsterData data = new MonsterData();
        System.out.println(data.getData().get(0).getMonsterClass());
        System.out.println(data.getSize());
    }
}
