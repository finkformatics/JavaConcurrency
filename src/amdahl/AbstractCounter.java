package amdahl;

/**
 * Abstract class AbstractCounter
 *
 * Requires the extending classes to implement a start method. Provides a shared member z and a synchronized
 * method inc() to increment it with thread safety.
 *
 * @author Lukas Werner
 */
abstract class AbstractCounter {

    /**
     * Shared member z
     */
    int z;

    /**
     * Increments z synchronized
     */
    synchronized void inc() {
        z++;
    }

    /**
     * Forces the sub classes to implement this method, because we need it for
     * performance tests.
     *
     * @throws Exception if at any time there is an exception
     */
    public abstract void start() throws Exception;

}