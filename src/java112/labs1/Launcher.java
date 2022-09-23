package java112.labs1;

/**
 * Launcher to start the main TrailGuide process running.
 * //TODO: 2. What effect does the "." after "to" have?
 *
 * @author pawaite
 * @since 1.0
 * @version 1.0
 */
public class Launcher {

    /**
     * Create a TrailGuide and run its main processing method.
     *
     * @param args command line arguments are not currently used
     */
    public static void main(String[] args) {
        TrailGuide guide = new TrailGuide();
        guide.run();
    }
}
