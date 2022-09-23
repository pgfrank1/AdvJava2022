package java112.labs1;

/**
 * Represents a trail which is general enough to be a hiking trail,
 * mountain bike trail, or ski trail.
 * @author pawaite
 * @since 1.0
 * @version 1.0
 *
 * //TODO: 1. Where does the comment below end up? Where should it be?
 * 
 */
public class Trail {

    /** Official name of the trail */
    private String name;

    /** City nearest to the main trailhead */
    private String city;

    /** State in which the main trailhead is located */
    private String state;

    /** Trail distance in miles */
    private int length;

    /**
     * Creates a new Trail.
     */
    public Trail() {
    }

    /**
     * Creates a new Trail with trail name, trail head city and state, and trail length
     * @param name name of the trail
     * @param city name of the city
     * @param state name of state using 2 letters
     * @param length length of the trail
     */
    public Trail(String name, String city, String state, int length) {
        this();
        this.name = name;
        this.city = city;
        this.state = state;
        this.length = length;
    }

    /**
     * Gets the trail's official name.
     *
     * @return returns the trail's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the trail's official name.
     *
     * @param name trail's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the city in which the main trailhead is located.
     * @return city in which the trailhead is located
     */
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city the trailhead's city
     * Sets the city in which the main trailhead is located.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets the state in which the main trailhead is located.
     *
     * @return the state in which the main trailhead is located
     */
    public String getState() {
        return state;
    }

    /**
     * Sets the state in which the main trailhead is located.
     *
     * @param state the state in which the main trailhead is located
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets the trail's length in miles.
     *
     * @return the length of the trail in miles
     */
    public int getLength() {
        return length;
    }

    /**
     * Sets the trail's length in miles.
     *
     * @param length the trail's length in miles.
     */
    public void setLength(int length) {
        this.length = length;
    }

    /**
     * Returns the trail details.
     *
     * @return trail's description including name, city, state and length
     */
    public String toString() {
        return "Trail{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", length=" + length + " miles" +
                '}';
    }
}
