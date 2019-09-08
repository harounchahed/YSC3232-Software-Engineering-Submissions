/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haroun.examination;

/**
 *
 * @author harounchahed
 */

public abstract class Question {
    /**
     * Abstract class to be implemented by each question of the exam
     */
    
    String name ;     
        
    abstract void answer () ;
        /**
         * Method allows student to answer question
         */
    
    abstract int grade () ;
        /** Method returns student's grade on the question
         * @return int representing the student's grade
        */
    
    abstract String toXML() ;
        /**
         * Method returns XML of question 
         * @return String representing the question's XML
        */
    
    abstract int totalGrade() ; 
        /** Method returns maximum grade on the question
         * @return int representing the maximum grade
        */ 
    
    
}
