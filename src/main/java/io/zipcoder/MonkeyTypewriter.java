package io.zipcoder;

public class MonkeyTypewriter {
    public static void main(String[] args) {
        String introduction = "It was the best of times,\n" +
                "it was the blurst of times,\n" +
                "it was the age of wisdom,\n" +
                "it was the age of foolishness,\n" +
                "it was the epoch of belief,\n" +
                "it was the epoch of incredulity,\n" +
                "it was the season of Light,\n" +
                "it was the season of Darkness,\n" +
                "it was the spring of hope,\n" +
                "it was the winter of despair,\n" +
                "we had everything before us,\n" +
                "we had nothing before us,\n" +
                "we were all going direct to Heaven,\n" +
                "we were all going direct the other way--\n" +
                "in short, the period was so far like the present period, that some of\n" +
                "its noisiest authorities insisted on its being received, for good or for\n" +
                "evil, in the superlative degree of comparison only.";

        // Do all of the Monkey / Thread building here
        // For each Copier(one safe and one unsafe), create and start 5 monkeys copying the introduction to
        // A Tale Of Two Cities.


        UnsafeCopier unsafe = new UnsafeCopier(introduction);
        SafeCopier safe = new SafeCopier(introduction);


        //instantiate all the threads first and then start it otherwise first thread will complete your task
        Thread monkey1 = new Thread(safe); //changed from unsafe to safe - to test how it works
        Thread monkey2 = new Thread(safe);
       // Thread monkey2 = new Thread(new UnsafeCopier()); //dont do it this way
        Thread monkey3 = new Thread(safe);
        Thread monkey4 = new Thread(safe);
        Thread monkey5 = new Thread(safe);
        monkey1.start();
        monkey2.start();
        monkey3.start();
        monkey4.start();
        monkey5.start();

        // This wait is here because main is still a thread and we want the main method to print the finished copies
        // after enough time has passed.
        try {
            monkey1.join();
            monkey2.join();
            monkey3.join();
            monkey4.join();
            monkey5.join();
            Thread.sleep(10);
        } catch(InterruptedException e) {
            System.out.println("MAIN INTERRUPTED");
        }
        // Print out the copied versions here.

        System.out.println(safe.copied);  //change it safe or unsafe as per what you want to test

        if(pageMatcher(safe.copied,introduction)) {
            System.out.println("It Matches!");
        }else{
            System.out.println("Content does not match with original");
        }
    }

    public static Boolean pageMatcher(String copy, String original) {
        return copy.equals(original);
    }


}