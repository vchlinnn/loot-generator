package edu.grinnell.csc207.lootgenerator.GameObjects;

import java.util.Random;

public class Prefix {
    private String prefix;
    private String statisticText;
    private int mod1min;
    private int mod1max;

    public Prefix(String prefix, String statisticText, int mod1min, int mod1max){
        this.prefix = prefix;
        this.statisticText = statisticText;
    }

    public String getPrefix(){
        return prefix;
    }

    public String getStatisticText() {
        return statisticText;
    }

    public int getValue() {
        Random random = new Random();
        return random.nextInt(mod1min, mod1max + 1);
    }
}
