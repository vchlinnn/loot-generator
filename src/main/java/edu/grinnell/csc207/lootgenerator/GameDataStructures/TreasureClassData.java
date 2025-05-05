package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * class TreasureClassData
 * This class is responsible for reading and storing treasure class data from a file
 */
public class TreasureClassData {
    private Map<String, String[]> treasureClassData;
    
    /**
     * Constructor for the TreasureClassData class
     * 
     * @param dataSet the path to the dataset
     * @throws IOException if there is an error reading the data file
     */
    public TreasureClassData(String dataSet) throws IOException {
        this.treasureClassData = new HashMap<>();
        Scanner text = new Scanner(new File(dataSet + "/TreasureClassEx.txt"));
        while (text.hasNextLine()) {
            String line = text.nextLine();
            String[] words = line.split("\t");
            String[] treasureDrops = {words[1], words[2], words[3]};
            String treasureClassName = words[0];
            treasureClassData.put(treasureClassName, treasureDrops);
        }
        text.close();
    }

    /**
     * Get a random treasure drop from the treasure class
     * 
     * @param treasureClassName the name of the treasure class
     * @return the treasure drop
     */
    public String getTreasureDrop(String treasureClassName) { // Return a random drop
        Random random = new Random();
        String[] listDrops = treasureClassData.get(treasureClassName);
        return listDrops[random.nextInt(3)];
    }

    /**
     * Return true if the item is a treasure class
     * 
     * @param item the name of the item
     * @return true if the item is a treasure class, false otherwise
     */
    public boolean isTreasureClass(String item) {
        return treasureClassData.containsKey(item);
    }

    
}
