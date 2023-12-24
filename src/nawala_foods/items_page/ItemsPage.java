package nawala_foods.items_page;

import finder.ItemFinder;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import nawala_foods.login_page.AdminLogin;
import nawala_foods.login_page.UserLogin;
import interfaces.ItemDataReceiver;
import java.awt.event.KeyEvent;
public class ItemsPage extends javax.swing.JPanel implements ItemDataReceiver {

    private ItemsModel itemsModel;

    private ResultSet res;

    private DefaultTableModel itemsTableModel;

    public static boolean itemFinderShown = false;

    public ItemsPage() {
        initComponents();
        init();
    }

    private void init() {
        try {
            itemsModel = new ItemsModel();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(ItemsPage.this, ex.getMessage());
        }
        tableStyle();
        setDataToItemsTable();
        finderShortCut();
        addItemShortCut();
        deleteItemShortCut();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        itemsTable = new javax.swing.JTable();
        searchBtn = new javax.swing.JLabel();
        itemNameField = new CustomComponents.RoundedTextField();
        itemSaleRateField = new CustomComponents.RoundedTextField();
        itemCodeField = new CustomComponents.RoundedTextField();
        itemPurchaseRateField = new CustomComponents.RoundedTextField();
        addItemBtn = new CustomComponents.RoundedButton();
        deleteItemBtn = new CustomComponents.RoundedButton();

        setBackground(new java.awt.Color(18, 53, 36));
        setMinimumSize(new java.awt.Dimension(1080, 684));
        setPreferredSize(new java.awt.Dimension(1080, 684));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Item Code :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(43, 48, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Item Name :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Item Sale Rate :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Item Purchase Rate :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, -1, -1));

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
        itemsTable.setGridColor(new java.awt.Color(0, 0, 0));
        itemsTable.setRowHeight(35);
        itemsTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                itemsTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(itemsTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 661, -1));

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, 46));

        itemNameField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemNameField.setLineColor(new java.awt.Color(255, 254, 254));
        add(itemNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 210, 30));

        itemSaleRateField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemSaleRateField.setLineColor(new java.awt.Color(255, 254, 254));
        itemSaleRateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemSaleRateFieldKeyTyped(evt);
            }
        });
        add(itemSaleRateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 210, 30));

        itemCodeField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemCodeField.setLineColor(new java.awt.Color(255, 254, 254));
        itemCodeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemCodeFieldFocusLost(evt);
            }
        });
        add(itemCodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 210, 30));

        itemPurchaseRateField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemPurchaseRateField.setLineColor(new java.awt.Color(255, 254, 254));
        itemPurchaseRateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemPurchaseRateFieldKeyTyped(evt);
            }
        });
        add(itemPurchaseRateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 210, 30));

        addItemBtn.setForeground(new java.awt.Color(18, 53, 36));
        addItemBtn.setText("Add");
        addItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        addItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addItemBtnActionPerformed(evt);
            }
        });
        add(addItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 80, 70, 30));

        deleteItemBtn.setForeground(new java.awt.Color(18, 53, 36));
        deleteItemBtn.setText("Delete");
        deleteItemBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        deleteItemBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteItemBtnActionPerformed(evt);
            }
        });
        add(deleteItemBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 160, 70, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void setDataToItemsTable() {
        try {
            res = itemsModel.getItemsPageTableData();
            while (res.next()) {
                String data[] = {res.getString("code"), res.getString("name"), String.valueOf(res.getDouble("sale_rate")), String.valueOf(res.getDouble("purchase_rate"))};
                itemsTableModel.addRow(data);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(ItemsPage.this, ex.getMessage());
        }
    }

    private void showItemsFinder() throws ClassNotFoundException, SQLException{

        new ItemFinder(this).setVisible(true);
        // Set the itemFinderShown flag to true
        ItemsPage.itemFinderShown = true;
    }

    // method for open finder with shortcut Ctrl + F
    private void finderShortCut() {

        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "openFinder");
        actionMap.put("openFinder", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    ItemFinder.pageOpen = "itemsPage";
                try {
                    showItemsFinder();
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(ItemsPage.this, ex.getMessage());
                }
            }
        });
    }

    // method for add item with shortcut Ctrl + A
    private void addItemShortCut() {

        KeyStroke keyStroke = KeyStroke.getKeyStroke("control S");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "addItem");
        actionMap.put("addItem", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AdminLogin.isAdminLogin) {
                    insertItemsIntoDb();
                } else if (UserLogin.isUserLogin) {
                    JOptionPane.showMessageDialog(ItemsPage.this, "Only Admin can add items");
                }
            }
        });

    }

    // method for delete item with shortcut Ctrl + D
    private void deleteItemShortCut() {

        KeyStroke keyStroke = KeyStroke.getKeyStroke("control D");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "deleteItem");
        actionMap.put("deleteItem", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AdminLogin.isAdminLogin) {
                    deleteItemFromDb();
                } else if (UserLogin.isUserLogin) {
                    JOptionPane.showMessageDialog(ItemsPage.this, "Only Admin can delete items");
                }
            }
        });

    }

    @Override
    public void getDataFromFinder(String itemCode, String itemName, String itemSaleRate, String itemPurchaseRate) {
        if (AdminLogin.isAdminLogin) {
            itemCodeField.setText(itemCode);
            itemNameField.setText(itemName);
            itemSaleRateField.setText(itemSaleRate);
            itemPurchaseRateField.setText(itemPurchaseRate);
        } else if (UserLogin.isUserLogin) {
            JOptionPane.showMessageDialog(this, "Only Admin can get data from finder");
        }
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

    private boolean isDataValid() {
        boolean valid = true;

        if (itemCodeField.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "please enter valid item code");
            valid = false;
        }

        if (itemNameField.getText().length() < 3) {
            JOptionPane.showMessageDialog(this, "please enter valid item name");
            valid = false;
        }

        if (itemSaleRateField.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "please enter valid item sale rate");
            valid = false;
        }

        if (itemPurchaseRateField.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "please enter valid item purchase rate");
            valid = false;
        }

        return valid;
    }


    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        ItemFinder.pageOpen = "itemsPage";

        if (!itemFinderShown) {

            try {
                showItemsFinder();
            } catch (ClassNotFoundException | SQLException ex) {
               JOptionPane.showMessageDialog(ItemsPage.this, ex.getMessage());
            }

        }
    }//GEN-LAST:event_searchBtnMouseClicked

    private void getDataOnItemCodeFocusLost() {
        try {
            res = itemsModel.getItem(itemCodeField.getText().trim());

            if (res.next()) {

                do {

                    addItemBtn.setText("Save");
                    itemNameField.setText(res.getString("name"));
                    itemSaleRateField.setText(String.valueOf(res.getDouble("sale_rate")));
                    itemPurchaseRateField.setText(String.valueOf(res.getDouble("purchase_rate")));

                } while (res.next());

            } else {

                addItemBtn.setText("Add");
                itemNameField.setText("");
                itemSaleRateField.setText("");
                itemPurchaseRateField.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(ItemsPage.this, ex.getMessage());
        }
    }

    private void itemCodeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemCodeFieldFocusLost
        if (AdminLogin.isAdminLogin) {
            getDataOnItemCodeFocusLost();
        }
    }//GEN-LAST:event_itemCodeFieldFocusLost

    private void itemSaleRateFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemSaleRateFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_itemSaleRateFieldKeyTyped

    private void itemPurchaseRateFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemPurchaseRateFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_itemPurchaseRateFieldKeyTyped

    private void insertItemsIntoDb() {

        if (isDataValid()) {

            try {
                int insertItem = itemsModel.insertItem(itemCodeField.getText().trim(), itemNameField.getText().trim(), Double.parseDouble(itemSaleRateField.getText().trim()), Double.parseDouble(itemPurchaseRateField.getText().trim()), addItemBtn.getText().equals("Add"));

                if (insertItem == 1) {

                    itemsTableModel.setRowCount(0);
                    setDataToItemsTable();
                    JOptionPane.showMessageDialog(this, "item added successfully");
                    itemCodeField.setText("");
                    itemNameField.setText("");
                    itemSaleRateField.setText("");
                    itemPurchaseRateField.setText("");

                } else {

                    JOptionPane.showMessageDialog(this, "item not added");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(ItemsPage.this, ex.getMessage());
            }
        }
    }

    private void addItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addItemBtnActionPerformed
        if (AdminLogin.isAdminLogin) {
            insertItemsIntoDb();
        } else if (UserLogin.isUserLogin) {
            JOptionPane.showMessageDialog(this, "Only Admin can add items");
        }
    }//GEN-LAST:event_addItemBtnActionPerformed

    private void deleteItemFromDb() {

        try {
            int deleteItem = itemsModel.deleteItem(itemCodeField.getText().trim());

            if (deleteItem == 1) {

                itemsTableModel.setRowCount(0);
                setDataToItemsTable();
                JOptionPane.showMessageDialog(this, "item deleted successfully");
                addItemBtn.setText("Add");
                itemCodeField.setText("");
                itemNameField.setText("");
                itemSaleRateField.setText("");
                itemPurchaseRateField.setText("");

            } else {

                JOptionPane.showMessageDialog(this, "item not deleted");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(ItemsPage.this, ex.getMessage());
        }

    }

    private void deleteItemBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteItemBtnActionPerformed
        if (AdminLogin.isAdminLogin) {
            deleteItemFromDb();
        } else if (UserLogin.isUserLogin) {
            JOptionPane.showMessageDialog(this, "Only Admin can delete items");
        }
    }//GEN-LAST:event_deleteItemBtnActionPerformed

    private void getSelectedRowData() {

        if (itemsTable.getSelectedRowCount() == 1) {

            itemCodeField.setText(itemsTableModel.getValueAt(itemsTable.getSelectedRow(), 0).toString());
            itemNameField.setText(itemsTableModel.getValueAt(itemsTable.getSelectedRow(), 1).toString());
            itemSaleRateField.setText(itemsTableModel.getValueAt(itemsTable.getSelectedRow(), 2).toString());
            itemPurchaseRateField.setText(itemsTableModel.getValueAt(itemsTable.getSelectedRow(), 3).toString());

            addItemBtn.setText("Save");
        }
    }

    private void itemsTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_itemsTableMouseClicked
        if (AdminLogin.isAdminLogin) {
            getSelectedRowData();
        } else if (UserLogin.isUserLogin) {
            JOptionPane.showMessageDialog(this, "Only Admin can get data from table");
        }
    }//GEN-LAST:event_itemsTableMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomComponents.RoundedButton addItemBtn;
    private CustomComponents.RoundedButton deleteItemBtn;
    private CustomComponents.RoundedTextField itemCodeField;
    private CustomComponents.RoundedTextField itemNameField;
    private CustomComponents.RoundedTextField itemPurchaseRateField;
    private CustomComponents.RoundedTextField itemSaleRateField;
    private javax.swing.JTable itemsTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel searchBtn;
    // End of variables declaration//GEN-END:variables
}
