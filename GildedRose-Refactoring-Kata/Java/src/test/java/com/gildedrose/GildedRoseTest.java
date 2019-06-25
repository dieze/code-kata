package com.gildedrose;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void given_a_selling_item_update_should_decrease_quality_by_1() {
        Item item = new Item("foo", 10, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(4);
        assertThat(result.sellIn).isEqualTo(9);
    }

    @Test
    public void given_a_selling_item_with_sellin_0_update_should_decrease_quality_by_2() {
        Item item = new Item("foo", 0, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(3);
    }

    @Test
    public void quality_should_never_become_negative() {
        Item item = new Item("foo", 10, 0);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(0);
    }

    @Test
    public void aged_brie() {
        Item item = new Item("Aged Brie", 10, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(6);
    }

    @Test
    public void aged_brie_expired() {
        Item item = new Item("Aged Brie", 0, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(7);
    }

    @Test
    public void quality_shouldnt_exceed_50() {
        Item item = new Item("Aged Brie", 10, 50);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(50);
    }

    @Test
    public void quality_of_sulfuras_shouldnt_change() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(5);
    }

    @Test
    public void quality_of_backstage_should_increase_by_1_when_there_are_more_than_10_days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(6);
    }

    @Test
    public void quality_of_backstage_should_increase_by_2_when_there_are_10_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(7);
    }

    @Test
    public void quality_of_backstage_should_increase_by_3_when_there_are_5_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(8);
    }

    @Test
    public void quality_of_backstage_should_drop_to_0_when_there_are_0_days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);

        Item result = updateQuality(item);

        assertThat(result.quality).isEqualTo(0);
    }

    private Item updateQuality(Item item) {
        Item[] items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0];
    }

}
