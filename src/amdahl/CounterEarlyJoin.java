package amdahl;

/**
 * Synchronized counter example with early join
 *
 * Starts a certain number of threads, which all call the synchronized inc() method to increment z.
 * Right after the start of each thread we are directly waiting for it to finish, so there is no way,
 * two threads run simultaneously.
 *
 * @author Lukas Werner
 */
public class CounterEarlyJoin extends AbstractCounter {

    @Override
    public void start() throws InterruptedException {
        Thread[] threads = new Thread[10000];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(this::inc);
            threads[i].start();
            threads[i].join();
        }
    }

    /**
     * Test execution
     *
     * @param args no args supported
     * @throws InterruptedException no exception handling
     */
    public static void main(String[] args) throws InterruptedException {
        new CounterEarlyJoin().start();
    }

}