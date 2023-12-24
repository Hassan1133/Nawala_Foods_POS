package finder;

import interfaces.DocumentDataReceiver;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JPanel;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableRowSorter;
import nawala_foods.sales_page.SalesPage;

public class DocumentFinder extends javax.swing.JFrame {

    private DefaultTableModel documentTableModel;

    private ResultSet res;

    private final FinderModel finderModel;

    public static String pageOpen;

    private final DocumentDataReceiver documentDataReceiver;

    public DocumentFinder(DocumentDataReceiver documentDataReceiver) throws ClassNotFoundException, SQLException {
        initComponents();

        tableStyle();

        finderModel = new FinderModel();
        getDataForFinder();

        this.documentDataReceiver = (DocumentDataReceiver) (JPanel) documentDataReceiver; // Store the reference to the existing ItemsPage

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        documentTable = new javax.swing.JTable();
        closeBtn = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        searchField = new CustomComponents.RoundedTextField();
        minimizeBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(650, 520));
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 53, 36));
        jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(204, 204, 204), 3, true));
        jPanel1.setMinimumSize(new java.awt.Dimension(650, 520));
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 520));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        documentTable.setBackground(new java.awt.Color(255, 249, 246));
        documentTable.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        documentTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Doc ID", "Customer Name", "Customer Phone", "Delivery Address", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        documentTable.setRowHeight(30);
        documentTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                documentTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(documentTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 109, 589, 382));

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeBtnMousePressed(evt);
            }
        });
        jPanel1.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(621, 9, 20, 20));

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Search :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 62, -1, -1));

        searchField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchField.setLineColor(new java.awt.Color(255, 254, 254));
        searchField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchFieldKeyReleased(evt);
            }
        });
        jPanel1.add(searchField, new org.netbeans.lib.awtextra.AbsoluteConstraints(122, 64, 244, 27));

        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        minimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizeBtnMousePressed(evt);
            }
        });
        jPanel1.add(minimizeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 10, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    
    private void tableStyle() {
        JTableHeader header = documentTable.getTableHeader();
        header.setBackground(Color.WHITE);
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));

        documentTable.setBackground(Color.WHITE);

        documentTableModel = (DefaultTableModel) documentTable.getModel();

        // Create a DefaultTableCellRenderer with CENTER alignment
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Set the DefaultTableCellRenderer as the cell renderer for all columns
        documentTable.setDefaultRenderer(Object.class, centerRenderer);
    }

    private void closeFinder() {
        SalesPage.documentFinderShown = false;

        this.dispose();
    }

    private String getCurrentDateAndTime() {
        // Get the current date and time
        Date currentDate = new Date();

        // Format the date and time using SimpleDateFormat
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(currentDate);

        return formattedDate;
    }

    private void getDataForFinder() throws SQLException {

        res = finderModel.getDataForDocumentFinder(getCurrentDateAndTime());

        while (res.next()) {

            Object[] data = {String.valueOf(res.getInt("doc_id")), res.getString("customer_name"), res.getString("customer_phone"), res.getString("delivery_address"), new SimpleDateFormat("dd/MM/yyyy hh:mm a").format(res.getTimestamp("date"))};
            documentTableModel.addRow(data);
        }

    }

    private void sendSelectedRowData() {
        if (documentTable.getSelectedRow() != -1) {
            int selectedModelRowIndex = documentTable.convertRowIndexToModel(documentTable.getSelectedRow());

            String docId = documentTableModel.getValueAt(selectedModelRowIndex, 0).toString();
            String customerName = documentTableModel.getValueAt(selectedModelRowIndex, 1).toString();
            String customerPhone = documentTableModel.getValueAt(selectedModelRowIndex, 2).toString();
            String deliveryAddress = documentTableModel.getValueAt(selectedModelRowIndex, 3).toString();

            SwingUtilities.invokeLater(() -> {
                documentDataReceiver.getDataFromDocumentFinder(docId, customerName, customerPhone, deliveryAddress);
            });
            closeFinder();
        }
    }

    private void documentTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_documentTableMouseClicked
        sendSelectedRowData();
    }//GEN-LAST:event_documentTableMouseClicked

    private void closeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMousePressed
        closeFinder();
    }//GEN-LAST:event_closeBtnMousePressed

    private void searchFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchFieldKeyReleased
        searchDataFromTable();
    }//GEN-LAST:event_searchFieldKeyReleased

    private void minimizeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMousePressed
        setState(DocumentFinder.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnMousePressed

    // method for search data from table
    private void searchDataFromTable() {
        TableRowSorter<DefaultTableModel> rowSorter = new TableRowSorter<>(documentTableModel);
        documentTable.setRowSorter(rowSorter);
        rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchField.getText()));
    }

    public static void main(String args[]) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel closeBtn;
    private javax.swing.JTable documentTable;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel minimizeBtn;
    private CustomComponents.RoundedTextField searchField;
    // End of variables declaration//GEN-END:variables

}
