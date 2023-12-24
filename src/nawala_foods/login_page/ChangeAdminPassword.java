package nawala_foods.login_page;

import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ChangeAdminPassword extends javax.swing.JFrame {

    private LoginModel loginModel;

    private ResultSet res;

    public ChangeAdminPassword() {
        initComponents();
        try {
            loginModel = new LoginModel();
        } catch (ClassNotFoundException | SQLException ex) {
            JOptionPane.showMessageDialog(ChangeAdminPassword.this, ex.getMessage());
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
        changePasswordBtn = new javax.swing.JButton();
        minimizeBtn = new javax.swing.JLabel();
        closeBtn = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        adminOldPasswordField = new javax.swing.JPasswordField();
        adminNewPasswordField = new javax.swing.JPasswordField();
        adminConfirmNewPasswordField = new javax.swing.JPasswordField();
        backBtn = new javax.swing.JLabel();
        showAdminOldPassword = new javax.swing.JCheckBox();
        showAdminNewPassword = new javax.swing.JCheckBox();
        showAdminConfirmNewPassword = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 53, 36));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset_password.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Admin Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Old Password :");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Password :");

        changePasswordBtn.setBackground(new java.awt.Color(255, 186, 0));
        changePasswordBtn.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        changePasswordBtn.setForeground(new java.awt.Color(18, 53, 36));
        changePasswordBtn.setText("Change");
        changePasswordBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changePasswordBtnActionPerformed(evt);
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

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Password :");

        adminOldPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adminOldPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminOldPasswordFieldKeyPressed(evt);
            }
        });

        adminNewPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adminNewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminNewPasswordFieldKeyPressed(evt);
            }
        });

        adminConfirmNewPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adminConfirmNewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminConfirmNewPasswordFieldKeyPressed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backBtnMousePressed(evt);
            }
        });

        showAdminOldPassword.setBackground(new java.awt.Color(18, 53, 36));
        showAdminOldPassword.setForeground(new java.awt.Color(255, 255, 255));
        showAdminOldPassword.setText("show");
        showAdminOldPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAdminOldPasswordActionPerformed(evt);
            }
        });

        showAdminNewPassword.setBackground(new java.awt.Color(18, 53, 36));
        showAdminNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        showAdminNewPassword.setText("show");
        showAdminNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAdminNewPasswordActionPerformed(evt);
            }
        });

        showAdminConfirmNewPassword.setBackground(new java.awt.Color(18, 53, 36));
        showAdminConfirmNewPassword.setForeground(new java.awt.Color(255, 255, 255));
        showAdminConfirmNewPassword.setText("show");
        showAdminConfirmNewPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAdminConfirmNewPasswordActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(512, 512, 512)
                        .addComponent(minimizeBtn)
                        .addGap(18, 18, 18)
                        .addComponent(closeBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(backBtn)
                        .addGap(327, 327, 327)
                        .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel3)))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminOldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(adminNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showAdminOldPassword)
                            .addComponent(showAdminNewPassword)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showAdminConfirmNewPassword)
                            .addComponent(adminConfirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(minimizeBtn)
                            .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(adminOldPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(showAdminOldPassword)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(adminNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(showAdminNewPassword)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(adminConfirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showAdminConfirmNewPassword)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(changePasswordBtn)))
                .addContainerGap(34, Short.MAX_VALUE))
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

    private void checkOldPasswordMatches() {
        try {

            if (isDataValid()) {

                res = loginModel.getUserNamePasswordFromDb("nawala_foods.admin_login");

                String dbPassword = "";

                while (res.next()) {

                    dbPassword = res.getString("password");
                }

                if (adminOldPasswordField.getText().equals(dbPassword)) {
                    updatePassword();
                } else {
                    JOptionPane.showMessageDialog(this, "old password is wrong");
                }
            }

        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(ChangeAdminPassword.this, ex.getMessage());
        }
    }

    private void goToAdminLoginPage() {
        AdminLogin page = new AdminLogin();
        page.setVisible(true);
        this.dispose();
    }

    private void updatePassword() throws SQLException {
        int updatePassword = loginModel.updateUserPassword(adminConfirmNewPasswordField.getText(), "nawala_foods.admin_login");
        if (updatePassword == 1) {
            JOptionPane.showMessageDialog(this, "Password updated successfully");
            goToAdminLoginPage();
        } else if (updatePassword == 0) {
            JOptionPane.showMessageDialog(this, "Password not updated successfully");
        }
    }

    private boolean isDataValid() {
        boolean valid = true;

        if (adminOldPasswordField.getText().length() < 6) {
            JOptionPane.showMessageDialog(this, "please enter valid old password");
            valid = false;
        }

        if (!adminNewPasswordField.getText().equals(adminConfirmNewPasswordField.getText())) {
            JOptionPane.showMessageDialog(this, "new password and confirm password not matched");
            valid = false;
        }

        if (adminNewPasswordField.getText().length() < 6 || adminConfirmNewPasswordField.getText().length() < 6) {
            JOptionPane.showMessageDialog(this, "please enter new password of aleast 6 words");
        }

        return valid;
    }

    private void changePasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordBtnActionPerformed
        checkOldPasswordMatches();
    }//GEN-LAST:event_changePasswordBtnActionPerformed

    private void minimizeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMousePressed
        setState(ChangeAdminPassword.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnMousePressed

    private void closeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMousePressed
        this.dispose();
    }//GEN-LAST:event_closeBtnMousePressed

    private void backBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMousePressed
        AdminLogin page = new AdminLogin();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMousePressed

    private void showAdminOldPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAdminOldPasswordActionPerformed
        if (showAdminOldPassword.isSelected()) {
            adminOldPasswordField.setEchoChar((char) 0);
            adminOldPasswordField.requestFocusInWindow();
        } else {
            adminOldPasswordField.setEchoChar('•');
            adminOldPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_showAdminOldPasswordActionPerformed

    private void showAdminNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAdminNewPasswordActionPerformed
        if (showAdminNewPassword.isSelected()) {
            adminNewPasswordField.setEchoChar((char) 0);
            adminNewPasswordField.requestFocusInWindow();
        } else {
            adminNewPasswordField.setEchoChar('•');
            adminNewPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_showAdminNewPasswordActionPerformed

    private void showAdminConfirmNewPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAdminConfirmNewPasswordActionPerformed
        if (showAdminConfirmNewPassword.isSelected()) {
            adminConfirmNewPasswordField.setEchoChar((char) 0);
            adminConfirmNewPasswordField.requestFocusInWindow();
        } else {
            adminConfirmNewPasswordField.setEchoChar('•');
            adminConfirmNewPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_showAdminConfirmNewPasswordActionPerformed

    private void adminOldPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminOldPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adminNewPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_adminOldPasswordFieldKeyPressed

    private void adminNewPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminNewPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            adminConfirmNewPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_adminNewPasswordFieldKeyPressed

    private void adminConfirmNewPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminConfirmNewPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            checkOldPasswordMatches();
        }
    }//GEN-LAST:event_adminConfirmNewPasswordFieldKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new ChangeAdminPassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField adminConfirmNewPasswordField;
    private javax.swing.JPasswordField adminNewPasswordField;
    private javax.swing.JPasswordField adminOldPasswordField;
    private javax.swing.JLabel backBtn;
    private javax.swing.JButton changePasswordBtn;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel minimizeBtn;
    private javax.swing.JCheckBox showAdminConfirmNewPassword;
    private javax.swing.JCheckBox showAdminNewPassword;
    private javax.swing.JCheckBox showAdminOldPassword;
    // End of variables declaration//GEN-END:variables
}
