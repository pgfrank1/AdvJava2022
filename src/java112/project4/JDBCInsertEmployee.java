package java112.project4;

import java.sql.*;

public class JDBCInsertEmployee {

    public static void main(String[] args) {
        JDBCInsertEmployee run = new JDBCInsertEmployee();

        run.runInsert();
    }

    public void runInsert() {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/student",
                    "student", "student");

            statement = connection.createStatement();


            String queryString = "INSERT INTO employees VALUES (null, 'Patrick', 'Frank', '123-45-6789', 'Admin', '200', '123-4567')";

            System.out.println("Insert string: " + queryString);

            statement.executeUpdate(queryString);

        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (Exception exception) {
            System.err.println("General Error");
            exception.printStackTrace();
        }
    }
}
