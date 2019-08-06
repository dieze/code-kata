package com.gildedrose.deterioration;

public interface Deterioration {

    /**
     * Deteriorate a item, lowering (or highering) its quality.
     *
     * @param deterioration Increment of deterioration.
     *                      Positive deterioration decreases the item quality.
     *                      Negative deterioration increases the item quality (weird, i know).
     */
    void deteriorate(DeteriorableItem item, int deterioration);
}
