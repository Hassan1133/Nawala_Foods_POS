package finder;

import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import nawala_foods.items_page.ItemsPage;
import nawala_foods.sales_page.SalesPage;
import interfaces.ItemDataReceiver;

public class ItemFinder extends javax.swing.JFrame {

    private DefaultTableModel itemsTableModel;

    private final FinderModel finderModel;

    private ResultSet res;

    public static String pageOpen;

    private final ItemDataReceiver dataReceiver;

    public ItemFinder(ItemDataReceiver dataReceiver) throws ClassNotFoundException, SQLException {
        initComponents();

        tableStyle();

        finderModel = new FinderModel();
        getDataForFinder();

        this.dataReceiver = (ItemDataReceiver) (JPanel) dataReceiver; // Store the reference to the existing ItemsPage

    }

    private void tableStyle() {
        JTableHeader header = itemsTable.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));

        itemsTable.setBackground(Color.WHITE);

        itemsTableModel = (DefaultTableModel) itemsTable.getModel();

        // Create a DefaultTableCellRenderer with CENTER alignment
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Set the DefaultTableCellRenderer as the cell renderer for all columns
        itemsTable.setDefaultRenderer(Object.class, centerRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        closeBtn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchField = new CustomComponents.RoundedTextField();
        minimizeButton = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 177, 0));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 53, 36));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        jPanel1.setMinimumSize(new java.awt.Dimension(610, 437));
        jPanel1.setPreferredSize(new java.awt.Dimension(610, 437));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        itemsTable.setBackground(new java.awt.Color(255, 249, 246));
        itemsTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Item Sale Rate", "Item Purchase Rate"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        itemsTable.setRowHeight(30);
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemsTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 95, 538, 310));

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeBtnMousePressed(evt);
            }
        });
        jPanel1.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(581, 9, 20, -1));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 48, -1, -1));

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchField.setLineColor(new java.awt.Color(255, 254, 254));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 50, 244, 27));

        minimizeButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        minimizeButton.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                minimizeButtonKeyPressed(evt);
            }
        });
        jPanel1.add(minimizeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 6, 20, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void closeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMousePressed

        closeFinder();
    }//GEN-LAST:event_closeBtnMousePressed

    private void closeFinder() {
        SalesPage.itemFinderShown = false;

        ItemsPage.itemFinderShown = false;

        this.dispose();
    }

    private void itemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMouseClicked
        sendSelectedRowData();
    }//GEN-LAST:event_itemsTableMouseClicked

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        searchDataFromTable();
    }//GEN-LAST:event_searchFieldKeyReleased

    private void minimizeButtonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_minimizeButtonKeyPressed
        setState(ItemFinder.ICONIFIED);
    }//GEN-LAST:event_minimizeButtonKeyPressed

    // method for search data from table
    private void searchDataFromTable() {
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(itemsTableModel);
        itemsTable.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchField.getText()));
    }

    private void sendSelectedRowData() {

        if (itemsTable.getSelectedRowCount() != -1) {

            int selectedModelRowIndex = itemsTable.convertRowIndexToModel(itemsTable.getSelectedRow());

            String itemCode = itemsTableModel.getValueAt(selectedModelRowIndex, 0).toString();
            String itemName = itemsTableModel.getValueAt(selectedModelRowIndex, 1).toString();
            String itemSaleRate = itemsTableModel.getValueAt(selectedModelRowIndex, 2).toString();
            String itemPurchaseRate = itemsTableModel.getValueAt(selectedModelRowIndex, 3).toString();

            if (pageOpen.equals("salesPage")) {

                SwingUtilities.invokeLater(() -> {

                    dataReceiver.getDataFromFinder(itemCode, itemName, itemSaleRate, itemPurchaseRate);

                });

            } else if (pageOpen.equals("itemsPage")) {

                SwingUtilities.invokeLater(() -> {

                    dataReceiver.getDataFromFinder(itemCode, itemName, itemSaleRate, itemPurchaseRate);

                });

            }
            closeFinder();
        }
    }

    private void getDataForFinder() throws SQLException {

        res = finderModel.getDataForItemFinder();

        while (res.next()) {

            Object[] data = {res.getString("code"), res.getString("name"), String.valueOf(res.getDouble("sale_rate")), String.valueOf(res.getDouble("purchase_rate"))};
            itemsTableModel.addRow(data);
        }

    }

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeBtn;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimizeButton;
    private CustomComponents.RoundedTextField searchField;
    // End of variables declaration//GEN-END:variables

}
