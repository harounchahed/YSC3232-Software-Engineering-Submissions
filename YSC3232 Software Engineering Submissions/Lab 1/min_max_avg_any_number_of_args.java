package com.mycompany.mavenproject1;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This class takes any number  arguments and returns the min, max, and average
 */

import java.util.Scanner;

public class min_max_avg_any_number_of_args {
    
    public static void main(String[] args) {
        
        float max ; // max is the maximum given number 
        float min ; // min is the minimum given number 
        float avg ; // avg is the average of the given numbers 
        float sum = 0 ; // sum is the sum of the given number 
        float count = 0 ; // count is the count of the given numbers
        
         /* This reads the input provided by user
         * using keyboard
         */

        Scanner input = new Scanner(System.in);

        System.out.println("Enter your numbers, and when you are done type \"Done\":" );
        float val = input.nextFloat();

        max = val ; 
        min = val ; 
        sum += val ; 
        count += 1 ;


        // At each iteration, max and min are updated if the given number is bigger than the max or smaller than the min 
        // sum is incremented by the given one and count in incremented by 1

        while(input.hasNextFloat() == true) // while the user inputs numbers 
        {
            val=input.nextFloat() ;
            if (val < min)
                min = val ; //update of min 
            if (val > max) 
                max = val ; // update of max
            sum += val ;  // increment sum
            count += 1;  // incremenet count
        }

        // This computes the average, which is the sum of all given numbers divided by their count
        avg = sum / count ; 

        // Displaying the results
        System.out.println("The max is: " + max + "\nThe min is: " + min + "\nThe avg is: " + avg);
    }
    
}
