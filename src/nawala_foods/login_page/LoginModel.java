package nawala_foods.login_page;

import java.sql.ResultSet;
import java.sql.SQLException;
import nawala_foods.DatabaseHelper;

public class LoginModel {

    private final DatabaseHelper db;

    private ResultSet res;

    private int executeQueryResult;

    private final String dbConnectionUrl = "jdbc:mysql://localhost:3306/nawala_foods";

    private final String dbUserName = "root";

    private final String dbUserPasssword = "nawala@5584";

    public LoginModel() throws ClassNotFoundException, SQLException {
        db = new DatabaseHelper();
        db.openConnection(dbConnectionUrl, dbUserName, dbUserPasssword);
    }

    public ResultSet getUserNamePasswordFromDb(String tableName) throws SQLException {
        String query = "SELECT * FROM " + tableName + " ";
        res = db.executeGetData(query);
        return res;
    }

    public int updateUserPassword(String password, String tableName) throws SQLException {
        String sql = "UPDATE " + tableName + " SET password = '" + password + "' ";
        executeQueryResult = db.executeInsertQuery(sql);
        return executeQueryResult;
    }

}
