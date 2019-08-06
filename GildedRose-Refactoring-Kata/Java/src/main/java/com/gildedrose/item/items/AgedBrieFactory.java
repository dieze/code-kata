package com.gildedrose.item.items;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.DeteriorableItemImpl;
import com.gildedrose.deterioration.deteriorations.DeteriorationImpl;
import com.gildedrose.deterioration.deteriorations.ExpirationDatePassedTwiceAsFastDeterioration;
import com.gildedrose.deterioration.deteriorations.IncreaseQualityDeterioration;
import lombok.RequiredArgsConstructor;

/**
 * Factory for an "Aged Brie" item.
 *
 * "Aged Brie" item increases its quality as time passes.
 */
@RequiredArgsConstructor
public final class AgedBrieFactory {

    public static final String NAME = "Aged Brie";

    public DeteriorableItem create(int sellIn, int quality) {
        return new DeteriorableItemImpl(
                NAME,
                sellIn,
                quality,
                new ExpirationDatePassedTwiceAsFastDeterioration(
                        new IncreaseQualityDeterioration( // increases its quality
                                new DeteriorationImpl()
                        )
                )
        );
    }
}
