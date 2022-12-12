package java112.employee;

import java.sql.*;
import java.util.*;

/**
 * The type Employee directory.
 */
public class EmployeeDirectory {

    private final Properties properties;

    /**
     * Instantiates a new Employee directory.
     *
     * @param properties the properties
     */
    public EmployeeDirectory(Properties properties) {
        this.properties = properties;
    }

    private Connection databaseConnection() {

        Connection connection = null;

        try {
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"));
            System.out.println("Connection made");
        } catch (Exception e)
        {
            handleExceptions(e);
        }
        return connection;
    }

    /**
     * Add employee to database.
     *
     * @param employeeId           the employee id
     * @param firstName            the first name
     * @param lastName             the last name
     * @param socialSecurityNumber the social security number
     * @param department           the department
     * @param roomNumber           the room number
     * @param phoneNumber          the phone number
     */
    public void addEmployeeToDatabase(String employeeId, String firstName,
            String lastName, String socialSecurityNumber, String department,
            String roomNumber, String phoneNumber) {

        Connection connection = databaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, socialSecurityNumber);
            preparedStatement.setString(5, department);
            preparedStatement.setString(6, roomNumber);
            preparedStatement.setString(7, phoneNumber);

            preparedStatement.executeUpdate();
            preparedStatement.close();

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
     * Search employee database search.
     *
     * @param searchTerm the search term
     * @param searchType the search type
     * @return the search
     */
    public Search searchEmployeeDatabase(String searchTerm, String searchType) {
        Search search = new Search();
        search.setSearchTerm(searchTerm);
        search.setSearchType(searchType);

        switch (searchType) {
            case "id":
                searchByEmployeeId(search);
                break;
            case "first_name":
                searchByEmployeeFirstName(search);
                break;
            case "last_name":
                searchByEmployeeLastName(search);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + searchType);
        }
        return search;
    }

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
     * Handle exceptions.
     *
     * @param e the e
     */
// Remember this site:
    //https://stackoverflow.com/questions/37763378/how-to-reduce-duplicated-code-of-same-exception-catching-operation-used-in-multi
    public void handleExceptions (Exception e) {

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

    private void searchForEmployee(Search search, PreparedStatement preparedStatement) {
        try {
            preparedStatement.setString(1, search.getSearchTerm());

            if (preparedStatement.execute()) {
                Employee employee = new Employee();
                search.setEmployeeFound(true);
                ResultSet resultSet = preparedStatement.getResultSet();
                preparedStatement.close();

                while (resultSet.next()) {
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
        } catch (Exception e)
        {
            handleExceptions(e);
        }
    }
}
