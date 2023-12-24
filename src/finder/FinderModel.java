
package finder;

import java.sql.ResultSet;
import java.sql.SQLException;
import nawala_foods.DatabaseHelper;

public class FinderModel {
    private final DatabaseHelper db;

    private ResultSet res;

    private int executeQueryResult;

    private final String dbConnectionUrl = "jdbc:mysql://localhost:3306/nawala_foods";

    private final String dbUserName = "root";

    private final String dbUserPasssword = "nawala@5584";

    public FinderModel() throws ClassNotFoundException, SQLException{
        db = new DatabaseHelper();
        db.openConnection(dbConnectionUrl, dbUserName, dbUserPasssword);
    }
    
    public ResultSet getDataForItemFinder() throws SQLException{
        String query = "SELECT * FROM nawala_foods.ic_item";
        res = db.executeGetData(query);
        return res;
    }
    
     public ResultSet getDataForDocumentFinder(String date) throws SQLException{
        String query = "SELECT * FROM nawala_foods.sale where DATE_FORMAT(date, '%Y-%m-%d') = '" + date + "' ";
        res = db.executeGetData(query);
        return res;
    }
}
