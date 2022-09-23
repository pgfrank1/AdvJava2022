package java112.labs1;

/**
 * This is the main processing class for the application to print out a list of all trails.
 *
 * @author pawaite
 * @since 1.0
 * @version 1.0
 * */
public class TrailGuide {
    /**
     *
     * @see TrailBuilder
     * @see TrailReport
     *
     * Use TrailBuilder and TrailReport to produce a report of all trails in the system.
     * Build a list of trails, and send the list of trails to the TrailReport for display.
     */
    public void run() {
        TrailBuilder builder = new TrailBuilder();
        TrailReport report = new TrailReport();
        report.setTrails(builder.getTrailList());
        report.printTrailReport();
    }
}
