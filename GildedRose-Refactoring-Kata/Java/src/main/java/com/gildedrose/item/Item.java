package com.gildedrose.item;

/**
 * Item which is in stock.
 */
public interface Item {

    /**
     * Name of the item.
     */
    String getName();

    /**
     * Denotes how the item is precious.
     */
    int getQuality();
}
