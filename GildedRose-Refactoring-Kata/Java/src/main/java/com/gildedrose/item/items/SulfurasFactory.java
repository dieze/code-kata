package com.gildedrose.item.items;

import com.gildedrose.item.Item;
import com.gildedrose.item.ItemImpl;

/**
 * Factory for a "Sulfuras" item.
 *
 * "Sulfuras" is a legendary item which does not have sellIn date and never lose quality.
 * "Sulfuras" is a legendary item whose quality is 80. "Sulfuras" quality will never change.
 */
public final class SulfurasFactory {

    public static final String NAME = "Sulfuras, Hand of Ragnaros";

    public Item create() {
        return new ItemImpl(NAME, 80);
    }
}
