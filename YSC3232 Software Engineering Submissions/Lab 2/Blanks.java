/*
* @author  Haroun Chahed
* @version 1.0
* @since   2019-09-01
*/
package com.haroun.examination;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author harounchahed
 */
public class Blanks extends Question {
     /**
     * Fill the blanks Class
     * Blanks extends Question Class 
     * TorF allows student to fill the blank in a statement
     */
    String statement ; 
    List<String> correctAnswers ; 
    String studentAnswer ; 

    
    Blanks(String name, String statement) { 
         /**
         * Blanks constructor 
         * @param name is the name of the question
         * @param statement is the statement with the blank  
         * blanks should be types as ". . ."
         */
        this.name = name ; 
        this.statement = statement ; 
        this.correctAnswers = new ArrayList<>() ; 
        this.studentAnswer = "Empty answer" ; 
    }
    
    void addAnswers(ArrayList<String> args) {
        /**
         * Method adds correct answers
         * @param args is the list of possible correct answers
         */
        for (String answer : args) { 
            this.correctAnswers.add(answer) ;
        }
    }
    
    @ Override
    void answer() {
         /**
         * Method allows student to answer the Fill the Blank question
         * It prints the statement to the student
         * and allows the students to input a string to fill the blank
         * If student input a non-string value 
         * It asks them to re-input their answer
         */
        System.out.print("Start of question '" + this.name + "'.\nPlease fill the blank with the most appropriate term.\n");
        System.out.print(this.statement + "\n");
        String answer ;
        Scanner scan = new Scanner(System.in) ; 
        while (!scan.hasNextLine()) {
            System.out.print("\nPlease input a valid String:\n");
            scan = new Scanner(System.in);
        } 
        studentAnswer = scan.nextLine();
        System.out.print("\nEnd of fill the blank question.\n"); 
    }
    
    @ Override 
    int grade() {
        /** Method returns student's grade on the question
         * @return int representing the student's grade
        */
        int grade = 0 ; 
        if (this.correctAnswers.contains(this.studentAnswer)) { 
            grade = 1 ; 
        }
        return grade ; 
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
         String XML = "<Blanks name=" + this.name + "/>\n" 
                + "<statement>" + this.statement + "</statement>\n" 
                + "<answer>" + this.correctAnswers + "</answer>\n" + "</Blanks>\n";
       
         return XML ; 
    }
    
}
