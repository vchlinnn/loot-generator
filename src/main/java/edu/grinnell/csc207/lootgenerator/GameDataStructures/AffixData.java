package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.grinnell.csc207.lootgenerator.GameObjects.Affix;

import java.io.File;
import java.io.IOException;

/**
 * class AffixData
 * This class is responsible for reading and storing affix data from a file
 */
public class AffixData {
    private List<Affix> affixData;
    private int size;
    
    /**
     * Constructor for the AffixData class
     * 
     * @param dataPath the path to the affix data file
     * @throws IOException if there is an error reading the data file
     */
    public AffixData(String dataPath) throws IOException {
        this.affixData = new ArrayList<>();
        this.size = 0;
        Scanner text = new Scanner(new File(dataPath));
        while (text.hasNextLine()) {
            String line = text.nextLine();
            String[] words = line.split("\t");
            Affix affix = new Affix(words[0], words[1], 
                                        Integer.parseInt(words[2]), 
                                        Integer.parseInt(words[3]));
            affixData.add(affix);
            size += 1;
        }
        text.close();
    }

    /**
     * Get the affix name at the specified index
     * 
     * @param index the index of the affix
     * @return the affix name
     */
    public String getAffix(int index) {
        return affixData.get(index).getAffix();
    }

    /**
     * Get the statistic text associated with the affix at the specified index
     * 
     * @param index the index of the affix
     * @return the statistic text
     */
    public String getStatisticsText(int index) {
        return affixData.get(index).getStatisticText();
    }
    
    /**
     * Get the random value of the affix at the specified index
     * 
     * @param index the index of the affix
     * @return the random value
     */
    public int getValue(int index) {
        return affixData.get(index).getValue();
    }

    /**
     * Get the size of the affix data
     * 
     * @return the size of the affix data
     */
    public int getSize() {
        return size;
    }
}
