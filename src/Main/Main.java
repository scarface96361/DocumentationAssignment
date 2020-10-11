package Main;

import mathprocessors.Fibonacci;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //creating all variables needed for the fibonacci calculations and time storage
        int x = 0 ;
        long Fibnum = 0;
        long startTime;
        long endTime;
        long timeProcessed;

        ArrayList<Long> times = new ArrayList<Long>();

        //creating a data processor object
        Fibonacci fibpro = new Fibonacci();

        //making a loop to run 50 iterations of the recursive fibonacci sequence in order to math out time
        while ( x< 50 ){
            x++;
            //getting the time at the start of the process
            startTime = System.nanoTime();
            //calculating the end of the time
            Fibnum = fibpro.fibRecursive(x);
            //getting the start at the end of the process
            endTime = System.nanoTime();

            timeProcessed = endTime - startTime;
            times.add(timeProcessed);

            System.out.println("Time taken: " + timeProcessed+" number returned: " + Fibnum + " Iteration: " + x);




        }
        //running the fibonacci sequence non recursively

        fibpro.fibnonRecursive(50);


    }

}
