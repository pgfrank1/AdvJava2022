package java112.project4;

import java.sql.*;

public class JDBCInsertEmployee {

    public static void main(String[] args) {
        JDBCInsertEmployee run = new JDBCInsertEmployee();

        run.runInsert(args);
    }

    public void runInsert(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection("jdbc:mysql://localhost/student",
                    "student", "student");

            statement = connection.createStatement();


            String queryString = "INSERT INTO employees (emp_id, first_name, last_name, ssn, dept, room, phone) VALUES (null, '" + args[0] + "', '" + args[1] + "', '"
                    + args[2] + "', '" + args[3] + "', '" + args[4] + "', '" + args[5] + "')";

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
