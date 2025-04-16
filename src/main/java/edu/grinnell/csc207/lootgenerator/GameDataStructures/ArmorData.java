package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ArmorData {
    private Map<String, Integer> armorData;
    
    /**
     * Constructor for the ArmorData class
     * 
     * @param DATA_SET the path to the dataset
     * @throws IOException if there is an error reading the data file
     */
    public ArmorData(String DATA_SET) throws IOException {
        this.armorData = new HashMap<>();
        Scanner text = new Scanner(new File(DATA_SET + "/armor.txt"));
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
     * @return the base stats of the armor
     */
    public int getBaseStats(String armorName){ 
        return armorData.get(armorName);
    }
}
