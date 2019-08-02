/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-08-02 12:10:14 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-08-02 16:24:14
 */
package com.themusicquiz.components;

import com.themusicquiz.utils.*;
import com.themusicquiz.enumerations.QuestionTypes;

class QuestionSerie(val pDBPath: String = "", val questionType: QuestionTypes = QuestionTypes.UNDEFINED) {
    var correctAnswerTotal: Int = 0
        get(): Int {this.calculateCorrectAnswerTotal(); return field}

    var averageTime: Float = 0F //in ms
        get(): Float {this.calculateAverageTime(); return field}

    var questionsList: MutableList<Question> = mutableListOf<Question>();
    var itemList: MutableList<Item> = mutableListOf<Item>();

    private fun calculateCorrectAnswerTotal(): Unit {
        this.correctAnswerTotal = 0;
        for(question in this.questionsList) {
            if(question.questionIsCorrect) {
                this.correctAnswerTotal += 1;
            }
        }
    }

    init {
        this.buildLists();
    }

    private fun calculateAverageTime(): Unit {
        this.averageTime = 0F;
        for(question in this.questionsList) {
            this.averageTime += question.questionTime.toFloat();
        }
        this.averageTime = this.averageTime/NUMBER_OF_QUESTIONS;
    }

    private fun buildLists(): Unit {
        this.itemList = FileHandler.Companion.getItemListFromDB(this.pDBPath);
        this.questionsList = generateQuestionSerie(this.questionType, this.itemList);
    }
}