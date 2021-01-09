package com.acasmol.introandroidv2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class is the data provider for com.acasmol.introandroidv2.Item class
 * This class will populate the Adapter (com.acasmol.introandroidv2.RecyclerViewAdapter) for RecyclerView
 */
public class DataProvider
{
    public static List<Item> listItems;
    public static Map<Long,Item> itemMap;

    static
    {
        listItems = new ArrayList<Item>();
        itemMap =new HashMap<Long,Item>();

        addItem(new Item(1L, "Title 1", "Description 1"));
        addItem(new Item(2L, "Title 2", "Description 2"));
        addItem(new Item(3L, "Item Title 3", "Item Description 3"));
        addItem(new Item(4L, "Item Title 4", "Item Description 4"));
        addItem(new Item(5L, "Item Title 5", "Item Description 5"));
    }

    private static void addItem(Item item)
    {
        listItems.add(item);
        itemMap.put(item.getItemId(),item);
    }
}
