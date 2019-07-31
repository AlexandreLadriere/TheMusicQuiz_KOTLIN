/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-31 15:42:30 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-07-31 21:00:43
 */
package com.themusicquiz.components;

import com.themusicquiz.utils.*;
import com.themusicquiz.enumerations.MusicGenres;

fun main() {
    println("Nombre de questions: $NUMBER_OF_QUESTIONS");
    println("French hiphop: "+MusicGenres.FR_hiphop.musicGenreLanguage_toDisplay);
    val itemTest: Item = Item(itemAuthor= "Sch", itemTitle= "A7", itemDate="2015", itemWikiLink="wikiLink", itemCoverPath="coverPath", itemSummaryPath= "/../resources/DB/hiphop/FR_hiphop/FR_hiphop.txt");
    //println(itemTest.getItemSummary());
    println(itemTest.getItemDescription());
}