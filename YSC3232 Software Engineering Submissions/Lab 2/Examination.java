/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.haroun.examination;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import static java.util.concurrent.TimeUnit.MINUTES;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author harounchahed
 */

public class Examination {
    private final List<Question> questions ; 
    int durationMinutes ; 
    String name ; 
    Duration duration ; 
    
    
    
    Examination (String name, int durationMinutes) { 
           /**
            * Examination constructor
            * @param name name of examination
            * @param durationMinutes duration of exam
            */
        this.durationMinutes = durationMinutes ; 
        this.questions = new ArrayList<>() ; 
        this.name = name ; 
        this.duration = Duration.ofMinutes(durationMinutes) ; 
    }
    
    void addQuestion(Question question) { 
        /**
         * Method adds question to Exam
         * @param question of class Question
         */
        this.questions.add(question) ; 
    }
    
    Iterable<Question> getQuestions() {
        /**
         * Method returns list of questions of Exam
         */
        return this.questions ; 
    }
    
    void take () { 
        /**
         * Method starts the exam
         * It prints the name and duration of the exam 
         * It calls the method answer of each question of the exam
         * It prints the grade of the student
         */
        System.out.print("\nYour " + this.name 
                + " exam has just started.\nYou have " 
                + this.durationMinutes 
                + " minutes to finish it.\nGood luck!\n\n");
        int count = 0 ; 
        for (Question q: this.questions) {
            System.out.print("\n" + StringUtils.repeat('_', 70) + "\n") ;             
            count ++ ; 
            System.out.print("Question number "+ count + ": ");
            q.answer() ;
        }
        System.out.print(StringUtils.repeat('_', 70) + "\nThank you for taking the exam. You grade is " + this.grade() + " out of " + this.totalGrade());
    }
    
    int  grade () { 
        /**
         * Method grades exam
         * @return int representing the student's grade
         */
        int grade = 0 ; 
        for (Question q: questions) { 
            grade += q.grade() ; 
        }
        return grade ; 
    }
    
    int  totalGrade () {
        /**
         * Method return maximum grade of exam 
         * @return int representing the maximum grade
         */
        int totalGrade = 0 ; 
        for (Question q: questions) { 
            totalGrade += q.totalGrade() ; 
        }
        return totalGrade ; 
    }
    
    public String toXML() {
        /**
         * Method returns XML of exam 
         * @return String representing the exam's XML
         */
        String ExamStr = "";
        for (Question q : this.questions) {
            ExamStr += q.toXML();
        }
        String res = "<Exam name= " + this.name + " >\n" + ExamStr + "</Exam>\n";
        return res;
    }
       
    void saveXMLFile(String filename) {
        /**
         * Method saves the exam as an XML file
         */
        String str = this.toXML();
          try {
              Files.write(Paths.get(filename), str.getBytes());
          } catch (IOException ex) {
              Logger.getLogger(Examination.class.getName()).log(Level.SEVERE, null, ex);
          }
    }
    
    public static Examination demo () {
        /**
         * Test of the Examination Application
         * Demo that fills a Math Exam
         * with fill the blank, True or False, and QCM questions
         */
       Examination Exam = new Examination("Math" , 10) ;
       
       Blanks blanks1 = new Blanks("Number Types", "Every irrational number is also a . . . number") ;
       
       ArrayList<String> answers1 = new ArrayList<String>();
       answers1.add("real") ; 
       answers1.add("complex") ; 
       blanks1.addAnswers(answers1) ; 
       
       TorF TorF1 = new TorF("Analysis True or False" , "Which of the statements below is true?") ;
       
       TorF1.addTorFchoice("Every function has and existent limit at positive infinity.", false);
       TorF1.addTorFchoice("Every continuous function has an inverse.", false);
       TorF1.addTorFchoice("Every polynomial function is differentiable.", true);
       
       QCM qcm1 = new QCM("Caculus QCM", "What is the limit of 1/x at positive infinity?") ; 
       qcm1.addChoice("positive infinity");
       qcm1.addChoice("0");
       qcm1.addChoice("1") ; 
       qcm1.addCorrectAsnwer(2);
       
       Exam.addQuestion(blanks1);
       Exam.addQuestion(TorF1) ;
       Exam.addQuestion(qcm1);
              
       return Exam;
    }
            
    
}
