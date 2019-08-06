package com.gildedrose.item.items;

import com.gildedrose.deterioration.DeteriorableItem;
import com.gildedrose.deterioration.DeteriorableItemImpl;
import com.gildedrose.deterioration.deteriorations.BackstagePassesDeterioration;
import com.gildedrose.deterioration.deteriorations.DeteriorationImpl;
import com.gildedrose.deterioration.deteriorations.ExpirationDatePassedTwiceAsFastDeterioration;
import lombok.RequiredArgsConstructor;

/**
 * Factory for a "Backstage passes" item.
 *
 * "Backstage passes" item increases its quality as time passes.
 *
 * Its quality increases depending on the item expiration date..
 *
 * Quality increases by 2 when remains 10 days or less before item expiration date.
 * Quality increases by 3 when remains 5 days or less before item expiration date.
 * Quality falls to 0 after item expiration date.
 */
@RequiredArgsConstructor
public final class BackstagePassesFactory {

    public static final String NAME = "Backstage passes to a TAFKAL80ETC concert";

    public DeteriorableItem create(int sellIn, int quality) {
        return new DeteriorableItemImpl(
                NAME,
                sellIn,
                quality,
                new BackstagePassesDeterioration( // Its quality increases depending on the item expiration date
                        new ExpirationDatePassedTwiceAsFastDeterioration(  // expiration date passed twice as fast deterioration
                                new DeteriorationImpl() // applies deterioration to item
                        )
                )
        );
    }
}
