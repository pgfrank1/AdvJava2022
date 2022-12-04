package java112.project4;

import java.sql.*;

/**
 * This class shows how to create a prepared SQL statement using the entered
 * arguments from the user
 *
 * @author pgfrank
 * @version 1.0
 * @since 11.0
 *
 */
public class JDBCPreparedStatement {

    /**
     * The entry point of application.
     *
     * @param args the user input arguments
     */
    public static void main(String[] args) {
        JDBCPreparedStatement run = new JDBCPreparedStatement();

        run.runPreparedStatement(args);
    }

    /**
     * Attempts to connect to the database, create a prepared statement from the
     * user entered arguments, and add them to the specified table
     *
     * @param args the user input args
     */
    public void runPreparedStatement(String[] args) {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/student",
                    "student", "student");

            preparedStatement = connection.prepareStatement("INSERT INTO employees VALUES (null, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, args[0]);
            preparedStatement.setString(2, args[1]);
            preparedStatement.setString(3, args[2]);
            preparedStatement.setString(4, args[3]);
            preparedStatement.setString(5, args[4]);
            preparedStatement.setString(6, args[5]);

            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException classNotFoundException) {
            System.out.println("Class with specified name was not found");
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            System.out.println("There was an SQL error");
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }

    }

}
