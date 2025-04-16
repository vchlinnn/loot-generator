package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TreasureClassData {
    private Map<String, String[]> treasureClassData;
    
    /**
     * Constructor for the TreasureClassData class
     * 
     * @param DATA_SET the path to the dataset
     * @throws IOException if there is an error reading the data file
     */
    public TreasureClassData(String DATA_SET) throws IOException {
        this.treasureClassData = new HashMap<>();
        Scanner text = new Scanner(new File(DATA_SET + "/TreasureClassEx.txt"));
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
    public String getTreasureDrop(String treasureClassName){ // Return a random drop
        Random random = new Random();
        String[] listDrops =  treasureClassData.get(treasureClassName);
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
