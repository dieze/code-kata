package com.gildedrose.deterioration.deteriorations;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.Deterioration;
import com.gildedrose.item.items.BackstagePassesFactory;

/**
 * Deterioration specific to {@link BackstagePassesFactory}.
 *
 * "Backstage passes" item increases its quality as time passes.
 *
 * Its deterioration depends on the item expiration date.
 *
 * Quality increases by 2 when remains 10 days or less before item expiration date.
 * Quality increases by 3 when remains 5 days or less before item expiration date.
 * Quality falls to 0 after item expiration date.
 */
public final class BackstagePassesDeterioration implements Deterioration {

    private final Deterioration delegate;

    public BackstagePassesDeterioration(Deterioration delegate) {
        this.delegate = new IncreaseQualityDeterioration( // Quality increases
                delegate
        );
    }

    @Override
    public void deteriorate(DeteriorableItem item, int deterioration) {
        if (item.getSellIn() <= 0) {
            // Quality falls to 0 after item expiration date.
            item.setQuality(0); // quality = 0, period.
            return;
        }

        if (item.getSellIn() <= 5) {
            // Quality increases by 3 when remains 5 days or less before item expiration date.
            this.delegate.deteriorate(item, deterioration * 3);
            return;
        }

        if (item.getSellIn() <= 10) {
            // Quality increases by 2 when remains 10 days or less before item expiration date.
            this.delegate.deteriorate(item, deterioration * 2);
            return;
        }

        this.delegate.deteriorate(item, deterioration);
    }
}
