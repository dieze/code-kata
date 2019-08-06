package com.gildedrose.item.items;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.DeteriorableItemImpl;
import com.gildedrose.deterioration.deteriorations.DeteriorationImpl;
import com.gildedrose.deterioration.deteriorations.ExpirationDatePassedTwiceAsFastDeterioration;
import com.gildedrose.deterioration.deteriorations.TwiceAsFastDeterioration;
import lombok.RequiredArgsConstructor;

/**
 * Factory for a "Conjured" item.
 *
 * "Conjured" item decreases its quality twice as fast as ordinary items.
 */
@RequiredArgsConstructor
public final class ConjuredFactory {

    public static final String NAME = "Conjured";

    public DeteriorableItem create(int sellIn, int quality) {
        return new DeteriorableItemImpl(
                NAME,
                sellIn,
                quality,
                new ExpirationDatePassedTwiceAsFastDeterioration( // deterioration for ordinary items
                        new TwiceAsFastDeterioration( // decreases its quality twice as fast as ordinary items
                                new DeteriorationImpl() // applies deterioration to item
                        )
                )
        );
    }
}
