/**
* @author  Haroun Chahed
* @version 1.0
* @since   2019-09-01
*/

package com.haroun.examination;

import java.util.HashMap;
import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author harounchahed
 */
public class TorF extends Question {
    /**
     * True of False Class
     * TorF extends Question Class
     * Questions of class TorF contain a number of statements with their correct answers 
     * TorF allows students to label each of these statement with a Boolean value
     */
    String question ;
    HashMap<String, Boolean> correctAnswers ;
    HashMap<String, Boolean> studentAnswers ; 
    
    
    TorF (String name, String question) {
        /**
         * TorF constructor 
         * @param name is the name of the question
         * @param question is the question to be asked before the list of statement 
         * typically "answer each of the statements with true or false
         */
        this.name = name; 
        this.question = question ; 
        this.correctAnswers = new HashMap<>() ; 
        this.studentAnswers = new HashMap<>() ; 
    }
    
    void addTorFchoice(String choice, Boolean answer) {
        /**
         * Method add statement to the question to be labeled be the student
         * @param choice is the statement 
         * @param answer is the correct answer of type Boolean
         */
        this.correctAnswers.put(choice, answer) ; 
    }      
    
    void addStudentchoice(String choice, Boolean answer) {
        /**
         * Method adds a student's answer
         * @param choice is the statement the student's answer relates too
         * @param answer is the student's answer of type Boolean
         */
        this.studentAnswers.put(choice, answer) ; 
    }
     
    @Override
    void answer() {
        /**
         * Method allows student to answer the True or False question
         * It iterates through all the statements of the question 
         * and allows the students to input a Boolean value for each of them
         * If student input a non-Boolean value 
         * It asks them to re-input their answer
         */
        System.out.print("\nStart of True of False question '" + this.name + "':\n");
        Scanner scan = new Scanner(System.in);
        for (String choice : this.correctAnswers.keySet()) {
            System.out.print(StringUtils.repeat('_', 30)  + "\nStatement: " + choice);
            System.out.print("\nPlease type true or false:\n");
            while (!scan.hasNextBoolean()) {
                System.out.print("\nPlease print a valid boolean ('true' or 'false'):\n") ; 
                scan = new Scanner(System.in);
            } 
            this.addStudentchoice(choice, scan.nextBoolean()) ; 
        }
        System.out.print("\nEnd of True or False question.\n"); 
    }
    
    @ Override 
    int grade() { 
        /** Method returns student's grade on the question
         * @return int representing the student's grade
        */
        int grade = 0 ;
        for (String choice : this.correctAnswers.keySet()) {
            if (this.correctAnswers.get(choice) == this.studentAnswers.get(choice)) { 
                grade += 1 ; 
            }
        }
        return grade ; 
    }
    
    @ Override 
    int totalGrade() {
        /** Method returns maximum grade on the question
         * @return int representing the maximum grade
        */
        int grade = 0 ;
        for (String choice : this.correctAnswers.keySet()) {
            grade += 1 ;     
        }
        return grade ; 
    }
    
    @Override
    String toXML() {
         /**
         * Method returns XML of question 
         * @return String representing the question's XML
         */
        String XML = "<TorF name=" + this.name + "/>\n" 
                + "<question>" + this.question + "</question>\n" ; 
        for (String  statement : this.correctAnswers.keySet()) { 
            XML += "<statement>" + statement + "</statement>\n"
                + "<answer>" + this.correctAnswers.get(statement) + "</answer>\n";
            
        }
        XML += "</TorF>\n" ; 
        return XML ; 
    }
    
}
