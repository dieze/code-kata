package com.gildedrose.deterioration.deteriorations;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.Deterioration;
import lombok.RequiredArgsConstructor;

/**
 * Quality decreases twice as fast.
 */
@RequiredArgsConstructor
public final class TwiceAsFastDeterioration implements Deterioration {

    private final Deterioration delegate;

    @Override
    public void deteriorate(DeteriorableItem item, int deterioration) {
        this.delegate.deteriorate(item, deterioration * 2);
    }
}
