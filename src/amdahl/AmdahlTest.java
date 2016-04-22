package amdahl;

/**
 * An application to test the different counter implementation and to determine, which one is the fastest one.
 * Based on this you can use the "amdahl's law" and calculate the parallelizable amount of the implementations.
 *
 * @author Lukas Werner
 */
public class AmdahlTest {

    /**
     * This determines the number of executions of each implementation to get a representative average value
     */
    private static final int EXECUTIONS = 20;
    /**
     * Helper constant to convert ns to s
     */
    private static final double NANO_TO_BASE = 1E9;

    /**
     * Calculate the average time in seconds based on arrays of start and end times
     *
     * @param startTimes array of start times in ns
     * @param endTimes array of end times in ns
     * @return average time difference in s
     */
    private static double calculateAverage(long[] startTimes, long[] endTimes) {
        long sum = 0;
        for (int i = 0; i < startTimes.length; i++) {
            sum += endTimes[i] - startTimes[i];
        }
        if (startTimes.length > 0) {
            return sum / (NANO_TO_BASE * startTimes.length);
        }
        return 0.0;
    }

    /**
     * Test a single counter implementation and provide the required time.
     *
     * @param counter The counter implementation to test (must inherit from AbstractCounter)
     * @return the average time needed
     * @throws Exception if something goes wrong
     */
    private static double testCounter(AbstractCounter counter) throws Exception {
        long[] startTimes = new long[EXECUTIONS];
        long[] endTimes = new long[EXECUTIONS];
        for (int i = 0; i < EXECUTIONS; i++) {
            startTimes[i] = System.nanoTime();
            counter.start();
            endTimes[i] = System.nanoTime();
        }
        return calculateAverage(startTimes, endTimes);
    }

    /**
     * Test method
     *
     * @param args no args supported
     * @throws Exception if something goes wrong
     */
    public static void main(String[] args) throws Exception {
        double avgTime;
        // Test the serial version
        CounterSerial counterSerial = new CounterSerial();
        avgTime = testCounter(counterSerial);
        System.out.println(counterSerial.getClass().getTypeName() + " needed " + avgTime + "s");
        // Test the early join version
        CounterEarlyJoin counterEarlyJoin = new CounterEarlyJoin();
        avgTime = testCounter(counterEarlyJoin);
        System.out.println(counterEarlyJoin.getClass().getTypeName() + " needed " + avgTime + "s");
        // Test the synchronized version
        CounterSynchronized counterSynchronized = new CounterSynchronized();
        avgTime = testCounter(counterSynchronized);
        System.out.println(counterSynchronized.getClass().getTypeName() + " needed " + avgTime + "s");
    }

}