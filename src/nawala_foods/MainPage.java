package nawala_foods;

import java.awt.*;
import javax.swing.ImageIcon;
import nawala_foods.login_page.AdminLogin;
import nawala_foods.login_page.UserLogin;
import nawala_foods.sales_page.SalesPage;
import nawala_foods.sales_report.SalesReportPage;

public class MainPage extends javax.swing.JFrame {

    private CardLayout cardLayout;
    private SalesPage salesPage;
    private nawala_foods.items_page.ItemsPage itemsPage;
    private SalesReportPage salesReportPage;
    private ImageIcon menuIcon;

    public MainPage() {
        initComponents();

        addPanelsToMainPanel();
        simpleTitleBar1.init(this);
    }

    private void addPanelsToMainPanel() {

        //         card layout for loading page on main page
        cardLayout = new CardLayout();
        panelPane.setLayout(cardLayout);

        //        add sales page into panel pane(main page panel)
        salesPage = new SalesPage();
        salesPage.setName("SalesPage");
        panelPane.add(salesPage, "SalesPage");

//        add items page into panel pane(main page panel)
        itemsPage = new nawala_foods.items_page.ItemsPage();
        itemsPage.setName("ItemsPage");
        panelPane.add(itemsPage, "ItemsPage");

        salesReportPage = new SalesReportPage();
        salesReportPage.setName("SalesReportPage");
        panelPane.add(salesReportPage, "SalesReportPage");

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        logoTxt = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        manageSalesButton = new javax.swing.JLabel();
        manageItemsButton = new javax.swing.JLabel();
        logoutBtn = new javax.swing.JLabel();
        salesReportingButton = new javax.swing.JLabel();
        panelPane = new javax.swing.JPanel();
        simpleTitleBar1 = new javaswingdev.SimpleTitleBar();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1080, 684));
        setUndecorated(true);

        mainPanel.setBackground(new java.awt.Color(255, 254, 254));
        mainPanel.setMaximumSize(new java.awt.Dimension(1080, 684));
        mainPanel.setMinimumSize(new java.awt.Dimension(1080, 684));
        mainPanel.setPreferredSize(new java.awt.Dimension(1080, 684));

        menuPanel.setBackground(new java.awt.Color(255, 254, 254));
        menuPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logoTxt.setBackground(new java.awt.Color(255, 255, 255));
        logoTxt.setFont(new java.awt.Font("Trebuchet MS", 1, 22)); // NOI18N
        logoTxt.setForeground(new java.awt.Color(18, 53, 36));
        logoTxt.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        logoTxt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.png"))); // NOI18N
        logoTxt.setText(" Nawala Foods");
        logoTxt.setToolTipText("");
        logoTxt.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        menuPanel.add(logoTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 196, -1));

        jSeparator1.setBackground(new java.awt.Color(18, 53, 36));
        jSeparator1.setForeground(new java.awt.Color(18, 53, 36));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        menuPanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 155, 210, -1));

        manageSalesButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/selectedSaleButton.png"))); // NOI18N
        manageSalesButton.setMaximumSize(new java.awt.Dimension(150, 46));
        manageSalesButton.setMinimumSize(new java.awt.Dimension(150, 46));
        manageSalesButton.setPreferredSize(new java.awt.Dimension(150, 46));
        manageSalesButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageSalesButtonMouseClicked(evt);
            }
        });
        menuPanel.add(manageSalesButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 219, 162, 60));

        manageItemsButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/itemButton.png"))); // NOI18N
        manageItemsButton.setMaximumSize(new java.awt.Dimension(150, 46));
        manageItemsButton.setMinimumSize(new java.awt.Dimension(150, 46));
        manageItemsButton.setPreferredSize(new java.awt.Dimension(150, 46));
        manageItemsButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                manageItemsButtonMouseClicked(evt);
            }
        });
        menuPanel.add(manageItemsButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 309, 162, 60));

        logoutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/log_out.png"))); // NOI18N
        logoutBtn.setMaximumSize(new java.awt.Dimension(150, 46));
        logoutBtn.setMinimumSize(new java.awt.Dimension(150, 46));
        logoutBtn.setPreferredSize(new java.awt.Dimension(150, 46));
        logoutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutBtnMouseClicked(evt);
            }
        });
        menuPanel.add(logoutBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 162, 60));

        salesReportingButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/salesReportButton.png"))); // NOI18N
        salesReportingButton.setMaximumSize(new java.awt.Dimension(150, 46));
        salesReportingButton.setMinimumSize(new java.awt.Dimension(150, 46));
        salesReportingButton.setPreferredSize(new java.awt.Dimension(150, 46));
        salesReportingButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                salesReportingButtonMouseClicked(evt);
            }
        });
        menuPanel.add(salesReportingButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 400, 162, 60));

        panelPane.setMinimumSize(new java.awt.Dimension(1080, 684));
        panelPane.setPreferredSize(new java.awt.Dimension(1080, 684));

        javax.swing.GroupLayout panelPaneLayout = new javax.swing.GroupLayout(panelPane);
        panelPane.setLayout(panelPaneLayout);
        panelPaneLayout.setHorizontalGroup(
            panelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1086, Short.MAX_VALUE)
        );
        panelPaneLayout.setVerticalGroup(
            panelPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        simpleTitleBar1.setBackground(new java.awt.Color(255, 254, 254));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panelPane, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(simpleTitleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 1335, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(simpleTitleBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
                    .addComponent(panelPane, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1335, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 726, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1335, 726));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void manageSalesButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageSalesButtonMouseClicked
        //        load sales page on main page
        cardLayout.show(panelPane, "SalesPage");

        menuIcon = new ImageIcon(getClass().getResource("/img/selectedSaleButton.png"));
        manageSalesButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/itemButton.png"));
        manageItemsButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/salesReportButton.png"));
        salesReportingButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/log_out.png"));
        logoutBtn.setIcon(menuIcon);
    }//GEN-LAST:event_manageSalesButtonMouseClicked

    private void manageItemsButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_manageItemsButtonMouseClicked
        //        load items page on main page
        cardLayout.show(panelPane, "ItemsPage");

        menuIcon = new ImageIcon(getClass().getResource("/img/selectedItemButton.png"));
        manageItemsButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/saleButton.png"));
        manageSalesButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/salesReportButton.png"));
        salesReportingButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/log_out.png"));
        logoutBtn.setIcon(menuIcon);
    }//GEN-LAST:event_manageItemsButtonMouseClicked

    private void logoutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutBtnMouseClicked
        menuIcon = new ImageIcon(getClass().getResource("/img/active_logout.png"));
        logoutBtn.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/itemButton.png"));
        manageItemsButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/saleButton.png"));
        manageSalesButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/salesReportButton.png"));
        salesReportingButton.setIcon(menuIcon);
        
        AdminLogin.isAdminLogin = false;
        UserLogin.isUserLogin = false;
        
        this.dispose();
        new AdminLogin().setVisible(true);
    }//GEN-LAST:event_logoutBtnMouseClicked

    private void salesReportingButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_salesReportingButtonMouseClicked
        //        load items page on main page
        cardLayout.show(panelPane, "SalesReportPage");

        menuIcon = new ImageIcon(getClass().getResource("/img/selectedSaleReportButton.png"));
        salesReportingButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/itemButton.png"));
        manageItemsButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/saleButton.png"));
        manageSalesButton.setIcon(menuIcon);

        menuIcon = new ImageIcon(getClass().getResource("/img/log_out.png"));
        logoutBtn.setIcon(menuIcon);
    }//GEN-LAST:event_salesReportingButtonMouseClicked

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new MainPage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel logoTxt;
    private javax.swing.JLabel logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel manageItemsButton;
    private javax.swing.JLabel manageSalesButton;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel panelPane;
    private javax.swing.JLabel salesReportingButton;
    private javaswingdev.SimpleTitleBar simpleTitleBar1;
    // End of variables declaration//GEN-END:variables
}
