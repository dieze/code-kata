package com.gildedrose;

/**
 * Must NOT be modified.
 *
 * This class belongs to the angry goblin from 1st floor. He will instantly kill us if we modify this class.
 *
 * The angry goblin does not believe in team code ownership :'(
 *
 * @see <a href="https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/Java/src/main/java/com/gildedrose/Item.java">Item.java</a>
 * @see <a href="https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt">Gilded Rose Requirements Specification</a>
 */
public class Item {

    public String name;

    public int sellIn;

    public int quality;

    public Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }
}
