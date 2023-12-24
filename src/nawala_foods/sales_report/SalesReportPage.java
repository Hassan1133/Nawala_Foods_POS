package nawala_foods.sales_report;

import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import nawala_foods.DatabaseHelper;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class SalesReportPage extends javax.swing.JPanel {

    public SalesReportPage() {
        initComponents();
        printSaleReportShortCut();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        getSaleReportBtn = new CustomComponents.RoundedButton();
        fromDateField = new com.toedter.calendar.JDateChooser();
        toDateField = new com.toedter.calendar.JDateChooser();
        reportType = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(18, 53, 36));
        setMinimumSize(new java.awt.Dimension(1080, 684));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sale's Report with Date");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("From :");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("To :");

        getSaleReportBtn.setForeground(new java.awt.Color(18, 53, 36));
        getSaleReportBtn.setText("Get Report");
        getSaleReportBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        getSaleReportBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getSaleReportBtnActionPerformed(evt);
            }
        });

        fromDateField.setDateFormatString("dd/MM/yyyy");
        fromDateField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        toDateField.setDateFormatString("dd/MM/yyyy");
        toDateField.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        reportType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select an option", "Detail Report", "Items Report" }));
        reportType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reportTypeActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Report Type :");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(243, 243, 243)
                        .addComponent(jLabel3))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(reportType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(104, 104, 104)
                                .addComponent(getSaleReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(86, 86, 86)))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(fromDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(104, 104, 104)
                            .addComponent(toDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(521, 521, 521))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fromDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(toDateField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jLabel4)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reportType, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(getSaleReportBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(359, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // method for printSaleReport Shortcut with shortcut Ctrl + P 
    private void printSaleReportShortCut() {
        KeyStroke keyStroke = KeyStroke.getKeyStroke("control P");
        InputMap inputMap = this.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = this.getActionMap();

        inputMap.put(keyStroke, "saleReport");
        actionMap.put("saleReport", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isDataValid()) {
                    if (reportType.getSelectedItem().toString().equals("Detail Report")) {
                        printSaleReport();
                    } else if (reportType.getSelectedItem().toString().equals("Items Report")) {
                        printItemSaleReport();
                    }
                }
            }
        });
    }

    private void printSaleReport() {

        String path = "C:\\LogicWaveSolutions\\reports\\SalesReportByDate.jrxml";

        String sql = "SELECT sale.doc_id, sale.date, sale.customer_name, sale_data.item_name, sale_data.rate, sale_data.quantity, sale_data.amount FROM nawala_foods.sale INNER JOIN nawala_foods.sale_data ON sale.doc_id = sale_data.doc_id WHERE DATE(sale.date) BETWEEN STR_TO_DATE('" + new SimpleDateFormat("dd/MM/yyyy").format(fromDateField.getDate()) + "', '%e/%c/%Y') AND STR_TO_DATE('" + new SimpleDateFormat("dd/MM/yyyy").format(toDateField.getDate()) + "', '%e/%c/%Y')";

        try {
            JasperDesign jd = JRXmlLoader.load(path);
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);

            JasperReport jr = JasperCompileManager.compileReport(jd);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, DatabaseHelper.databaseConnection);

            JasperViewer jasperViewer = new JasperViewer(jp, false);
            jasperViewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jasperViewer.setVisible(true);

            fromDateField.setDate(null);
            toDateField.setDate(null);
            reportType.setSelectedIndex(0);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(SalesReportPage.this, ex.getMessage());
        }

    }

    private void printItemSaleReport() {

        String path = "C:\\LogicWaveSolutions\\reports\\ItemSaleReportByDate.jrxml";

        String sql = "SELECT sd.item_code, sd.item_name, SUM(sd.quantity) AS total_count, SUM(sd.amount) AS total_sale FROM nawala_foods.sale AS s INNER JOIN nawala_foods.sale_data AS sd ON s.doc_id = sd.doc_id WHERE DATE(s.date) BETWEEN STR_TO_DATE('" + new SimpleDateFormat("dd/MM/yyyy").format(fromDateField.getDate()) + "', '%e/%c/%Y') AND STR_TO_DATE('" + new SimpleDateFormat("dd/MM/yyyy").format(toDateField.getDate()) + "', '%e/%c/%Y') GROUP BY sd.item_code, sd.item_name";

        try {
            JasperDesign jd = JRXmlLoader.load(path);
            JRDesignQuery query = new JRDesignQuery();
            query.setText(sql);
            jd.setQuery(query);

            JasperReport jr = JasperCompileManager.compileReport(jd);

            JasperPrint jp = JasperFillManager.fillReport(jr, null, DatabaseHelper.databaseConnection);

            JasperViewer jasperViewer = new JasperViewer(jp, false);
            jasperViewer.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
            jasperViewer.setVisible(true);
            
            fromDateField.setDate(null);
            toDateField.setDate(null);
            reportType.setSelectedIndex(0);

        } catch (JRException ex) {
            JOptionPane.showMessageDialog(SalesReportPage.this, ex.getMessage());
        }

    }

    private boolean isDataValid() {
        boolean valid = true;

        if (fromDateField.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please enter From date");
            valid = false;
        }

        if (toDateField.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Please enter To date");
            valid = false;
        }

        if (reportType.getSelectedItem().toString().equals("Select an option")) {
            JOptionPane.showMessageDialog(this, "Please select report type");
            valid = false;
        }

        return valid;
    }


    private void getSaleReportBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getSaleReportBtnActionPerformed
        if (isDataValid()) {
            if (reportType.getSelectedItem().toString().equals("Detail Report")) {
                printSaleReport();
            } else if (reportType.getSelectedItem().toString().equals("Items Report")) {
                printItemSaleReport();
            }
        }
    }//GEN-LAST:event_getSaleReportBtnActionPerformed

    private void reportTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reportTypeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_reportTypeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser fromDateField;
    private CustomComponents.RoundedButton getSaleReportBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JComboBox<String> reportType;
    private com.toedter.calendar.JDateChooser toDateField;
    // End of variables declaration//GEN-END:variables
}
