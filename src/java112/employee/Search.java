package java112.employee;

import java.util.ArrayList;
import java.util.List;

public class Search {
    private String searchType;
    private String searchTerm;
    private ArrayList<Employee> results;
    private boolean employeeFound;

    public Search() {
        // TODO document why this constructor is empty
    }

    public void addFoundEmployee(Employee employee) {
        if(isEmployeeFound()) {
            results.add(employee);
        }
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

    public ArrayList<Employee> getResults() {
        return results;
    }

    public void setResults(ArrayList<Employee> results) {
        this.results = results;
    }

    public boolean isEmployeeFound() {
        return employeeFound;
    }

    public void setEmployeeFound(boolean employeeFound) {
        this.employeeFound = employeeFound;
    }
}
