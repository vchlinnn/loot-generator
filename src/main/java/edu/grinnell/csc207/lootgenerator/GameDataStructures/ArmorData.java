package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class ArmorData {
    private Map<String, Integer> armorData;
    
    public ArmorData() throws IOException {
        this.armorData = new HashMap<>();
        Scanner text = new Scanner(new File("data/small/armor.txt"));
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

    public int getBaseStats(String armorName){ 
        return armorData.get(armorName);
    }
}
