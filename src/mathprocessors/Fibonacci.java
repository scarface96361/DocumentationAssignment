package mathprocessors;

import java.util.ArrayList;

public class Fibonacci {

    public long fibRecursive(int seqSpot){
        //this checks to see if the recursion has hit 1 or zero and returns that one. the reason fro this is that the recursion
        //does not loop infinitly and depending on the sequence the number returned is equal to the number of 1s split down into
        if( seqSpot <= 1){
            return seqSpot;
        }
        //this is the recursive line to start splitting the number provided down until it can give the number of ones equal to the number
        return fibRecursive(seqSpot - 1) +fibRecursive( seqSpot -2);
    }

    public ArrayList<Long> fibrecursivetimer( int upperLimit){
        ArrayList<Long> timelist = new ArrayList<Long>();
        int xCount = 0;

        long startTime;
        long endTime;
        long finalTime;

        long fibTemp;

        while (xCount < upperLimit){
            xCount++;
            startTime = System.nanoTime();

            //running the recursive function
            fibTemp = fibRecursive(xCount);

            endTime = System.nanoTime();
            //calculating final time
            finalTime = endTime - startTime;

            timelist.add(finalTime);

            //printing out the input and final time of each fibonacci number
            System.out.println("Time taken: " + finalTime +" number returned: " + fibTemp + " Iteration: " + xCount);

        }
        return timelist;
    }

    public ArrayList<Long> fibnonRecursive(int upperlimit){
        //the first integer for the fibonaci sequence math
        long x1 =0;
        //the second number for the fibonacci sequence math
        long x2 = 1;
        long xtemp =0;

        long Xfib = 0;

        long startTime =0;
        long endTime =0;
        long finaltime = 0;

        ArrayList<Long> timelist = new ArrayList<Long>();


        int c = 0;
        while(c < upperlimit){

            startTime = System.nanoTime();
            //adding the two numbers into fibonacci final
            Xfib = x2 + x1;

            x1 = x2;
            x2 = Xfib;

            endTime = System.nanoTime();

            finaltime = endTime- startTime;

            System.out.println("Time taken: " + finaltime+" number returned: " + Xfib + " Iteration: " + c);

            timelist.add(finaltime);
            c++;

        }
        return timelist;
    }

}
