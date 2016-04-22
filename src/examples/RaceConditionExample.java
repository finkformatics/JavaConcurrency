package examples;

/**
 * Race condition example
 *
 * Creates a high number of threads and lets each increase a static int variable.
 *
 * Result: In most cases, the variable's value isn't 10000 after the program's finished, but a bit below.
 */
public class RaceConditionExample {

    private static int z;

    public static void main(String[] args) throws InterruptedException {
        // Create array of 10000 threads
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                // Increment z
                z++;
            });
            // Start the thread
            threads[i].start();
        }
        // Unnecessary here, but good to know: Waits for each thread to finish work
        for (Thread t: threads) {
            t.join();
        }
        System.out.println("The number is: " + z);
    }

}