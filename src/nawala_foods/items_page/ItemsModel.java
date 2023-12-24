package nawala_foods.items_page;

import java.sql.ResultSet;
import java.sql.SQLException;
import nawala_foods.DatabaseHelper;

public class ItemsModel {

    private final DatabaseHelper db;

    private ResultSet res;

    private int executeQueryResult;

    private final String dbConnectionUrl = "jdbc:mysql://localhost:3306/nawala_foods";

    private final String dbUserName = "root";

    private final String dbUserPasssword = "nawala@5584";

    public ItemsModel() throws ClassNotFoundException, SQLException{
        db = new DatabaseHelper();
        db.openConnection(dbConnectionUrl, dbUserName, dbUserPasssword);
    }

    public int insertItem(String itemCode, String itemName, double itemSaleRate, double itemPurchaseRate, boolean isNew) throws SQLException{

        String sql = null;

        if (isNew) {

            sql = "insert into nawala_foods.ic_item(code,name,sale_rate,purchase_rate) " + "values('" + itemCode + "', '" + itemName + "', " + itemSaleRate + "," + itemPurchaseRate + ")";

        } else{

            sql = "UPDATE nawala_foods.ic_item SET name = '" + itemName + "', sale_rate = " + itemSaleRate + ", purchase_rate = " + itemPurchaseRate + " WHERE code = '" + itemCode + "' ";

        }

        executeQueryResult = db.executeInsertQuery(sql);
        return executeQueryResult;
    }

    public ResultSet getItem(String itemCode) throws SQLException{
        String query = "SELECT * FROM nawala_foods.ic_item where code = '" + itemCode + "' ";
        res = db.executeGetData(query);
        return res;
    }

    public int deleteItem(String itemCode) throws SQLException{
        String sql = "delete FROM nawala_foods.ic_item where code = '" + itemCode + "' ";
        executeQueryResult = db.executeDeleteQuery(sql);
        return executeQueryResult;
    }

    public ResultSet getItemsPageTableData() throws SQLException{
        String query = "SELECT * FROM nawala_foods.ic_item";
        res = db.executeGetData(query);
        return res;
    }
}
