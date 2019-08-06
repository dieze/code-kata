package com.gildedrose.deterioration;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Deteriorable item.
 *
 * Must NOT have lombok {@code @EqualsAndHashCode} (so it must NOT implements {@link Object#equals(Object)} and
 * {@link Object#hashCode()}) because it would break Hash-based collections : identity of an Item should be based on its
 * instance number, not its properties values.
 */
@Getter
@ToString
public final class DeteriorableItemImpl implements DeteriorableItem {

    private final String name;
    @Setter
    private int sellIn;
    private int quality; // Modifiable
    private final Deterioration deterioration;

    public DeteriorableItemImpl(String name, int sellIn, int quality, Deterioration deterioration) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.deterioration = deterioration;
    }

    /**
     * Set quality of an item.
     *
     * Quality of an item must be less or equal to 50.
     * Quality of an item must be higher or equal to 0.
     *
     * @param quality Item quality to assign.
     *                If higher than 50, item quality is assigned to 50.
     *                If less than 0, item quality is assigned to 0.
     */
    @Override
    public void setQuality(int quality) {
        if (quality > 50) {
            this.quality = 50;
            return;
        }

        if (quality < 0) {
            this.quality = 0;
            return;
        }

        this.quality = quality;
    }
}
