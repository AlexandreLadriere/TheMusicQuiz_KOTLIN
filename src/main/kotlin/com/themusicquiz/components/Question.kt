/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-08-01 10:30:34 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-08-01 21:23:50
 */
package com.themusicquiz.components;

import com.themusicquiz.utils.*;
import com.themusicquiz.enumerations.QuestionTypes;

class Question(_questionType: QuestionTypes, _questionItem: Item, private val questionItemTab: MutableList<Item>) {

    var questionType: QuestionTypes = _questionType
        get() = field
        set(value) {field=value; this.updateQuestionCorrectAnswer();}

    var questionItem: Item = _questionItem
        get() = field
        set(value) {
            field = value;
            this.updateQuestionCorrectAnswer();
            this.createQuestionOptions(questionItemTab);}

    var questionCorrectAnswer: String = ""
        get() = field
        set(value) {field = value}

    var questionScore: Int = 0
        get() = field

    var questionTime: Long = 0L //in ms
        get() = field

    var questionIsCorrect: Boolean = false
        get() = field

    val questionOptions: MutableList<Item> = mutableListOf<Item>()
        get() = field

    init {
        this.updateQuestionCorrectAnswer();
        this.createQuestionOptions(questionItemTab);
    }

    private fun createQuestionOptions(itemMutableList: MutableList<Item>): Unit {
        this.questionOptions.clear();
        this.questionOptions.add(this.questionItem);
        if(itemMutableList.count()>=NUMBER_OF_PROPOSITIONS-1) {
            for(i in 0..NUMBER_OF_PROPOSITIONS-2) { 
                questionOptions.add(itemMutableList.get(i));
            }
        }
        this.questionOptions.shuffle();
    }

    private fun calculateQuestionScore(): Unit {
        this.questionScore = ((100000.toFloat()/this.questionTime).toFloat()).toInt();
    }

    public fun updateQuestionCorrectAnswer(): Unit {
        this.questionCorrectAnswer = this.getProposition(this.questionItem);
    }

    public fun getProposition(item: Item) = when(questionType) {
        QuestionTypes.UNDEFINED -> "undefined"
        QuestionTypes.WHEN -> item.itemDate
        QuestionTypes.WHICH_ONE -> item.itemTitle
        QuestionTypes.WHO -> item.itemAuthor
        QuestionTypes.COVER -> item.itemAuthor + " - " + item.itemDate
        else -> "undefined"
    }

    public fun checkAnswer(answer: String): Boolean {
        if(answer.equals(this.questionCorrectAnswer)) {
            this.questionIsCorrect = true;
            this.calculateQuestionScore();
        }
        return this.questionIsCorrect;
    }

    public fun askQuestion() = when(this.questionType) {
        QuestionTypes.UNDEFINED -> "Undefined question"
        QuestionTypes.WHEN -> "When was \""+questionItem.itemTitle+"\" released by "+questionItem.itemAuthor+" ?"
        QuestionTypes.WHO -> "Who released \""+questionItem.itemTitle+"\" in "+questionItem.itemDate+" ?"
        QuestionTypes.WHICH_ONE -> "What is the name of the album released by "+questionItem.itemAuthor+" in "+questionItem.itemDate+" ?"
        QuestionTypes.COVER -> "Who released this album and when ?"
        else -> "Unknown question"
    }
}