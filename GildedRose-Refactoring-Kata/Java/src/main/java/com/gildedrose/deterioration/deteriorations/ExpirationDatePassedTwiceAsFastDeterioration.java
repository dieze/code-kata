package com.gildedrose.deterioration.deteriorations;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.Deterioration;
import lombok.RequiredArgsConstructor;

/**
 * Item deteriorate twice as fast when {@link DeteriorableItem#getSellIn()} has fell to 0.
 */
@RequiredArgsConstructor
public final class ExpirationDatePassedTwiceAsFastDeterioration implements Deterioration {

    private final Deterioration delegate;

    @Override
    public void deteriorate(DeteriorableItem item, int deterioration) {
        if (item.getSellIn() <= 0) {
            this.delegate.deteriorate(item, deterioration * 2);
            return;
        }

        this.delegate.deteriorate(item, deterioration);
    }
}
