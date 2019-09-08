/**
* The Examination program implements an application that
* allows a student to take an exam
*
* @author  Haroun Chahed
* @version 1.0
* @since   2019-09-01
*/
package com.haroun.examination;

/**
 *
 * @author harounchahed
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        var myExam = Examination.demo() ; 
        
        //uncomment line below to print XML ouput
        // System.out.print(myExam.toXML()) ;
        
        myExam.saveXMLFile("Math.xml") ;
        myExam.take(); 
    }
    
}
