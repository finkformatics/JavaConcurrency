package examples;

/**
 * Race condition solved example
 *
 * The same as race condition example, but with a particular synchronized inc() method to increment z
 *
 * Result: After program termination z is always 10000
 */
public class RaceConditionSolvedExample {

    private static int z;

    /**
     * Method to increment z
     */
    private synchronized static void inc() {
        z++;
    }

    public static void main(String[] args) throws InterruptedException {
        // Create array of 10000 threads
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(RaceConditionSolvedExample::inc);
            // Start the thread
            threads[i].start();
        }
        // Unnecessary here, but good to know: Waits for each thread to finish work
        for (Thread t : threads) {
            t.join();
        }
        System.out.println("The number is: " + z);
    }

}