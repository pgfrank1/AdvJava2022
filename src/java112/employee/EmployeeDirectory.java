package java112.employee;

import java.sql.*;
import java.util.*;

/**
 * This class contains the needed methods to connect and close all JDBC components.
 *
 * @author pgfrank1
 * @version 1.0
 * @since 11.0
 */
public class EmployeeDirectory {

    /**
     * The project 4 properties file
     */
    private final Properties properties;

    /**
     * Instantiates a new Employee directory.
     *
     * @param properties the project 4 properties file
     */
    public EmployeeDirectory(Properties properties) {
        this.properties = properties;
    }

    /**
     * This method attempts to make a connection to the MySQL database and returns
     * that connection for other methods to use
     *
     * @return connection to the specified MySQL server
     */
    private Connection databaseConnection() {
        Connection connection = null;
        try {
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"),
                    properties.getProperty("username"), properties.getProperty("password"));
            System.out.println("Connection made");
        } catch (Exception e)
        {
            handleExceptions(e);
        }
        return connection;
    }

    /**
     * Adds a new employee to the database.
     *
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     * @param department           the department
     * @param roomNumber           the room number
     * @param phoneNumber          the phone number
     */
    public void addEmployeeToDatabase(String firstName,
            String lastName, String socialSecurityNumber, String department,
            String roomNumber, String phoneNumber) {

        Connection connection = databaseConnection();
        try {
            PreparedStatement preparedStatement= connection.prepareStatement(
                    "INSERT INTO employees VALUES (null, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, socialSecurityNumber);
            preparedStatement.setString(4, department);
            preparedStatement.setString(5, roomNumber);
            preparedStatement.setString(6, phoneNumber);

            preparedStatement.executeUpdate();

        } catch (Exception e)
        {
            handleExceptions(e);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                handleExceptions(e);
            }
        }
    }

    /**
     * Search employee database search by calling a method that is related to
     * the searchTerm.
     *
     * @param searchTerm the search term
     * @param searchType the search type
     * @return the search result set
     */
    public Search searchEmployeeDatabase(String searchTerm, String searchType) {
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);

        if ("id".equals(search.getSearchType())) {
            searchByEmployeeId(search);
        } else if ("first_name".equals(search.getSearchType())) {
            searchByEmployeeFirstName(search);
        } else if ("last_name".equals(search.getSearchType())) {
            searchByEmployeeLastName(search);
        } else {
            throw new IllegalStateException("Unexpected value: " + searchType);
        }
        return search;
    }

    /**
     * This method searches the database via employee emp_id
     * @param search holds the search term and type
     *
     */
    private void searchByEmployeeId(Search search) {

        Connection connection = databaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employees WHERE emp_id = ?");

            searchForEmployee(search, preparedStatement);
        } catch (Exception e)
        {
            handleExceptions(e);
        } finally {
            try {
                connection.close();

            } catch (Exception e) {
                handleExceptions(e);
            }
        }

    }

    /**
     * This method searches the database via employee first_name
     * @param search holds the search term and type
     *
     */
    private void searchByEmployeeFirstName(Search search) {

        Connection connection = databaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employees WHERE first_name = ?");

            searchForEmployee(search, preparedStatement);

        } catch (Exception e)
        {
            handleExceptions(e);
        } finally {
            try {
                connection.close();

            } catch (Exception e) {
                handleExceptions(e);
            }
        }

    }

    /**
     * This method searches the database via employee last_name
     * @param search holds the search term and type
     *
     */
    private void searchByEmployeeLastName(Search search) {

        Connection connection = databaseConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM employees WHERE last_name = ?");

            searchForEmployee(search, preparedStatement);

        } catch (Exception e)
        {
            handleExceptions(e);
        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                handleExceptions(e);
            }
        }
    }

    /**
     * This method handles all of the needed exceptions for each try statement
     *
     * @param e the current exception
     */
    private void handleExceptions (Exception e) {

        if (e instanceof SQLException) {
            System.out.println("There was an error with the SQL server");
            e.printStackTrace();
        } else if (e instanceof ClassNotFoundException) {
            System.out.println("Database driver class was not found.");
            e.printStackTrace();
        } else if (e != null) {
            System.err.println("General Error");
            e.printStackTrace();
        }
    }

    /**
     * This method searches for each employee related to the specified search
     * term and type.
     *
     * @param search contains the current search term and type for the query
     * @param preparedStatement contains the PreparedStatement needed for searching
     *                          the database.
     *
     */
    private void searchForEmployee(Search search, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, search.getSearchTerm());
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.isBeforeFirst()) {
                while (resultSet.next()) {
                    search.setSearchTerm(resultSet.getString("last_name"));
                    search.setEmployeeFound(true);
                    Employee employee = new Employee();
                    employee.setEmployeeId(resultSet.getString("emp_id"));
                    employee.setFirstName(resultSet.getString("first_name"));
                    employee.setLastName(resultSet.getString("last_name"));
                    employee.setSocialSecurityNumber(resultSet.getString("ssn"));
                    employee.setDepartment(resultSet.getString("dept"));
                    employee.setRoomNumber(resultSet.getString("room"));
                    employee.setPhoneNumber(resultSet.getString("phone"));
                    search.addFoundEmployee(employee);
                }
            } else {
                search.setEmployeeFound(false);
            }
            resultSet.close();
            preparedStatement.close();
        } catch (Exception e)
        {
            handleExceptions(e);
        }
    }
}
