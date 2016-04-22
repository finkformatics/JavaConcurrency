package examples;

/**
 * Simple thread example
 *
 * Creates a certain number of threads and lets each thread print out a message and its index in the array.
 *
 * Result: The outputs aren't in the order the threads were created.
 */
public class ThreadExample {

    public static void main(String[] args) throws InterruptedException {
        // Create array of 8 threads
        Thread[] threads = new Thread[8];
        for (int i = 0; i < threads.length; i++) {
            // Create final variable to use in anonymous inner class
            final int count = i;
            threads[i] = new Thread(() -> {
                // Say hello
                System.out.println("Hello World from Thread " + count);
            });
            // Start the thread
            threads[i].start();
        }
        // Unnecessary here, but good to know: Waits for each thread to finish work
        for (Thread t: threads) {
            t.join();
        }
    }

}