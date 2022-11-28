package java112.project4;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBCPreparedStatement {

    public static void main(String[] args) {
        JDBCPreparedStatement run = new JDBCPreparedStatement();

        run.runPreparedStatement(args);
    }

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
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
        }

    }

}
