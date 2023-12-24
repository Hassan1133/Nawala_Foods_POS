package nawala_foods;

import java.sql.*;

public class DatabaseHelper {

    public static Connection databaseConnection;
    private PreparedStatement pt;
    private ResultSet res;
    private int rowEffetced;

    public boolean openConnection(String dbUrl, String dbUserName, String dbPassword) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        databaseConnection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
        return true;
    }

    public int executeInsertQuery(String query) throws SQLException {

        pt = databaseConnection.prepareStatement(query);
        rowEffetced = pt.executeUpdate();

        return rowEffetced;
    }

    public ResultSet executeGetData(String query) throws SQLException {

        pt = databaseConnection.prepareStatement(query);
        res = pt.executeQuery(query);
        return res;
    }

    public int executeDeleteQuery(String query) throws SQLException {

        pt = databaseConnection.prepareStatement(query);
        rowEffetced = pt.executeUpdate();
        return rowEffetced;
    }

    public void commitTrans() throws SQLException {

        databaseConnection.commit();

    }

    public void rollBackTrans() throws SQLException {

        databaseConnection.rollback();

    }

    public void autoCommitTrans(boolean flag) throws SQLException {
        databaseConnection.setAutoCommit(flag);
    }
}
