package edu.grinnell.csc207.lootgenerator;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

import edu.grinnell.csc207.lootgenerator.GameDataStructures.ArmorData;
import edu.grinnell.csc207.lootgenerator.GameDataStructures.MonsterData;
import edu.grinnell.csc207.lootgenerator.GameDataStructures.AffixData;
import edu.grinnell.csc207.lootgenerator.GameDataStructures.TreasureClassData;

public class LootGenerator {
    /** The path to the dataset (either the small or large set). */
    private static final String DATA_SET = "data/small";
    MonsterData monsterData;
    TreasureClassData treasureData;
    ArmorData armorData;
    AffixData prefixData;
    AffixData suffixData;
    int randIndex;
    Random random;
    Scanner scanner;

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
            System.out.print("addStats " + additionalStats);
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

        System.out.println("addStats after prefix is " + additionalStats);
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
