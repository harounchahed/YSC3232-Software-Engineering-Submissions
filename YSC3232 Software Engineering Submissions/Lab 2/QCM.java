/*
* @author  Haroun Chahed
* @version 1.0
* @since   2019-09-01
*/

package com.haroun.examination;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author harounchahed
 */
public class QCM extends Question {
    /**
     * QCM Class
     * QCM extends Question Class
     * Questions of class QCM contain a list of statements that are all false except for 
     * QCM allows student to choose one statement from those statements
     */
    String question ; 
    int correctAnswer ; 
    int studentAnswer ; 
    ArrayList<String> choices ; 
    
    QCM(String name, String question) {
         /**
         * QCM constructor 
         * @param name is the name of the question
         * @param question is the question to be asked 
         * typically " Choose one of the statements below"
         */
        this.name = name ; 
        this.question = question ; 
        this.choices = new ArrayList<>() ; 
    }
    
    void addChoice(String choice) {
        /**
         * Method adds QCM option
         * @param choice is the QCM option 
         */
        this.choices.add(choice) ; 
    }
    
    void addCorrectAsnwer(int answer) { 
        /**
         * Method adds correct answer to the question
         * @param answer is the correct answer (a.k.a index of the correct statement) 
         */
        this.correctAnswer = answer ; 
    }
    @Override
    void answer() {
        /**
         * Method allows student to answer the QCM question
         * It iterates through all the statements of the question and prints them preceded by their indices
         * and allows the students to input their answer
         * If student inputs a value that is not a valid index 
         * It asks them to re-input their answer
         */
        System.out.print("\nStart of QCM question '" + this.name + "'. There is only one correct answer:\n");
        System.out.print("\n" + this.question + "\n") ;
        Scanner scan = new Scanner(System.in);
        for (String choice: this.choices) {
            int index = choices.indexOf(choice) + 1;
            System.out.print(index + ": "+ choice +"\n"); 
        }
        System.out.print("\nPlease type the index of your chosen answer:\n") ;
        while (!scan.hasNextInt()) {
            System.out.print("\nPlease type a valid index between 1 and " + choices.size() + "\n") ;   
            scan = new Scanner(System.in);
        }  
        studentAnswer = scan.nextInt(); 
    }

    @Override
    int grade() {
        /** Method returns student's grade on the question
         * @return int representing the student's grade
        */
       int grade = 0 ; 
       if (this.correctAnswer == this.studentAnswer) {
           grade = 1 ; 
       }
        return grade;
    }
    
    @Override
    int totalGrade() {
        /** Method returns maximum grade on the question
         * @return int representing the maximum grade
        */
       int grade = 1 ;
       return grade ;
    }
    
    @Override
    String toXML() {
        /**
         * Method returns XML of question 
         * @return String representing the question's XML
        */
        String XML = "<QCM name=" + this.name + "/>\n" 
                + "<question>" + this.question + "</question>\n" 
                + "<answer>" + this.correctAnswer + "</answer>\n" ;
        for (String choice: choices) { 
            XML += "<choice>" + choice + "</choices>\n";
        }
        XML += "</QCM>\n" ; 
        return XML ; 
                
    }
    
}
