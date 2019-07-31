/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-31 18:15:04 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-31 20:58:43
 */
package com.themusicquiz.components;

import com.themusicquiz.utils.FileHandler;

data class Item(val itemAuthor: String, val itemTitle: String, val itemDate: String, val itemWikiLink: String, val itemCoverPath: String, val itemSummaryPath: String) {
    
    private var itemSummary: String = "";
    private var itemDescription: String = "";

    init {
        itemSummary = FileHandler.Companion.readFileFromResources(itemSummaryPath);
        itemDescription = "\""+itemTitle+"\""+" was released by "+itemAuthor+" in "+itemDate;
    }

    public fun getItemSummary(): String {
        return itemSummary;
    }

    public fun getItemDescription(): String {
        return itemDescription;
    }
}