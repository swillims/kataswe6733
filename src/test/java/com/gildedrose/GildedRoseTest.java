package com.gildedrose;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    /*@Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("fixme", app.items[0].name);
    }*/

    @Test
    public void NormalItemQualityDrop()
    {
        Item[] items = {new Item("Cheezit",5,10)};
        GildedRose gilded = new GildedRose(items);
        for (int i = 0; i < 5; i++)
            gilded.updateQuality();
        assertEquals(5, items[0].quality);
    }
    @Test
    public void NormalItemSellIn0()
    {
        Item[] items = {new Item("Cheezit", 0, 10)};

        GildedRose gilded = new GildedRose(items);

        for (int i = 0; i < 5; i++)
            gilded.updateQuality();

        assertEquals(0, items[0].quality);
    }
    // here

    @Test
    public void NormalItemNonNegativeQuality()
    {
        Item[] items = {new Item("Cheezit", 0, 5)};

        GildedRose gilded = new GildedRose(items);

        for (int i = 0; i < 5; i++)
            gilded.updateQuality();
        assertEquals(!(items[0].quality < 0 ), true);
    }
    @Test
    public void SellInDecrease()
    {
        Item[] items = {new Item("Cheezit", 5, 5)};

        GildedRose gilded = new GildedRose(items);

        for (int i = 0; i < 5; i++)
            gilded.updateQuality();

        assertEquals(items[0].sellIn, 0);
        //Assert.That(items[0].SellIn, Is.EqualTo(0));
    }
    @Test
    public void AgedBrieQualityIncrease()
    {
        Item[] items = {new Item("Aged Brie", 10, 2)};

        GildedRose gilded = new GildedRose(items);

        for (int i = 0; i < 5; i++)
            gilded.updateQuality();

        assertEquals(true, items[0].quality > 2);
    }
    @Test
    public void QualityCapsAt50()
    {
        Item[] items = {new Item("Aged Brie", 10, 49)};

        GildedRose gilded = new GildedRose(items);

        for (int i = 0; i < 5; i++)
            gilded.updateQuality();

        assertEquals(50, items[0].quality);
    }
    @Test
    public void SulfurasForever()
    {
        Item[] items = {new Item("Sulfuras, Hand of Ragnaros", 10, 10)};

        GildedRose gilded = new GildedRose(items);

        for (int i = 0; i < 100; i++)
            gilded.updateQuality();

        assertEquals(80, items[0].quality);
    }

    @Test
    public void ValueGoToZeroAfterConcert()
    {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1000)};

        GildedRose gilded = new GildedRose(items);

        gilded.updateQuality();
        gilded.updateQuality();

        assertEquals(0, items[0].quality);
    }

    @Test
    public void IncreaseBy2LessThan10Days()
    {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 4, 10)};

        GildedRose gilded = new GildedRose(items);
        gilded.updateQuality();

        assertEquals(13, items[0].quality);
    }

    @Test
    public void IncreaseBy3LessThan5Days()
    {
        Item[] items = {new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10)};

        GildedRose gilded = new GildedRose(items);
        gilded.updateQuality();

        assertEquals(12, items[0].quality);
    }

    @Test
    public void LessThan50()
    {
        Item[] items = {new Item("Aged Brie", -1, 20)};

        GildedRose gilded = new GildedRose(items);
        gilded.updateQuality();

        assertEquals(21, items[0].quality);
    }
}
