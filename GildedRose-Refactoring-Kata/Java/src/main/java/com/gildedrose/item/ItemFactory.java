package com.gildedrose.item;

import com.gildedrose.item.items.*;
import lombok.RequiredArgsConstructor;

/**
 * Factory to create an item.
 */
@RequiredArgsConstructor
public final class ItemFactory {

    private final AgedBrieFactory agedBrieFactory = new AgedBrieFactory();
    private final BackstagePassesFactory backstagePassesFactory = new BackstagePassesFactory();
    private final ConjuredFactory conjuredFactory = new ConjuredFactory();
    private final SulfurasFactory sulfurasFactory = new SulfurasFactory();

    // last
    private final OrdinaryItemFactory ordinaryItemFactory = new OrdinaryItemFactory();

    public Item create(String name, int sellIn, int quality) {
        if (name == null) {
            throw new IllegalArgumentException("name must not be null");
        }

        switch (name) {
            case AgedBrieFactory.NAME:
                return this.agedBrieFactory.create(sellIn, quality);
            case BackstagePassesFactory.NAME:
                return this.backstagePassesFactory.create(sellIn, quality);
            case ConjuredFactory.NAME:
                return this.conjuredFactory.create(sellIn, quality);
            case SulfurasFactory.NAME:
                return this.sulfurasFactory.create();

            // last
            default:
                return this.ordinaryItemFactory.create(name, sellIn, quality);
        }
    }
}
