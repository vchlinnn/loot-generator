package edu.grinnell.csc207.lootgenerator.GameDataStructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

import edu.grinnell.csc207.lootgenerator.GameObjects.Monster;

public class MonsterData {
    private List<Monster> monsterData;
    private int size;
    
    public MonsterData(String DATA_SET) throws IOException {
        this.monsterData = new ArrayList<>();
        Scanner text = new Scanner(new File(DATA_SET + "/monstats.txt"));
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

    public String getMonsterName(int index){
        return monsterData.get(index).getMonsterClass();
    }

    public String getTreasureClassName(int index){
        return monsterData.get(index).getTreasureClass();
    }
    
    public int getSize(){
        return size;
    }
}
