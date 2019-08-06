package com.gildedrose.deterioration.deteriorations;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.Deterioration;

/**
 * Deterioration that actually applies deterioration to {@link DeteriorableItem}.
 *
 * Must always be used as last delegate through {@link DeteriorableItem#getDeterioration()}.
 */
public final class DeteriorationImpl implements Deterioration {

    @Override
    public void deteriorate(DeteriorableItem item, int deterioration) {
        // Positive deterioration decreases the item quality.
        // Negative deterioration increases the item quality (weird, i know).
        item.setQuality(item.getQuality() - deterioration);
        item.setSellIn(item.getSellIn() - 1);
    }
}
