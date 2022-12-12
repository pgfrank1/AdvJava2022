package java112.employee;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.*;

public class EmployeeDirectory {

    private Properties properties;

    public EmployeeDirectory(Properties properties) {
        this.properties = properties;
    }

    private Connection databaseConnection() {

        Connection connection = null;

        try {
            Class.forName(properties.getProperty("driver"));
            connection = DriverManager.getConnection(properties.getProperty("url"));
            System.out.println("Connection made");
        } catch(ClassNotFoundException classNotFound) {
            System.out.println("Database driver class was not found.");
            classNotFound.printStackTrace();
        } catch(SQLException sqlException) {
            System.out.println("There was a SQL database access error.");
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }

        return connection;
    }

    public void addEmployeeToDatabase(String employeeId, String firstName,
            String lastName, String socialSecurityNumber, String department,
            String roomNumber, String phoneNumber) {

        Connection connection = databaseConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, employeeId);
            preparedStatement.setString(2, firstName);
            preparedStatement.setString(3, lastName);
            preparedStatement.setString(4, socialSecurityNumber);
            preparedStatement.setString(5, department);
            preparedStatement.setString(6, roomNumber);
            preparedStatement.setString(7, phoneNumber);

            preparedStatement.executeUpdate();

        } catch (SQLException sqlException) {
            System.out.println("There was an error attempting to create a SQL statement");
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }

    public Search searchEmployeeDatabase(String searchTerm, String searchType) {

    }
}
