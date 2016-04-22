package examples;

/**
 * Simple thread example (without synchronized Sysout)
 *
 * Creates a certain number of threads and lets each thread print out a message and its index in the array. The
 * difference from the ThreadExample.java is, that here we do not build on the synchronized possibility to output
 * strings but write an own method to printout each character in a string.
 *
 * Result: Letter salad :D
 */
public class ThreadExampleSysout {

    /**
     * Own print method to print each character separately
     * @param str the string to print
     */
    private  static void print(String str) {
        for (char c: str.toCharArray()) {
            System.out.print(c);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create array of 8 threads
        Thread[] threads = new Thread[8];
        for (int i = 0; i < threads.length; i++) {
            // Create final variable to use in anonymous inner class
            final int count = i;
            threads[i] = new Thread(() -> {
                // Say hello
                print("Hello World from Thread " + count + "\n");
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