/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-31 15:42:30 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-08-01 19:33:02
 */
package com.themusicquiz.components;

import com.themusicquiz.utils.*;
import com.themusicquiz.enumerations.MusicGenres;
import com.themusicquiz.enumerations.QuestionTypes;

fun main() {
    println("Nombre de questions: $NUMBER_OF_QUESTIONS");
    println("French hiphop: "+MusicGenres.FR_hiphop.musicGenreLanguage_toDisplay);
    val itemTest: Item = Item(itemAuthor= "Sch", itemTitle= "A7", itemDate="2015", itemWikiLink="wikiLink", itemCoverPath="coverPath", itemSummaryPath= "/../resources/DB/hiphop/FR_hiphop/FR_hiphop.txt");
    val itemTest1: Item = Item(itemAuthor= "Booba", itemTitle= "A7", itemDate="2015", itemWikiLink="wikiLink", itemCoverPath="coverPath", itemSummaryPath= "/../resources/DB/hiphop/FR_hiphop/FR_hiphop.txt");
    val itemTest2: Item = Item(itemAuthor= "Sefyu", itemTitle= "A7", itemDate="2015", itemWikiLink="wikiLink", itemCoverPath="coverPath", itemSummaryPath= "/../resources/DB/hiphop/FR_hiphop/FR_hiphop.txt");
    val itemTest3: Item = Item(itemAuthor= "Alex", itemTitle= "A7", itemDate="2015", itemWikiLink="wikiLink", itemCoverPath="coverPath", itemSummaryPath= "/../resources/DB/hiphop/FR_hiphop/FR_hiphop.txt");
    //println(itemTest.getItemSummary());
    println(itemTest.getItemDescription());
    val arrayItemTest: MutableList<Item> = mutableListOf<Item>(itemTest1, itemTest2, itemTest3);
    val questionTest: Question = Question(QuestionTypes.WHO, itemTest, arrayItemTest);
    questionTest.questionType = randQuestionTypes();
    println(questionTest.questionItem.toString());
    println(questionTest.questionType);
    println(questionTest.askQuestion());
    println(questionTest.checkAnswer("Sch"));
    println(questionTest.questionOptions);
    println(questionTest.questionCorrectAnswer);
}