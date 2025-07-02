package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality()
    {
        for (Item item : items)
        {
            //Sulfuras never changes
            if (item.name.equals("Sulfuras, Hand of Ragnaros"))
            {
                item.quality = 80;
                continue;
            }

            //Brie and Passes Increase In quality as time passes.
            if (item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
            {
                item.quality++;
                item.sellIn--;
                //Backstage passes increase in quality closer to the concert date
                if (item.name.equals("Backstage passes to a TAFKAL80ETC concert"))
                {
                    if (item.sellIn < 10)
                        item.quality++;
                    if (item.sellIn < 5)
                        item.quality++;
                    if (item.sellIn < 0)
                        item.quality = 0;
                }
                if (item.quality >= 50)
                    item.quality = 50;

                continue;
            }
            item.sellIn--;

            //All other items degrade by the day
            int deprecationNumber = 1;

            //items degrade twice as fast if they are conjured
            //short circuit operator "&&" used to avoid substring index out of bounds
            if (item.name.toLowerCase().contains("conjured") && item.name.substring(0,8).equalsIgnoreCase("conjured"))
                    deprecationNumber *= 2;

            //items degrade twice as fast after due date
            if (item.sellIn < 0)
                deprecationNumber *= 2;

            item.quality -= deprecationNumber;

            //item value can't be less than 0
            if (item.quality < 0)
                item.quality = 0;
            //item value can't be over 50 unless special case(handled above for legendary item "Sulfuras, Hand of Ragnaros"
            else if (item.quality >= 50)
                item.quality = 50;
        }
    }
}
