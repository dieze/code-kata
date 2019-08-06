package com.gildedrose;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GildedRoseTest {

    @Test
    public void given_a_selling_item_update_should_decrease_quality_by_1() {
        Item item = new Item("foo", 10, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(4);
        assertThat(item.sellIn).isEqualTo(9);
    }

    @Test
    public void given_a_selling_item_with_sellin_0_update_should_decrease_quality_by_2() {
        Item item = new Item("foo", 0, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(3);
    }

    @Test
    public void quality_should_never_become_negative() {
        Item item = new Item("foo", 10, 0);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(0);
    }

    @Test
    public void aged_brie() {
        Item item = new Item("Aged Brie", 10, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    public void aged_brie_expired() {
        Item item = new Item("Aged Brie", 0, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    public void quality_shouldnt_exceed_50() {
        Item item = new Item("Aged Brie", 10, 50);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(50);
    }

    @Test
    public void quality_of_sulfuras_shouldnt_change() {
        Item item = new Item("Sulfuras, Hand of Ragnaros", 10, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(80);
    }

    @Test
    public void quality_of_backstage_should_increase_by_1_when_there_are_more_than_10_days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 11, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(6);
    }

    @Test
    public void quality_of_backstage_should_increase_by_2_when_there_are_10_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 10, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(7);
    }

    @Test
    public void quality_of_backstage_should_increase_by_3_when_there_are_5_days_or_less() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 5, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(8);
    }

    @Test
    public void quality_of_backstage_should_drop_to_0_when_there_are_0_days() {
        Item item = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 5);

        updateQuality(item);

        assertThat(item.quality).isEqualTo(0);
    }

    @SuppressWarnings("nullness")
    private Item updateQuality(Item item) {
        Item[] items = new Item[] {item};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        return app.items[0];
    }

    @SuppressWarnings("nullness")
    private Item updateQualityGolden(Item item) {
        Item[] items = new Item[] {item};
        GoldenMasterGildedRose app = new GoldenMasterGildedRose(items);
        app.updateQuality();
        return app.items[0];
    }

    @Test
    public void generate_output_golden() {
        String[] names = new String[] {"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"};
        int[] sellins = new int[] {-1, 0, 1, 5, 6, 10, 11};
        int[] qualities = new int[] {-1, 0, 1, 49, 50, 51};

        String totalGOldenOutput = "";
        String totalOutput = "";
        for (String name : names) {
            for (int sellin : sellins) {
                for (int quality : qualities) {
                    String goldenOutput = goldenOutput(name, sellin, quality);
                    totalGOldenOutput += goldenOutput + "\n";

                    String output = gildedRoseOutput(name, sellin, quality);
                    totalOutput += output + "\n";
                }
            }
        }
        System.out.println(totalGOldenOutput);
        System.out.println(totalOutput);

        Assertions.assertThat(totalOutput).isEqualTo(totalGOldenOutput);
    }

    private String gildedRoseOutput(String name, int sellin, int quality) {
        Item item = new Item(name, sellin, quality);

        updateQuality(item);

        String input = name + ", " + sellin + ", " + quality;
        String result = item.toString();
        return input + " -> " + result;
    }

    private String goldenOutput(String name, int sellin, int quality) {
        Item item = new Item(name, sellin, quality);

        updateQualityGolden(item);

        String input = name + ", " + sellin + ", " + quality;
        String result = item.toString();
        return input + " -> " + result;
    }


}