package io.zipcoder;

import java.util.Random;

/**
 * Make this extend the Copier like `UnsafeCopier`, except use locks to make sure that the actual intro gets printed
 * correctly every time.  Make the run method thread safe.
 */
public class SafeCopier extends Copier{

    public SafeCopier(String toCopy) {
        super(toCopy);
    }

    public void run() {
        Random random = new Random();
        int min = 50;
        int max = 100;
        int randomSleep = random.nextInt((max-min) + 1) + min;


        while (stringIterator.hasNext()){
          /*  System.out.println(Thread.currentThread().getName() + " " + stringIterator.next());
            copied += stringIterator.next(); */

            //the below lines implemented to have the threads go in a order
            try{
                synchronized (stringIterator) {
                    //trying to break by assigning to string
                    String holder = stringIterator.next() + " ";
                    //Thread.sleep(1000);
                    Thread.sleep(randomSleep);
                    System.out.println(Thread.currentThread().getName());
                    copied += holder;
                   // System.out.println(Thread.currentThread().getName() + " " + stringIterator.next());

                }
            }
            catch(InterruptedException e) {

            }
        }

        copied = copied.trim();

    }

}
