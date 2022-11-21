package java112.project4;

import javax.swing.plaf.nimbus.State;
import java.sql.*;

public class JDBCPreparedStatement {

    public static void main(String[] args) {
        JDBCPreparedStatement run = new JDBCPreparedStatement();

        run.runPreparedStatement();
    }

    public void runPreparedStatement() {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/student",
                    "student", "student");

            preparedStatement = connection.prepareStatement("INSERT INTO employees VALUES (null, ?, ?, ?, ?, ?, ?)");

            preparedStatement.setString(1, "Stephanie");
            preparedStatement.setString(2, "Frank");
            preparedStatement.setString(3, "987-65-4321");
            preparedStatement.setString(4, "HR");
            preparedStatement.setString(5, "300");
            preparedStatement.setString(6, "987-6543");

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
