package edu.grinnell.csc207.lootgenerator;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import edu.grinnell.csc207.lootgenerator.GameDataStructures.ArmorData;
import edu.grinnell.csc207.lootgenerator.GameDataStructures.MonsterData;
import edu.grinnell.csc207.lootgenerator.GameDataStructures.AffixData;
import edu.grinnell.csc207.lootgenerator.GameDataStructures.TreasureClassData;

/**
 * This class generates loot based on the monster killed and the treasure class
 * it belongs to
 * 
 * @author Linh Vu
 */
public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    private static final String DATA_SET = "data/large";
    MonsterData monsterData;
    TreasureClassData treasureData;
    ArmorData armorData;
    AffixData prefixData;
    AffixData suffixData;
    int randIndex;
    Random random;
    Scanner scanner;

    /**
     * Constructor for the LootGenerator class
     * 
     * @throws IOException if there is an error reading the data files
     */
    public LootGenerator() throws IOException{
        this.monsterData = new MonsterData(DATA_SET);
        this.treasureData = new TreasureClassData(DATA_SET);
        this.armorData = new ArmorData(DATA_SET);
        this.prefixData = new AffixData(DATA_SET + "/MagicPrefix.txt");
        this.suffixData = new AffixData(DATA_SET + "/MagicSuffix.txt");
        this.random = new Random();
        this.randIndex = random.nextInt(monsterData.getSize());
        this.scanner = new Scanner(System.in);
    }

    /**
     * Main method to run the LootGenerator game
     * 
     * @param args command line arguments
     * @throws IOException if there is an error reading the data files
     */
    public static void main(String[] args) throws IOException {
        boolean playing = true;
        while (playing) {
            LootGenerator game = new LootGenerator();
            String monster = game.pickMonster();
            String treasureClassName = game.fetchTreasureClass();
            String baseItem = game.generateBaseItem(treasureClassName);
            int baseStats = game.generateBaseStats(baseItem);
            String[] result = game.generateAffix(baseItem);
            String fullName = result[0];
            String additionalStats = result[1];
            
            System.out.println("This program kills monsters and generates loot!");
            System.out.println("Fighting " + monster);
            System.out.println("You have slain " + monster);
            System.out.println(monster + " dropped:" + "\n");
            System.out.println(fullName);
            System.out.println("Defense: " + baseStats);
            System.out.print(additionalStats);
            String ans;
            do {
                System.out.print("Fight again [y/n]? ");
                ans = game.scanner.nextLine().trim().toLowerCase();
            } while (!ans.equals("y") && !ans.equals("n"));

            if (ans.equals("n")) {
                playing = false;
            }
        }
    }

    /**
     * Picks a random monster from the monster data
     * 
     * @return the name of the monster
     */
    public String pickMonster() {
        String monster = monsterData.getMonsterName(randIndex);
        return monster;
    }

    /**
     * Fetches the treasure class of the monster
     * 
     * @return the name of the treasure class
     */
    public String fetchTreasureClass() {
        String treasure = monsterData.getTreasureClassName(randIndex);
        return treasure;
    }

    /**
     * Generates a base item based on the treasure class
     * 
     * @param treasureClassName the name of the treasure class
     * @return the name of the base item
     */
    public String generateBaseItem(String treasureClassName){
        String item = treasureData.getTreasureDrop(treasureClassName);

        while (treasureData.isTreasureClass(item)) {
            item = treasureData.getTreasureDrop(item);
        }
        return item;
    }

    /**
     * Generates the base stats for the item
     * 
     * @param item the name of the item
     * @return the base stats of the item
     */
    public int generateBaseStats(String item) {
        return armorData.getBaseStats(item);
    }

    /**
     * Generates affixes for the item
     * 
     * @param baseItem the name of the base item
     * @return an array containing the full name of the item and additional stats
     */
    public String[] generateAffix(String baseItem){
        String additionalStats = "";
        if (random.nextInt(2) == 0) { // yes prefix
            // Prefix + baseitem
            int prefixRand = random.nextInt(prefixData.getSize());
            String prefix = prefixData.getAffix(prefixRand);
            baseItem = prefix + " " + baseItem;
            // Additional stats
            int value = prefixData.getValue(prefixRand);
            String stats = prefixData.getStatisticsText(prefixRand);
            additionalStats = value + " " + stats + "\n";
        }

        if (random.nextInt(2) == 0) { // yes suffix
            // Suffix + baseitem
            int suffixRand = random.nextInt(suffixData.getSize());
            String suffix = suffixData.getAffix(suffixRand);
            baseItem = baseItem + " " + suffix;
            // Additional stats
            int value = suffixData.getValue(suffixRand);
            String stats = suffixData.getStatisticsText(suffixRand);
            additionalStats = additionalStats + value + " " + stats + "\n";
        }

        return new String[] {baseItem, additionalStats};
    }

}
