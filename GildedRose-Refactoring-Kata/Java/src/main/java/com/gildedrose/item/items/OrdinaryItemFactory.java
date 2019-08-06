package com.gildedrose.item.items;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.DeteriorableItemImpl;
import com.gildedrose.deterioration.deteriorations.DeteriorationImpl;
import com.gildedrose.deterioration.deteriorations.ExpirationDatePassedTwiceAsFastDeterioration;
import lombok.RequiredArgsConstructor;

/**
 * Factory for an ordinary item.
 */
@RequiredArgsConstructor
public final class OrdinaryItemFactory {

    public DeteriorableItem create(String name, int sellIn, int quality) {
        return new DeteriorableItemImpl(
                name,
                sellIn,
                quality,
                new ExpirationDatePassedTwiceAsFastDeterioration(  // expiration date passed twice as fast deterioration
                        new DeteriorationImpl() // applies deterioration to item
                )
        );
    }
}
