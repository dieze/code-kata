package com.gildedrose.item;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * Item in stock.
 *
 * Must NOT have lombok {@code @EqualsAndHashCode} (so it must NOT implements {@link Object#equals(Object)} and
 * {@link Object#hashCode()}) because it would break Hash-based collections : identity of an Item should be based on its
 * instance number, not its properties values.
 */
@RequiredArgsConstructor
@Getter
@ToString
public final class ItemImpl implements Item {

    /**
     * Name of the item.
     */
    public final String name;

    /**
     * Denotes how the item is precious.
     */
    public final int quality;
}
