package nawala_foods.sales_page;

import finder.DocumentFinder;
import finder.ItemFinder;
import interfaces.DocumentDataReceiver;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.util.Date;
import nawala_foods.DatabaseHelper;
import nawala_foods.login_page.AdminLogin;
import nawala_foods.login_page.UserLogin;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import interfaces.ItemDataReceiver;
import java.awt.event.KeyEvent;
import net.sf.jasperreports.engine.JasperPrintManager;

public class SalesPage extends javax.swing.JPanel implements ItemDataReceiver, DocumentDataReceiver {

    private SalesModel salesModel;

    private ResultSet res;

    private ImageIcon hoverIcon;

    private DefaultTableModel saleItemTableModel;

    public static boolean itemFinderShown = false;

    public static boolean documentFinderShown = false;

    public SalesPage() {
        initComponents();
        init();
    }

    private void init() {

        try {
            salesModel = new SalesModel();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
        }

        tableStyle();
        itemFinderShortCut();
        documentFinderShortCut();
        saleShortCut();
        addSaleToTableShortCut();
        deleteSaleFromTableShortCut();
        deliveryButtonSelectionWorking();
        deliveryShortCut();
        printBtnShortCut();
    }

    @Override
    public void getDataFromFinder(String itemCode, String itemName, String itemRate, String itemPurchaseRate) {
        itemCodeField.setText(itemCode);
        itemNameField.setText(itemName);
        itemRateField.setText(itemRate);
        itemQuantityField.setText("1");
        itemQuantityField.requestFocusInWindow();
    }

    @Override
    public void getDataFromDocumentFinder(String docId, String customerName, String customerPhone, String deliveryAddress) {
        getSaleItemsDataFromDb(docId);
        documentIdField.setText(docId);
        customerNameField.setText(customerName);
        if (!customerPhone.equals("none") && !deliveryAddress.equals("none")) {
            deliveryBtn.setSelected(true);
            customerPhoneField.setText(customerPhone);
            deliveryAddressField.setText(deliveryAddress);
            customerPhoneField.setEditable(true);
            deliveryAddressField.setEditable(true);
        } else {
            deliveryBtn.setSelected(false);
            customerPhoneField.setText(customerPhone);
            deliveryAddressField.setText(deliveryAddress);
        }
    }

    private void getSaleItemsDataFromDb(String docId) {

        saleItemTableModel.setRowCount(0);

        try {
            res = salesModel.getSaleItems(docId);

            while (res.next()) {

                Object[] data = {res.getString("item_code"), res.getString("item_name"), String.valueOf(res.getDouble("rate")), String.valueOf(res.getInt("quantity")), String.valueOf(res.getDouble("amount"))};
                saleItemTableModel.addRow(data);

            }
            addSaleBtn.setText("Save Sale");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
        }
    }

    // method for open itemFinderShortcut with shortcut F5
    private void itemFinderShortCut() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_F5, 0);
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "openItemFinder");
        actionMap.put("openItemFinder", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemFinder.pageOpen = "salesPage";
                try {
                    showItemFinder();
                } catch (ClassNotFoundException | SQLException ex) {
                    JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
                }

            }
        });
    }

    // method for open docuemntFinderShortcut with Ctrl + F
    private void documentFinderShortCut() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke("control F");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "openDocumentFinder");
        actionMap.put("openDocumentFinder", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AdminLogin.isAdminLogin) {
                    try {
                        showDocumentFinder();
                    } catch (ClassNotFoundException | SQLException ex) {
                        JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
                    }
                } else if (UserLogin.isUserLogin) {
                    JOptionPane.showMessageDialog(SalesPage.this, "Only Admin can open document finder");
                }
            }
        });
    }

    private void deliveryShortCut() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke("alt H");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "delivery");
        actionMap.put("delivery", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deliveryBtn.isSelected()) {
                    deliveryBtn.setSelected(false);
                    deliveryButtonSelectionWorking();
                } else {
                    deliveryBtn.setSelected(true);
                    deliveryButtonSelectionWorking();
                }
            }
        });
    }

    private void printBtnShortCut() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke("alt P");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "printBtn");
        actionMap.put("printBtn", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (printBtn.isSelected()) {
                    printBtn.setSelected(false);
                } else {
                    printBtn.setSelected(true);
                }
            }
        });
    }
    
    // method for sale Shortcut with shortcut Ctrl + S
    private void saleShortCut() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke("control S");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "salePrint");
        actionMap.put("salePrint", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSaleAndSaleDataIntoDb();
            }
        });
    }

    // method for addSaleToTable Shortcut with shortcut Alt + A
    private void addSaleToTableShortCut() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke("alt A");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "addSale");
        actionMap.put("addSale", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSaleToTable();
            }
        });
    }

    // method for deleteSaleFromTable Shortcut with shortcut Alt + D
    private void deleteSaleFromTableShortCut() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke("alt D");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "deleteSale");
        actionMap.put("deleteSale", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSaleFromTable();
            }
        });
    }

    private void printBill() {

        String path = "C:\\LogicWaveSolutions\\reports\\Sale.jrxml";

        String sql = "SELECT sale.doc_id, sale.date, sale.customer_name, sale.customer_phone, sale.delivery_address, sale_data.item_code, sale_data.item_name, sale_data.rate, sale_data.quantity, sale_data.amount FROM nawala_foods.sale INNER JOIN nawala_foods.sale_data ON sale.doc_id = sale_data.doc_id  WHERE sale.doc_id = " + documentIdField.getText();

        try {
            JasperDesign jd = JRXmlLoader.load(path);
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);

            JasperReport jr = JasperCompileManager.compileReport(jd);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, DatabaseHelper.databaseConnection);

//            JasperViewer.viewReport(jp);
            for (int i = 0; i < 1; i++) {
                JasperPrintManager.printReport(jp, false);
            }

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
        }
    }

    private void showDocumentFinder() throws ClassNotFoundException, SQLException {

        new DocumentFinder(this).setVisible(true);
        // Set the itemFinderShown flag to true
        documentFinderShown = true;
    }

    private void showItemFinder() throws ClassNotFoundException, SQLException {

        new ItemFinder(this).setVisible(true);
        // Set the itemFinderShown flag to true
        itemFinderShown = true;
    }

    private void tableStyle() {
        JTableHeader header = saleItemTable.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));

        saleItemTable.setBackground(Color.WHITE);

        saleItemTableModel = (DefaultTableModel) saleItemTable.getModel();

        // Create a DefaultTableCellRenderer with CENTER alignment
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Set the DefaultTableCellRenderer as the cell renderer for all columns
        saleItemTable.setDefaultRenderer(Object.class, centerRenderer);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        saleItemTable = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        searchBtn = new javax.swing.JLabel();
        itemCodeField = new CustomComponents.RoundedTextField();
        documentIdField = new CustomComponents.RoundedTextField();
        itemNameField = new CustomComponents.RoundedTextField();
        itemQuantityField = new CustomComponents.RoundedTextField();
        itemRateField = new CustomComponents.RoundedTextField();
        customerNameField = new CustomComponents.RoundedTextField();
        addSaleItem = new CustomComponents.RoundedButton();
        deleteSaleItem = new CustomComponents.RoundedButton();
        addSaleBtn = new CustomComponents.RoundedButton();
        itemNameField1 = new CustomComponents.RoundedTextField();
        jLabel7 = new javax.swing.JLabel();
        customerPhoneField = new CustomComponents.RoundedTextField();
        jLabel8 = new javax.swing.JLabel();
        deliveryAddressField = new CustomComponents.RoundedTextField();
        printBtn = new javax.swing.JCheckBox();
        deliveryBtn = new javax.swing.JCheckBox();

        setBackground(new java.awt.Color(18, 53, 36));
        setMinimumSize(new java.awt.Dimension(1080, 684));
        setPreferredSize(new java.awt.Dimension(1080, 684));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Document ID :");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Item Code :");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Item Name :");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, 100, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Item Rate :");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 140, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Quantity :");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 140, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Customer Name :");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, -1, -1));

        saleItemTable.setBackground(new java.awt.Color(255, 249, 246));
        saleItemTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        saleItemTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Item Code", "Item Name", "Item Sale Rate", "Quantity", "Amount"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        saleItemTable.setGridColor(new java.awt.Color(0, 0, 0));
        saleItemTable.setRowHeight(35);
        saleItemTable.setShowGrid(true);
        saleItemTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saleItemTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(saleItemTable);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 300, 578, 370));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(665, 204, -1, -1));

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/search.png"))); // NOI18N
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 10, -1, 44));

        itemCodeField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemCodeField.setLineColor(new java.awt.Color(255, 254, 254));
        itemCodeField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                itemCodeFieldFocusLost(evt);
            }
        });
        itemCodeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemCodeFieldKeyPressed(evt);
            }
        });
        add(itemCodeField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 190, 30));

        documentIdField.setEditable(false);
        documentIdField.setFocusable(false);
        documentIdField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        documentIdField.setLineColor(new java.awt.Color(255, 254, 254));
        add(documentIdField, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 190, 30));

        itemNameField.setEditable(false);
        itemNameField.setFocusable(false);
        itemNameField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemNameField.setLineColor(new java.awt.Color(255, 254, 254));
        itemNameField.setVerifyInputWhenFocusTarget(false);
        add(itemNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 190, 30));

        itemQuantityField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemQuantityField.setLineColor(new java.awt.Color(255, 254, 254));
        itemQuantityField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                itemQuantityFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemQuantityFieldKeyTyped(evt);
            }
        });
        add(itemQuantityField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 190, 30));

        itemRateField.setEditable(false);
        itemRateField.setFocusable(false);
        itemRateField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemRateField.setLineColor(new java.awt.Color(255, 254, 254));
        itemRateField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                itemRateFieldKeyTyped(evt);
            }
        });
        add(itemRateField, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 170, 190, 30));

        customerNameField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        customerNameField.setLineColor(new java.awt.Color(255, 254, 254));
        customerNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerNameFieldKeyPressed(evt);
            }
        });
        add(customerNameField, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 190, 30));

        addSaleItem.setForeground(new java.awt.Color(18, 53, 36));
        addSaleItem.setText("Add");
        addSaleItem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        addSaleItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSaleItemActionPerformed(evt);
            }
        });
        add(addSaleItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 70, 30));

        deleteSaleItem.setForeground(new java.awt.Color(18, 53, 36));
        deleteSaleItem.setText("Delete");
        deleteSaleItem.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        deleteSaleItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteSaleItemActionPerformed(evt);
            }
        });
        add(deleteSaleItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 70, 30));

        addSaleBtn.setForeground(new java.awt.Color(18, 53, 36));
        addSaleBtn.setText("Add Sale");
        addSaleBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        addSaleBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addSaleBtnActionPerformed(evt);
            }
        });
        add(addSaleBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 100, 30));

        itemNameField1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        itemNameField1.setLineColor(new java.awt.Color(255, 254, 254));
        add(itemNameField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 190, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Customer Phone :");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 50, 140, -1));

        customerPhoneField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        customerPhoneField.setLineColor(new java.awt.Color(255, 254, 254));
        customerPhoneField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                customerPhoneFieldKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                customerPhoneFieldKeyTyped(evt);
            }
        });
        add(customerPhoneField, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 80, 190, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Delivery Address :");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 50, 140, -1));

        deliveryAddressField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        deliveryAddressField.setLineColor(new java.awt.Color(255, 254, 254));
        deliveryAddressField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                deliveryAddressFieldKeyPressed(evt);
            }
        });
        add(deliveryAddressField, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 80, 190, 30));

        printBtn.setBackground(new java.awt.Color(18, 53, 36));
        printBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setSelected(true);
        printBtn.setText("Print");
        add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, 30));

        deliveryBtn.setBackground(new java.awt.Color(18, 53, 36));
        deliveryBtn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deliveryBtn.setForeground(new java.awt.Color(255, 255, 255));
        deliveryBtn.setText("Delivery");
        deliveryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deliveryBtnActionPerformed(evt);
            }
        });
        add(deliveryBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void setDocId() {
        try {
            int integerId;
            res = salesModel.getDocId();

            if (res.next()) {
                integerId = res.getInt(1);
                integerId++;
                documentIdField.setText(String.valueOf(integerId));

            } else {
                integerId = 1;
                documentIdField.setText(String.valueOf(integerId));

            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
        }

    }

    // Method to check for duplicate rows in the JTable
    private boolean isDuplicateRow(String itemCode) {
        for (int i = 0; i < saleItemTableModel.getRowCount(); i++) {
            String existingItemCode = (String) saleItemTableModel.getValueAt(i, 0);
            if (itemCode.equals(existingItemCode)) {
                return true;
            }
        }
        return false;
    }

    private void addRowIfNotDuplicate(Object[] rowData) {
        String newItemCode = (String) rowData[0];
        if (!isDuplicateRow(newItemCode)) {
            saleItemTableModel.addRow(rowData);
            itemCodeField.setText("");
            itemNameField.setText("");
            itemRateField.setText("");
            itemQuantityField.setText("");
        } else {
            JOptionPane.showMessageDialog(this, "Item already added!");
            itemCodeField.setText("");
            itemNameField.setText("");
            itemRateField.setText("");
            itemQuantityField.setText("");
        }
    }

    private void addSaleToTable() {
        if (isDataValid()) {
            double itemRate = Double.parseDouble(itemRateField.getText());
            double itemQuantity = Double.parseDouble(itemQuantityField.getText());
            double itemTotalAmount = itemRate * itemQuantity;

            Object[] newRowData = {itemCodeField.getText(), itemNameField.getText(), itemRateField.getText(), itemQuantityField.getText(), String.valueOf(itemTotalAmount)};
            addRowIfNotDuplicate(newRowData);
        }
    }

    private void editSaleToTable() {
        if (saleItemTable.getSelectedRowCount() == 1) {

            double itemRate = Double.parseDouble(itemRateField.getText());
            double itemQuantity = Double.parseDouble(itemQuantityField.getText());
            double itemTotalAmount = itemRate * itemQuantity;

            saleItemTableModel.setValueAt(itemCodeField.getText(), saleItemTable.getSelectedRow(), 0);
            saleItemTableModel.setValueAt(itemNameField.getText(), saleItemTable.getSelectedRow(), 1);
            saleItemTableModel.setValueAt(itemRateField.getText(), saleItemTable.getSelectedRow(), 2);
            saleItemTableModel.setValueAt(itemQuantityField.getText(), saleItemTable.getSelectedRow(), 3);
            saleItemTableModel.setValueAt(String.valueOf(itemTotalAmount), saleItemTable.getSelectedRow(), 4);

            saleItemTable.removeRowSelectionInterval(saleItemTable.getSelectedRow(), saleItemTable.getSelectedRow());

            itemCodeField.setText("");
            itemNameField.setText("");
            itemRateField.setText("");
            itemQuantityField.setText("");

            addSaleItem.setText("Add");
        }
    }

    private void deleteSaleFromTable() {
        if (saleItemTable.getSelectedRowCount() == 1) {
            saleItemTableModel.removeRow(saleItemTable.getSelectedRow());

            itemCodeField.setText("");
            itemNameField.setText("");
            itemRateField.setText("");
            itemQuantityField.setText("");

            addSaleItem.setText("Add");
        }
    }

    private void saleItemTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saleItemTableMouseClicked

        if (saleItemTable.getSelectedRowCount() == 1) {

            itemCodeField.setText(saleItemTableModel.getValueAt(saleItemTable.getSelectedRow(), 0).toString());
            itemNameField.setText(saleItemTableModel.getValueAt(saleItemTable.getSelectedRow(), 1).toString());
            itemRateField.setText(saleItemTableModel.getValueAt(saleItemTable.getSelectedRow(), 2).toString());
            itemQuantityField.setText(saleItemTableModel.getValueAt(saleItemTable.getSelectedRow(), 3).toString());

            addSaleItem.setText("Save");

            itemQuantityField.requestFocusInWindow();
        }
    }//GEN-LAST:event_saleItemTableMouseClicked

    private boolean isDataValid() {

        boolean valid = true;

        if (itemCodeField.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "please enter valid item code");
            valid = false;
        }

        if (itemQuantityField.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "please enter valid item quantity");
            valid = false;
        }

        if (customerNameField.getText().length() < 3) {
            JOptionPane.showMessageDialog(this, "please enter valid customer name");
            valid = false;
        }

        return valid;
    }

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        ItemFinder.pageOpen = "salesPage";

        if (!itemFinderShown) {

            try {
                showItemFinder();
            } catch (ClassNotFoundException | SQLException ex) {
                JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
            }

        }
    }//GEN-LAST:event_searchBtnMouseClicked

    private void itemCodeFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_itemCodeFieldFocusLost
        try {
            res = salesModel.getItem(itemCodeField.getText().trim());

            if (res.next()) {

                do {

                    itemNameField.setText(res.getString("name"));
                    itemRateField.setText(String.valueOf(res.getDouble("sale_rate")));
                    itemQuantityField.setText("1");

                } while (res.next());

            } else {

                itemNameField.setText("");
                itemRateField.setText("");
                itemQuantityField.setText("");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
        }
    }//GEN-LAST:event_itemCodeFieldFocusLost

    private void itemQuantityFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemQuantityFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_itemQuantityFieldKeyTyped

    private void itemRateFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemRateFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_itemRateFieldKeyTyped

    private void addSaleItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleItemActionPerformed
        if (addSaleItem.getText().equals("Add")) {
            addSaleToTable();
        } else {
            editSaleToTable();
        }
    }//GEN-LAST:event_addSaleItemActionPerformed

    private void deleteSaleItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteSaleItemActionPerformed
        deleteSaleFromTable();
    }//GEN-LAST:event_deleteSaleItemActionPerformed

    private boolean isSaleValid() {
        boolean valid = true;

        if (documentIdField.getText().length() < 1) {
            JOptionPane.showMessageDialog(this, "document Id not assigned");
            valid = false;
        }

        if (customerNameField.getText().length() < 3) {
            JOptionPane.showMessageDialog(this, "please enter valid customer name");
            valid = false;
        }
        if (customerPhoneField.getText().length() < 3 || customerPhoneField.getText().length() > 11) {
            if (deliveryBtn.isSelected()) {
                JOptionPane.showMessageDialog(this, "please enter valid customer phone number");
                valid = false;
            }
        }
        if (deliveryAddressField.getText().length() < 3) {
            if (deliveryBtn.isSelected()) {
                JOptionPane.showMessageDialog(this, "please enter valid delivery address");
                valid = false;
            }
        }

        if (saleItemTableModel.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "please enter sale item");
            valid = false;
        }

        return valid;
    }

    private String getCurrentDateAndTime() {
        // Get the current date and time
        Date currentDate = new Date();

        // Format the date and time using SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = sdf.format(currentDate);

        return formattedDate;
    }

    private int addSaleIntoDb() {

        int insertSale = 0;

        try {
            insertSale = salesModel.insertSale(documentIdField.getText(), customerNameField.getText(), customerPhoneField.getText(), deliveryAddressField.getText(), getCurrentDateAndTime(), saleItemTableModel, addSaleBtn.getText().equals("Add Sale"));

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(SalesPage.this, ex.getMessage());
        }

        return insertSale;
    }

    private void addSaleAndSaleDataIntoDb() {

        if (documentIdField.getText().length() < 1) {
            setDocId();
        }

        if (isSaleValid()) {

            int insertSale = addSaleIntoDb();

            if (insertSale == 1) {
                if (printBtn.isSelected()) {
                    printBill();
                }
                JOptionPane.showMessageDialog(this, "Sale Done");
                clearFields();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Sale");
                clearFields();
            }
        }
    }

    private void clearFields() {

        addSaleBtn.setText("Add Sale");
        documentIdField.setText("");
        customerNameField.setText("");
        if (deliveryBtn.isSelected()) {
            deliveryBtn.setSelected(false);
            deliveryButtonSelectionWorking();
        }
        saleItemTableModel.setRowCount(0);

    }

    private void addSaleBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addSaleBtnActionPerformed
        addSaleAndSaleDataIntoDb();
    }//GEN-LAST:event_addSaleBtnActionPerformed

    private void customerPhoneFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerPhoneFieldKeyTyped
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }//GEN-LAST:event_customerPhoneFieldKeyTyped

    private void deliveryButtonSelectionWorking() {
        if (deliveryBtn.isSelected()) {
            customerPhoneField.setEditable(true);
            deliveryAddressField.setEditable(true);
            customerNameField.requestFocusInWindow();

        } else {
            customerPhoneField.setText("none");
            deliveryAddressField.setText("none");
            customerPhoneField.setEditable(false);
            deliveryAddressField.setEditable(false);
            customerNameField.requestFocusInWindow();
        }
    }

    private void deliveryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deliveryBtnActionPerformed
        deliveryButtonSelectionWorking();
    }//GEN-LAST:event_deliveryBtnActionPerformed

    private void customerNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerNameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (deliveryBtn.isSelected()) {
                customerPhoneField.requestFocusInWindow();
            } else {
                itemCodeField.requestFocusInWindow();
            }
        }
    }//GEN-LAST:event_customerNameFieldKeyPressed

    private void customerPhoneFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerPhoneFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            deliveryAddressField.requestFocusInWindow();
        }
    }//GEN-LAST:event_customerPhoneFieldKeyPressed

    private void deliveryAddressFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_deliveryAddressFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            itemCodeField.requestFocusInWindow();
        }
    }//GEN-LAST:event_deliveryAddressFieldKeyPressed

    private void itemCodeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemCodeFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            itemQuantityField.requestFocusInWindow();
        }
    }//GEN-LAST:event_itemCodeFieldKeyPressed

    private void itemQuantityFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_itemQuantityFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (addSaleItem.getText().equals("Add")) {
                addSaleToTable();
            } else {
                editSaleToTable();
            }
        }
    }//GEN-LAST:event_itemQuantityFieldKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private CustomComponents.RoundedButton addSaleBtn;
    private CustomComponents.RoundedButton addSaleItem;
    private CustomComponents.RoundedTextField customerNameField;
    private CustomComponents.RoundedTextField customerPhoneField;
    private CustomComponents.RoundedButton deleteSaleItem;
    private CustomComponents.RoundedTextField deliveryAddressField;
    private javax.swing.JCheckBox deliveryBtn;
    private CustomComponents.RoundedTextField documentIdField;
    private CustomComponents.RoundedTextField itemCodeField;
    private CustomComponents.RoundedTextField itemNameField;
    private CustomComponents.RoundedTextField itemNameField1;
    private CustomComponents.RoundedTextField itemQuantityField;
    private CustomComponents.RoundedTextField itemRateField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBox printBtn;
    private javax.swing.JTable saleItemTable;
    private javax.swing.JLabel searchBtn;
    // End of variables declaration//GEN-END:variables
}
