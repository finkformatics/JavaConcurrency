package amdahl;

/**
 * Serial counter example
 *
 * Just implements a for loop to increment z certain times.
 *
 * @author Lukas Werner
 */
public class CounterSerial extends AbstractCounter {

    @Override
    public void start() throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            z++;
        }
    }

    /**
     * Test execution
     *
     * @param args no args supported
     * @throws InterruptedException no exception handling
     */
    public static void main(String[] args) throws InterruptedException {
        new CounterSerial().start();
    }

}