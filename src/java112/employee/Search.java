package java112.employee;

import java.util.ArrayList;
import java.util.List;

public class Search {
    private String searchType;
    private String searchTerm;
    private List<Employee> results;
    private boolean employeeFound;

    public Search() {

        results = new ArrayList<>();

    }

    public void addFoundEmployee(Employee employee) {
            results.add(employee);
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchTerm() {
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }

    public List<Employee> getResults() {
        return results;
    }

    public void setResults(List<Employee> results) {
        this.results = results;
    }

    public boolean isEmployeeFound() {
        return employeeFound;
    }

    public void setEmployeeFound(boolean employeeFound) {
        this.employeeFound = employeeFound;
    }
}
