package io.zipcoder;

import java.util.Random;

/**
 * Modify the run function so that the monkeys each grab the next word and write it to the copy.
 */
public class UnsafeCopier extends Copier {

    public UnsafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        Random random = new Random();
        int min = 250;
        int max = 500;
        int randomSleep = random.nextInt((max-min) + 1) + min;


        while (stringIterator.hasNext()){
          /*  System.out.println(Thread.currentThread().getName() + " " + stringIterator.next());
            copied += stringIterator.next(); */

            //the below lines implemented to have the threads go in a order
            try{
                //trying to break by assigning to string
                String holder = stringIterator.next() + " ";
                //Thread.sleep(1000);
                Thread.sleep(randomSleep);
                System.out.println(Thread.currentThread().getName());
                copied += holder;
                System.out.println(Thread.currentThread().getName() + " " + stringIterator.next());
                copied += stringIterator.next();
            }
            catch(InterruptedException e) {

            }
        }



    }
}
