import java.sql.*;

public class QueryMySQL {

    // For MySQL -> jdbc:mysql://hostname:portNumber/databaseName
    private static final String DATABASE_URL = "jdbc:mysql://MacBook-Pro-Ivan.local:8889/gradedThree";
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "root";

    public static void main(String args[])
    {
        String QUERY = "SELECT city, COUNT(city) AS number FROM supplier GROUP BY city ORDER BY COUNT(city) DESC"; // write a select query on any table in the selected DB
        // use try-with-resources to connect to and query the database
        try ( Connection connection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
              Statement statement = connection.createStatement();
              ResultSet result_set = statement.executeQuery(QUERY) )
        {
            System.out.println("Connected to MySQL server...\n");

            // get ResultSet's meta data
            ResultSetMetaData meta_data = result_set.getMetaData();
            int number_of_columns = meta_data.getColumnCount();

            // display the names of the columns in the result_set
            for (int i = 1; i <= number_of_columns; i++) {
                System.out.printf("%-8s\t", meta_data.getColumnLabel(i)); }

            System.out.println(); // newline

            // display query results
            while (result_set.next()) {
                for (int i = 1; i <= number_of_columns; i++) {
                    System.out.printf("%-8s\t", result_set.getObject(i)); }

                System.out.println(); // newline
            }
        } // AutoCloseable objects' close methods are called now
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
}


