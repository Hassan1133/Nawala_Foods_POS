package nawala_foods.login_page;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ChangeUserPassword extends javax.swing.JFrame {

    private LoginModel loginModel;

    private ResultSet res;

    public ChangeUserPassword() {
        initComponents();
        try {
            loginModel = new LoginModel();
        } catch (ClassNotFoundException | SQLException ex) {
           JOptionPane.showMessageDialog(ChangeUserPassword.this, ex.getMessage());
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
        adminPasswordField = new javax.swing.JPasswordField();
        userNewPasswordField = new javax.swing.JPasswordField();
        userConfirmNewPasswordField = new javax.swing.JPasswordField();
        backBtn = new javax.swing.JLabel();
        showAdminPwd = new javax.swing.JCheckBox();
        showNewUserPwd = new javax.swing.JCheckBox();
        showUserConfirmPwd = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(18, 53, 36));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/reset_password.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("User Password");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Admin Password :");

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

        adminPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        adminPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                adminPasswordFieldKeyPressed(evt);
            }
        });

        userNewPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        userNewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userNewPasswordFieldKeyPressed(evt);
            }
        });

        userConfirmNewPasswordField.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        userConfirmNewPasswordField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                userConfirmNewPasswordFieldKeyPressed(evt);
            }
        });

        backBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/back.png"))); // NOI18N
        backBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                backBtnMousePressed(evt);
            }
        });

        showAdminPwd.setBackground(new java.awt.Color(18, 53, 36));
        showAdminPwd.setForeground(new java.awt.Color(255, 255, 255));
        showAdminPwd.setText("show");
        showAdminPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showAdminPwdActionPerformed(evt);
            }
        });

        showNewUserPwd.setBackground(new java.awt.Color(18, 53, 36));
        showNewUserPwd.setForeground(new java.awt.Color(255, 255, 255));
        showNewUserPwd.setText("show");
        showNewUserPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showNewUserPwdActionPerformed(evt);
            }
        });

        showUserConfirmPwd.setBackground(new java.awt.Color(18, 53, 36));
        showUserConfirmPwd.setForeground(new java.awt.Color(255, 255, 255));
        showUserConfirmPwd.setText("show");
        showUserConfirmPwd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showUserConfirmPwdActionPerformed(evt);
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
                        .addGap(30, 30, 30)
                        .addComponent(backBtn)
                        .addGap(334, 334, 334)
                        .addComponent(changePasswordBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(88, 88, 88)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(91, 91, 91)
                                .addComponent(jLabel3)))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(adminPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showAdminPwd)
                            .addComponent(showNewUserPwd)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel5)
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(showUserConfirmPwd)
                            .addComponent(userConfirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(198, 198, 198))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(backBtn)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(minimizeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(closeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(jLabel2)
                        .addGap(66, 66, 66)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(adminPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)
                        .addComponent(showAdminPwd)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel4))
                            .addComponent(userNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(5, 5, 5)
                        .addComponent(showNewUserPwd)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(userConfirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(showUserConfirmPwd)
                        .addGap(17, 17, 17)
                        .addComponent(changePasswordBtn)))
                .addGap(34, 34, 34))
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

                if (adminPasswordField.getText().equals(dbPassword)) {
                    updatePassword();
                } else {
                    JOptionPane.showMessageDialog(this, "Admin password is wrong");
                }
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(ChangeUserPassword.this, ex.getMessage());
        }
    }

    private void goToUserLoginPage() {
        UserLogin userPage = new UserLogin();
        userPage.setVisible(true);
        this.dispose();
    }

    private void updatePassword() throws SQLException {
        int updatePassword = loginModel.updateUserPassword(userConfirmNewPasswordField.getText(), "nawala_foods.user_login");
        if (updatePassword == 1) {
            JOptionPane.showMessageDialog(this, "Password updated successfully");
            goToUserLoginPage();
        } else if (updatePassword == 0) {
            JOptionPane.showMessageDialog(this, "Password not updated successfully");
        }
    }

    private boolean isDataValid() {
        boolean valid = true;

        if (adminPasswordField.getText().length() < 6) {
            JOptionPane.showMessageDialog(this, "please enter valid old password");
            valid = false;
        }

        if (!userNewPasswordField.getText().equals(userConfirmNewPasswordField.getText())) {
            JOptionPane.showMessageDialog(this, "new password and confirm password not matched");
            valid = false;
        }

        if (userNewPasswordField.getText().length() < 6 || userConfirmNewPasswordField.getText().length() < 6) {
            JOptionPane.showMessageDialog(this, "please enter new password of aleast 6 words");
        }

        return valid;
    }

    private void changePasswordBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changePasswordBtnActionPerformed
        checkOldPasswordMatches();
    }//GEN-LAST:event_changePasswordBtnActionPerformed

    private void minimizeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizeBtnMousePressed
        setState(ChangeUserPassword.ICONIFIED);
    }//GEN-LAST:event_minimizeBtnMousePressed

    private void closeBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMousePressed
        this.dispose();
    }//GEN-LAST:event_closeBtnMousePressed

    private void backBtnMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backBtnMousePressed
        UserLogin page = new UserLogin();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnMousePressed

    private void showAdminPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showAdminPwdActionPerformed
        if (showAdminPwd.isSelected()) {
            adminPasswordField.setEchoChar((char) 0);
            adminPasswordField.requestFocusInWindow();
        } else {
            adminPasswordField.setEchoChar('•');
            adminPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_showAdminPwdActionPerformed

    private void showNewUserPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showNewUserPwdActionPerformed
        if (showNewUserPwd.isSelected()) {
            userNewPasswordField.setEchoChar((char) 0);
            userNewPasswordField.requestFocusInWindow();
        } else {
            userNewPasswordField.setEchoChar('•');
            userNewPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_showNewUserPwdActionPerformed

    private void showUserConfirmPwdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showUserConfirmPwdActionPerformed
        if (showUserConfirmPwd.isSelected()) {
            userConfirmNewPasswordField.setEchoChar((char) 0);
            userConfirmNewPasswordField.requestFocusInWindow();
        } else {
            userConfirmNewPasswordField.setEchoChar('•');
            userConfirmNewPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_showUserConfirmPwdActionPerformed

    private void adminPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_adminPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            userNewPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_adminPasswordFieldKeyPressed

    private void userNewPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userNewPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            userConfirmNewPasswordField.requestFocusInWindow();
        }
    }//GEN-LAST:event_userNewPasswordFieldKeyPressed

    private void userConfirmNewPasswordFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_userConfirmNewPasswordFieldKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            checkOldPasswordMatches();
        }
    }//GEN-LAST:event_userConfirmNewPasswordFieldKeyPressed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(() -> {
            new ChangeUserPassword().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField adminPasswordField;
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
    private javax.swing.JCheckBox showAdminPwd;
    private javax.swing.JCheckBox showNewUserPwd;
    private javax.swing.JCheckBox showUserConfirmPwd;
    private javax.swing.JPasswordField userConfirmNewPasswordField;
    private javax.swing.JPasswordField userNewPasswordField;
    // End of variables declaration//GEN-END:variables
}
