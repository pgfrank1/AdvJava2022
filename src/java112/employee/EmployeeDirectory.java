package java112.employee;

import java.sql.*;
import java.util.*;

public class EmployeeDirectory {

    private Properties properties;

    public EmployeeDirectory(Properties properties) {
        this.properties = properties;
    }

    private Connection databaseConnection(){

        try {
            Class.forName(properties.getProperty(''));
        } catch(ClassNotFoundException classNotFound) {
            classNotFound.printStackTrace();
        }


    }
}
