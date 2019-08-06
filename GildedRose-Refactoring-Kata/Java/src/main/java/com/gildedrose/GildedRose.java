package com.gildedrose;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.item.ItemFactory;

/**
 * This class should NOT be modified but the {@link #updateQuality()} method.
 *
 * @see <a href="https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/Java/src/main/java/com/gildedrose/GildedRose.java">GildedRose.java</a>
 * @see <a href="https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt">Gilded Rose Requirements Specification</a>
 */
class GildedRose {

    Item[] items;

    public GildedRose(com.gildedrose.Item[] items) {
        this.items = items;
    }

    /**
     * Only this method can be modified.
     */
    public void updateQuality() {
        ItemFactory itemFactory = new ItemFactory();

        for (Item item : this.items) {
            // adapt to new interface
            com.gildedrose.item.Item newItem = itemFactory.create(item.name, item.sellIn, item.quality);

            // update quality, sellIn
            if (newItem instanceof DeteriorableItem) {
                DeteriorableItem deteriorableItem = (DeteriorableItem) newItem;
                deteriorableItem.getDeterioration().deteriorate(deteriorableItem, 1);
                item.sellIn = deteriorableItem.getSellIn();
            }

            item.quality = newItem.getQuality();
        }
    }
}
