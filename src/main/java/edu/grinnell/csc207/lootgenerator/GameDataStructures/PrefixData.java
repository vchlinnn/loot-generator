package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.grinnell.csc207.lootgenerator.GameObjects.Prefix;

import java.io.File;
import java.io.IOException;
public class PrefixData {
    private List<Prefix> prefixData;
    private int size;
    
    public PrefixData(String DATA_SET) throws IOException {
        this.prefixData = new ArrayList<>();
        Scanner text = new Scanner(new File(DATA_SET + "/MagicPrefix.txt"));
        while (text.hasNextLine()) {
            String line = text.nextLine();
            String[] words = line.split("\t");
            Prefix prefix = new Prefix(words[0], words[1], 
                                        Integer.parseInt(words[2]), 
                                        Integer.parseInt(words[3]));
            prefixData.add(prefix);
            size += 1;
        }
        text.close();
    }

    public String getPrefix(int index){
        return prefixData.get(index).getPrefix();
    }

    public String getStatisticsText(int index){
        return prefixData.get(index).getStatisticText();
    }
    
    public int getValue(int index){
        return prefixData.get(index).getValue();
    }

    public int getSize(){
        return size;
    }
}
