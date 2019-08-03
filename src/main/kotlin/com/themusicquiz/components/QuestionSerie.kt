/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-08-02 12:10:14 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-08-03 11:53:05
 */
package com.themusicquiz.components;

import com.themusicquiz.utils.*;
import com.themusicquiz.enumerations.QuestionTypes;

class QuestionSerie(val pDBPath: String = "", val questionType: QuestionTypes = QuestionTypes.UNDEFINED) {
    
    var questionsList: MutableList<Question> = mutableListOf<Question>();
    var itemList: MutableList<Item> = mutableListOf<Item>();

    init {
        this.buildLists();
    }

    public fun calculateTotalScore(): Int  {
        var tmpTotalScore: Int = 0;
        for(question in this.questionsList) {
            tmpTotalScore += question.questionScore;
        }
        return tmpTotalScore;
    }

    public fun calculateCorrectAnswerTotal(): Int {
        var tmpCorrectAnswerTotal = 0;
        for(i in 0..this.questionsList.count()-1) {
            if(this.questionsList.get(i).questionIsCorrect) {
                tmpCorrectAnswerTotal += 1;
            }
        }
        return tmpCorrectAnswerTotal;
    }

    public fun calculateAverageTime(): Float {
        var tmpAverageTime = 0F;
        for(question in this.questionsList) {
            tmpAverageTime += question.questionTime.toFloat();
        }
        return tmpAverageTime/NUMBER_OF_QUESTIONS;
    }

    private fun buildLists(): Unit {
        this.itemList = FileHandler.Companion.getItemListFromDB(this.pDBPath);
        this.questionsList = generateQuestionSerie(this.questionType, this.itemList);
    }
}