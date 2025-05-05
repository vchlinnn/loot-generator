package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * class ArmorData
 * This class is responsible for reading and storing armor data from a file
 */
public class ArmorData {
    private Map<String, Integer> armorData;
    
    /**
     * Constructor for the ArmorData class
     * 
     * @param dataSet the path to the dataset
     * @throws IOException if there is an error reading the data file
     */
    public ArmorData(String dataSet) throws IOException {
        this.armorData = new HashMap<>();
        Scanner text = new Scanner(new File(dataSet + "/armor.txt"));
        while (text.hasNextLine()) {
            Random random = new Random();
            String line = text.nextLine();
            String[] words = line.split("\t");
            String armorName = words[0];
            int minac = Integer.parseInt(words[1]);
            int maxac = Integer.parseInt(words[2]);
            int baseStats = random.nextInt(minac, maxac + 1);
            armorData.put(armorName, baseStats);
        }
        text.close();
    }

    /**
     * Get the base stats based on the armor name
     * 
     * @param armorName the name of the armor
     * @return the base stats of the armor
     */
    public int getBaseStats(String armorName) { 
        return armorData.get(armorName);
    }
}
