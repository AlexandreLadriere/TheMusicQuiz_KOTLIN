/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-08-01 13:41:07 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-08-01 17:00:57
 */
package com.themusicquiz.utils;

import com.themusicquiz.enumerations.QuestionTypes;
import com.themusicquiz.components.Item;
import com.themusicquiz.components.Question;

fun randInt(min: Int, max: Int) = (min..max).random(); //min and max incl.

fun randQuestionTypes() = when(randInt(0, 3)) {
    0 -> QuestionTypes.WHO
    1 -> QuestionTypes.WHEN 
    2 -> QuestionTypes.WHICH_ONE
    3 -> QuestionTypes.COVER
    else -> QuestionTypes.UNDEFINED
}

fun generateQuestionSerie(questionType: QuestionTypes, itemMutableList: MutableList<Item>): MutableList<Question> {
    var questionList: MutableList<Question> = mutableListOf<Question>();
    var itemPropositionMutableList: MutableList<Item> = mutableListOf<Item>();
    val max: Int = itemMutableList.count()-1;
    for(i in 1..NUMBER_OF_QUESTIONS) {
        for(j in 1..NUMBER_OF_PROPOSITIONS) {
            itemPropositionMutableList.add(itemMutableList.get(randInt(0, max)));
        }
        if(questionType.equals(QuestionTypes.RANDOM)) {
            questionList.add(Question(randQuestionTypes(), itemMutableList.get(randInt(0, max)), itemPropositionMutableList));
        }
        else {
            questionList.add(Question(questionType, itemMutableList.get(randInt(0, max)), itemPropositionMutableList));
        }
    }
    return questionList;
}