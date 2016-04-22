package amdahl;

/**
 * Synchronized counter example
 *
 * Starts a certain number of threads, which all call the synchronized inc() method to increment z.
 * After all Threads were started, we are waiting for each to terminate (join).
 *
 * @author Lukas Werner
 */
public class CounterSynchronized extends AbstractCounter {

    @Override
    public void start() throws InterruptedException {
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(this::inc);
            threads[i].start();
        }
        for (Thread t: threads) {
            t.join();
        }
    }

    /**
     * Test execution
     *
     * @param args no args supported
     * @throws InterruptedException no exception handling
     */
    public static void main(String[] args) throws InterruptedException {
        new CounterSynchronized().start();
    }

}