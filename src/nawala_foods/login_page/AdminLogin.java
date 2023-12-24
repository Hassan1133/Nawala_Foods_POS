package nawala_foods.login_page;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import nawala_foods.MainPage;

public class AdminLogin extends javax.swing.JFrame {

    private LoginModel loginModel;

    private ResultSet res;

    public static boolean isAdminLogin = false;

    public AdminLogin() {
        initComponents();
        try {
            loginModel = new LoginModel();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(AdminLogin.this, ex.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        adminNameField = new javax.swing.JTextField();
        adminPasswordField = new javax.swing.JPasswordField();
        adminLoginBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JLabel();
        closeBtn = new javax.swing.JLabel();
        changePwdBtn = new javax.swing.JLabel();
        userAccountBtn = new javax.swing.JLabel();
        showPwd = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(18, 53, 36));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/login.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin Login");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Password :");

        adminNameField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adminNameField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminNameFieldKeyPressed(evt);
            }
        });

        adminPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adminPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminPasswordFieldKeyPressed(evt);
            }
        });

        adminLoginBtn.setBackground(new java.awt.Color(255, 186, 0));
        adminLoginBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        adminLoginBtn.setForeground(new java.awt.Color(18, 53, 36));
        adminLoginBtn.setText("Login");
        adminLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adminLoginBtnActionPerformed(evt);
            }
        });

        minimizeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/minimize.png"))); // NOI18N
        minimizeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                minimizeBtnMousePressed(evt);
            }
        });

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/close.png"))); // NOI18N
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                closeBtnMousePressed(evt);
            }
        });

        changePwdBtn.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        changePwdBtn.setForeground(new java.awt.Color(255, 255, 255));
        changePwdBtn.setText("Change password");
        changePwdBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                changePwdBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                changePwdBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                changePwdBtnMousePressed(evt);
            }
        });

        userAccountBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        userAccountBtn.setForeground(new java.awt.Color(255, 255, 255));
        userAccountBtn.setText("Switch to user account");
        userAccountBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                userAccountBtnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                userAccountBtnMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                userAccountBtnMousePressed(evt);
            }
        });

        showPwd.setBackground(new java.awt.Color(18, 53, 36));
        showPwd.setForeground(new java.awt.Color(255, 255, 255));
        showPwd.setText("show");
        showPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showPwdActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(minimizeBtn)
                        .addGap(18, 18, 18)
                        .addComponent(closeBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4))
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(adminLoginBtn)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(showPwd)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(changePwdBtn))
                                        .addComponent(adminNameField, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(adminPasswordField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(193, 193, 193)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addGap(50, 50, 50))
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 189, Short.MAX_VALUE)
                .addComponent(userAccountBtn)
                .addGap(185, 185, 185))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(closeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(minimizeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(adminNameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(adminPasswordField))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(changePwdBtn)
                    .addComponent(showPwd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(adminLoginBtn)
                .addGap(44, 44, 44)
                .addComponent(userAccountBtn)
                .addGap(28, 28, 28))
        );

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

    private void checkUserNamePassword() {

        try {

            if (isDataValid()) {

                res = loginModel.getUserNamePasswordFromDb("nawala_foods.admin_login");

                String dbName = "";
                String dbPassword = "";

                while (res.next()) {

                    dbName = res.getString("name");
                    dbPassword = res.getString("password");
                }

                matchLoginCredentials(adminNameField.getText(), adminPasswordField.getText(), dbName, dbPassword);

            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(AdminLogin.this, ex.getMessage());
        }
    }

    private void matchLoginCredentials(String admin_name, String admin_password, String db_name, String db_password) {

        if (admin_name.equals(db_name) && admin_password.equals(db_password)) {
            goToMainPage();
        } else {
            JOptionPane.showMessageDialog(this, "Admin not exists");
            adminNameField.setText("");
            adminPasswordField.setText("");
        }

    }

    private void goToMainPage() {

        isAdminLogin = true;

        MainPage mainPage = new MainPage();
        mainPage.setVisible(true);
        this.dispose();
    }

    private boolean isDataValid() {
        boolean valid = true;

        if (adminNameField.getText().length() < 3) {
            JOptionPane.showMessageDialog(this, "please enter valid name");
            valid = false;
        }

        if (adminPasswordField.getText().length() < 6) {
            JOptionPane.showMessageDialog(this, "please enter valid password");
            valid = false;
        }

        return valid;
    }

    private void adminLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adminLoginBtnActionPerformed
        checkUserNamePassword();
    }//GEN-LAST:event_adminLoginBtnActionPerformed

    private void closeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMousePressed
        this.dispose();
    }//GEN-LAST:event_closeBtnMousePressed

    private void minimizeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMousePressed
        setState(AdminLogin.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnMousePressed

    private void changePwdBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePwdBtnMouseEntered
        Color hoverColor = new Color(255, 186, 0);
        changePwdBtn.setForeground(hoverColor);
    }//GEN-LAST:event_changePwdBtnMouseEntered

    private void changePwdBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePwdBtnMouseExited
        Color simpleColor = new Color(255, 255, 255);
        changePwdBtn.setForeground(simpleColor);
    }//GEN-LAST:event_changePwdBtnMouseExited

    private void userAccountBtnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userAccountBtnMouseEntered
        Color hoverColor = new Color(255, 186, 0);
        userAccountBtn.setForeground(hoverColor);
    }//GEN-LAST:event_userAccountBtnMouseEntered

    private void userAccountBtnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userAccountBtnMouseExited
        Color hoverColor = new Color(255, 255, 255);
        userAccountBtn.setForeground(hoverColor);
    }//GEN-LAST:event_userAccountBtnMouseExited

    private void changePwdBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_changePwdBtnMousePressed
        ChangeAdminPassword change = new ChangeAdminPassword();
        change.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_changePwdBtnMousePressed

    private void userAccountBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userAccountBtnMousePressed
        UserLogin userLoginPage = new UserLogin();
        userLoginPage.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_userAccountBtnMousePressed

    private void showPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showPwdActionPerformed
        if (showPwd.isSelected()) {
            adminPasswordField.setEchoChar((char) 0);
            adminPasswordField.requestFocusInWindow();
        } else {
            adminPasswordField.setEchoChar('•');
            adminPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_showPwdActionPerformed

    private void adminNameFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminNameFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adminPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_adminNameFieldKeyPressed

    private void adminPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            checkUserNamePassword();
        }
    }//GEN-LAST:event_adminPasswordFieldKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new AdminLogin().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton adminLoginBtn;
    private javax.swing.JTextField adminNameField;
    private javax.swing.JPasswordField adminPasswordField;
    private javax.swing.JLabel changePwdBtn;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minimizeBtn;
    private javax.swing.JCheckBox showPwd;
    private javax.swing.JLabel userAccountBtn;
    // End of variables declaration//GEN-END:variables

}
