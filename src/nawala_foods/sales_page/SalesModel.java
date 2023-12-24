package nawala_foods.sales_page;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import nawala_foods.DatabaseHelper;

public class SalesModel {

    private final DatabaseHelper db;

    private ResultSet res;

    private int executeQueryResult;

    private final String dbConnectionUrl = "jdbc:mysql://localhost:3306/nawala_foods";

    private final String dbUserName = "root";

    private final String dbUserPasssword = "nawala@5584";

    public SalesModel() throws ClassNotFoundException, SQLException {
        db = new DatabaseHelper();
        db.openConnection(dbConnectionUrl, dbUserName, dbUserPasssword);
    }

    public ResultSet getDocId() throws SQLException {
        String query = "SELECT doc_id FROM nawala_foods.sale order by doc_id desc limit 1";
        res = db.executeGetData(query);
        return res;
    }

    public ResultSet getItem(String itemCode) throws SQLException {
        String query = "SELECT * FROM nawala_foods.ic_item where code = '" + itemCode + "' ";
        res = db.executeGetData(query);
        return res;
    }

    public int insertSale(String docId, String customerName, String customerPhone, String deliveryAddress, String dateAndTime, DefaultTableModel model, boolean isNew) throws Exception {

        db.autoCommitTrans(false);

        try {

            if (isNew) {

                String insertSaleSql = "insert into nawala_foods.sale(doc_id, date, customer_name, customer_phone, delivery_address) " + "values(" + docId + ", '" + dateAndTime + "', '" + customerName + "', '" + customerPhone + "', '" + deliveryAddress + "')";
                db.executeInsertQuery(insertSaleSql);

            } else {

                String updateSaleSql = "UPDATE nawala_foods.sale SET customer_name = '" + customerName + "', customer_phone = '" + customerPhone + "', delivery_address = '" + deliveryAddress + "'  WHERE doc_id = " + docId + " ";
                db.executeInsertQuery(updateSaleSql);
            }

            String deleteSaleDataSql = "delete from nawala_foods.sale_data where doc_id = " + docId + " ";
            db.executeDeleteQuery(deleteSaleDataSql);

            for (int i = 0; i < model.getRowCount(); i++) {

                String itemCode = String.valueOf(model.getValueAt(i, 0));
                String itemName = String.valueOf(model.getValueAt(i, 1));
                Double rate = Double.valueOf(model.getValueAt(i, 2).toString());
                int quantity = Integer.parseInt(model.getValueAt(i, 3).toString());
                Double amount = Double.valueOf(model.getValueAt(i, 4).toString());

                String insertSaleDataSql = "insert into nawala_foods.sale_data(doc_id, item_code, item_name, rate, quantity, amount) " + "values(" + docId + ", '" + itemCode + "', '" + itemName + "', " + rate + ", " + quantity + ", " + amount + ")";
                db.executeInsertQuery(insertSaleDataSql);
            }

            db.commitTrans();
            db.autoCommitTrans(true);

        } catch (NumberFormatException | SQLException ex) {

            db.rollBackTrans();
            db.autoCommitTrans(true);

            return 0;
        }
        return 1;
    }

    public ResultSet getSaleItems(String docId) throws SQLException {
        String query = "SELECT * FROM nawala_foods.sale_data where doc_id = '" + docId + "' ";
        res = db.executeGetData(query);
        return res;
    }
}
