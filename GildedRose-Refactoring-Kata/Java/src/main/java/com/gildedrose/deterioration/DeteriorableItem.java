package com.gildedrose.deterioration;

import com.gildedrose.item.Item;

/**
 * Stock item that can deteriorate.
 */
public interface DeteriorableItem extends Item {

    /**
     * Number of days we have to sell the item.
     */
    int getSellIn();

    /**
     * Change the number of days we have to sell the item.
     */
    void setSellIn(int sellIn);

    /**
     * Change the quality of item.
     */
    void setQuality(int quality);

    /**
     * Get the Deterioration to apply to this item.
     */
    Deterioration getDeterioration();
}
