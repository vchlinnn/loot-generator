package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class TreasureClassData {
    private Map<String, String[]> treasureClassData;
    
    public TreasureClassData() throws IOException {
        this.treasureClassData = new HashMap<>();
        Scanner text = new Scanner(new File("data/small/TreasureClassEx.txt"));
        while (text.hasNextLine()) {
            String line = text.nextLine();
            String[] words = line.split("\t");
            String[] treasureDrops = {words[1], words[2], words[3]};
            String treasureClassName = words[0];
            treasureClassData.put(treasureClassName, treasureDrops);
        }
        text.close();
    }

    public String getTreasureDrop(String treasureClassName){
        Random random = new Random();
        String[] listDrops =  treasureClassData.get(treasureClassName);
        return listDrops[random.nextInt(3)];
    }

}
