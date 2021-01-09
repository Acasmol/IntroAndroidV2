package com.acasmol.introandroidv2;

/**
 * This class represents an item that could be
 * populated in a list through a Recycler View
 */
public class Item
{
    private Long itemId = null;
    private String itemTitle = null;
    private String itemDescription = null;

    public Item(Long itemId, String itemTitle, String itemDescription)
    {
        this.itemId = itemId;
        this.itemTitle = itemTitle;
        this.itemDescription = itemDescription;
    }

    public Long getItemId()
    {
        return itemId;
    }

    public void setItemId(Long itemId)
    {
        this.itemId = itemId;
    }

    public String getItemTitle()
    {
        return itemTitle;
    }

    public void setItemTitle(String itemTitle)
    {
        this.itemTitle = itemTitle;
    }

    public String getItemDescription()
    {
        return itemDescription;
    }

    public void setItemDescription(String itemDescription)
    {
        this.itemDescription = itemDescription;
    }

    @Override
    public String toString()
    {
        return "Item{" +
                "itemId=" + itemId +
                ", itemTitle='" + itemTitle + '\'' +
                ", itemDescription='" + itemDescription + '\'' +
                '}';
    }
}
