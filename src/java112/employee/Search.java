package java112.employee;

import java.util.ArrayList;
import java.util.List;

/**
 * This JavaBean contains the needed information for the Employee database search.
 *
 * @author pgfrank1
 * @version 1.0
 * @since 11.0
 */
public class Search {
    /**
     * The database search type
     */
    private String searchType;
    /**
     * The database search term
     */
    private String searchTerm;
    /**
     * The List of Employees found
     */
    private List<Employee> results;
    /**
     * True or False if the employee has been found
     */
    private boolean employeeFound;

    /**
     * Instantiates a new Search object as an ArrayList.
     */
    public Search() {

        results = new ArrayList<>();

    }

    /**
     * Add found employee.
     *
     * @param employee the employee
     */
    public void addFoundEmployee(Employee employee) {
            results.add(employee);
    }

    /**
     * Gets search type.
     *
     * @return the search type
     */
    public String getSearchType() {
        return searchType;
    }

    /**
     * Sets search type.
     *
     * @param searchType the search type
     */
    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    /**
     * Gets search term.
     *
     * @return the search term
     */
    public String getSearchTerm() {
        return searchTerm;
    }

    /**
     * Sets search term.
     *
     * @param searchTerm the search term
     */
    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    /**
     * Gets results.
     *
     * @return the results
     */
    public List<Employee> getResults() {
        return results;
    }

    /**
     * Sets results.
     *
     * @param results the results
     */
    public void setResults(ArrayList<Employee> results) {
        this.results = results;
    }

    /**
     * Is employee found boolean.
     *
     * @return the boolean
     */
    public boolean isEmployeeFound() {
        return employeeFound;
    }

    /**
     * Sets employee found.
     *
     * @param employeeFound the employee found
     */
    public void setEmployeeFound(boolean employeeFound) {
        this.employeeFound = employeeFound;
    }
}
