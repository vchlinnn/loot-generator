package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import edu.grinnell.csc207.lootgenerator.GameObjects.Monster;

/**
 * class MonsterData
 * This class is responsible for reading and storing monster data from a file
 */
public class MonsterData {
    private List<Monster> monsterData;
    private int size;
    
    /**
     * Constructor for the MonsterData class
     * 
     * @param dataSet the path to the dataset
     * @throws IOException if there is an error reading the data file
     */
    public MonsterData(String dataSet) throws IOException {
        this.monsterData = new ArrayList<>();
        this.size = 0;
        Scanner text = new Scanner(new File(dataSet + "/monstats.txt"));
        while (text.hasNextLine()) {
            String line = text.nextLine();
            String[] words = line.split("\t");
            String treasureClass = "";
            for (int i = 3; i < words.length; i++) {
                treasureClass += words[i];
            }
            String monsterName = words[0];
            Monster monster = new Monster(monsterName, treasureClass);
            monsterData.add(monster);
            size += 1;
        }
        text.close();
    }

    /**
     * Get the monster name at the specified index
     * 
     * @param index the index of the monster
     * @return the monster name
     */
    public String getMonsterName(int index) {
        return monsterData.get(index).getMonsterClass();
    }

    /**
     * Get the treasure class name at the specified index
     * 
     * @param index the index of the monster
     * @return the treasure class name
     */
    public String getTreasureClassName(int index) {
        return monsterData.get(index).getTreasureClass();
    }
    
    /**
     * Get the current size of the monster data
     * 
     * @return the size of the monster data
     */
    public int getSize() {
        return size;
    }
}
