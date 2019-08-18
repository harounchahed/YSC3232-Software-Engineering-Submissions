package com.mycompany.mavenproject1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class takes 3 arguments and returns the min, max, and average
 */

import java.util.Scanner;

public class min_max_avg_3_args {
        public static void main(String[] args) {
        
        // Initilization of the max, min, and avg values as floats 
        float max = 0; 
        float min = 0; 
        float avg; 

        /* This reads the input provided by user
         * using keyboard
         */
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter three numbers: \n");

        // This method reads the first number provided using keyboard
        float num1 = scan.nextInt();
        // This method reads the second number provided using keyboard
        float num2 = scan.nextInt();
        // This method reads the third number provided using keyboard
        float num3 = scan.nextInt();
        // Closing Scanner after the use
        scan.close();
        
        // This computes the max and the mix based on the different possible orders of the inputs
        
        if (num1 > num2 && num2 > num3) {
            max = num1;
            min = num3; 
        }
        
        if (num1 > num3 && num3 > num2) {
            max = num1;
            min = num2; 
        }
        if (num2 > num1 && num1 > num3) {
            max = num2;
            min = num3; 
        }
        
        if (num2 > num3 && num3 > num1) {
            max = num2;
            min = num1; 
        }
        if (num3 > num2 && num2 > num1) {
            max = num3;
            min = num1; 
        }
        
        if (num3 > num1 && num1 > num2) {
            max = num3;
            min = num2; 
        }        
        
        // This computes the average 
        avg = (num1 + num2 + num3) / 3 ; 
        
        // Displaying the results
        System.out.println("The max is: " + max + "\nThe min is: " + min + "\nThe avg is: " + avg);
    }
    
}
