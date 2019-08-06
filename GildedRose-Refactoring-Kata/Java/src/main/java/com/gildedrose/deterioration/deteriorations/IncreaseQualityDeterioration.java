package com.gildedrose.deterioration.deteriorations;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.Deterioration;
import lombok.RequiredArgsConstructor;

/**
 * Quality is increasing instead of decreasing.
 */
@RequiredArgsConstructor
public final class IncreaseQualityDeterioration implements Deterioration {

    private final Deterioration delegate;

    @Override
    public void deteriorate(DeteriorableItem item, int deterioration) {
        delegate.deteriorate(
                item,
                deterioration > 0 ?
                        deterioration * -1 : // negative deterioration increases the item quality
                        deterioration
        );
    }
}
