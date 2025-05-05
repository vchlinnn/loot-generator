package edu.grinnell.csc207.lootgenerator.GameObjects;

import java.util.Random;

/**
 * Affix class represents an affix in the game with its name, statistic text, and value range.
 * It is used to store and retrieve information about affixes.
 */
public class Affix {
    private String affix;
    private String statisticText;
    private int mod1min;
    private int mod1max;

    /**
     * Constructor for the Affix class
     * 
     * @param affix         the affix name
     * @param statisticText the statistic text associated with the affix
     * @param mod1min       the minimum value of the affix
     * @param mod1max       the maximum value of the affix
     */
    public Affix(String affix, String statisticText, int mod1min, int mod1max) {
        this.affix = affix;
        this.statisticText = statisticText;
        this.mod1min = mod1min;
        this.mod1max = mod1max;
    }

    /**
     * Get the affix name
     * @return the affix name
     */
    public String getAffix() {
        return affix;
    }

    /**
     * Get the statistic text associated with the affix
     * @return the statistic text
     */
    public String getStatisticText() {
        return statisticText;
    }

    /**
     * Get the random value of the affix
     * @return the random value
     */
    public int getValue() {
        Random random = new Random();
        return random.nextInt(mod1min, mod1max + 1);
    }
}
