/*
 * @Author: Alexandre Ladrière 
 * @Date: 2019-07-31 15:42:30 
 * @Last Modified by: Alexandre Ladrière
 * @Last Modified time: 2019-08-03 11:58:12
 */
package com.themusicquiz.components;

import java.lang.System;
import java.util.Scanner;
import com.themusicquiz.utils.*;
import com.themusicquiz.enumerations.MusicGenres;
import com.themusicquiz.enumerations.QuestionTypes;

fun main() {
    var playAgain: Int = 1;
    println("################# The Music Quiz #################");
    while(playAgain == 1) {
        var pDBPath: String = getDBPath();
        print(pDBPath);
        var questionType: QuestionTypes = getQuestionType();
        print("TEST");
        var questionSerie: QuestionSerie = QuestionSerie(pDBPath, questionType);
        if(questionType.equals(QuestionTypes.DISCOVER)) {
            startDiscover(questionSerie);
        }
        else {
            startQuiz(questionSerie);
        }
        print("\nPLAY AGAIN ??\n\t0: No, quit the game\n\t1: Yes of course !\n\nYour choice: ");
        playAgain = Integer.valueOf(readLine());
    }
}

fun getDBPath(): String {
    println("Please select your category:");
    for(i in 0..NUMBER_OF_HIPHOP_GENRES-1) {
        println("$i. "+MusicGenres.values()[i].musicGenreLanguage_toDisplay);
    }
    print("\nYour answer (0-"+(NUMBER_OF_HIPHOP_GENRES-1)+"): ");
    var userAnswer = Integer.valueOf(readLine());
    val DBPath = DB_PATH+"hiphop/"+MusicGenres.values()[userAnswer].musicGenreLanguage_name+"/"+MusicGenres.values()[userAnswer].musicGenreLanguage_name+".txt";
    return DBPath;
}

fun getQuestionType(): QuestionTypes {
    print("Please select the type of question: \n");
    for(i in 0..5) {
        println("$i. "+QuestionTypes.values()[i+1].toString());
    }
    print("\nYour answer (0-5): ");
    var userAnswer = Integer.valueOf(readLine())+1;
    return QuestionTypes.values()[userAnswer];
}

fun startDiscover(questionSerie: QuestionSerie): Unit {
    val scanner = Scanner(System.`in`);
    for(i in 0..NUMBER_OF_QUESTIONS-1) {
        questionSerie.questionsList.get(i).askQuestion();
        println("\n## Press Enter to continue...");
        scanner.nextLine();
    }
}

fun startQuiz(questionSerie: QuestionSerie): Unit {
    var start: Long;
    var stop: Long;
    for(i in 0..NUMBER_OF_QUESTIONS-1) {
        var currentQuestion: Question = questionSerie.questionsList.get(i);
        println("\n\n--------------------------------------------");
        println(currentQuestion.askQuestion());
        start = System.currentTimeMillis();
        println("cover: "+currentQuestion.questionItem.itemCoverPath);
        for(j in 0..NUMBER_OF_PROPOSITIONS-1) {
            println("\tProposition $j: "+currentQuestion.getProposition(currentQuestion.questionOptions.get(j)));
        }
        println("Your answer (0-"+(NUMBER_OF_PROPOSITIONS-1)+"): ");
        val userAnswer = currentQuestion.questionOptions.get(Integer.valueOf(readLine()));
        stop = System.currentTimeMillis();
        currentQuestion.questionTime = stop-start;
        currentQuestion.checkAnswer(currentQuestion.getProposition(userAnswer));
        if(currentQuestion.questionIsCorrect) {
            println("## CORRECT ANSWER !");
        }
        else {
            println("## WRONG ANSWER !");
            println("Correct Answer: "+currentQuestion.questionCorrectAnswer);
        }
        println("## QUESTION SCORE: "+currentQuestion.questionScore);
        println("\n\n"+currentQuestion.questionItem.getItemSummary());
    }
    print("\n--------------------------------------------------------------------------");
    print("\nCORRECT ANSWERS: "+questionSerie.calculateCorrectAnswerTotal()+"/$NUMBER_OF_QUESTIONS");
    print("\nTOTAL SCORE: "+questionSerie.calculateTotalScore() +" pts");
    print("\nAVERAGE TIME: "+(questionSerie.calculateAverageTime()/1000F)+" secondes");
    print("\n--------------------------------------------------------------------------");
}