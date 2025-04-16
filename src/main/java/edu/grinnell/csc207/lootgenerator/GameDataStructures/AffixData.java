package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.grinnell.csc207.lootgenerator.GameObjects.Affix;

import java.io.File;
import java.io.IOException;

public class AffixData {
    private List<Affix> affixData;
    private int size;
    
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

    public String getAffix(int index){
        return affixData.get(index).getAffix();
    }

    public String getStatisticsText(int index){
        return affixData.get(index).getStatisticText();
    }
    
    public int getValue(int index){
        return affixData.get(index).getValue();
    }

    public int getSize(){
        return size;
    }
}
