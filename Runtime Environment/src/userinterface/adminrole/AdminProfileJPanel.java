/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.adminrole;

import business.Business;
import business.organization.accounting.Accounting;
import business.person.Person;
import business.person.employee.Employee;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import userinterface.password.ChangePasswordJPanel;

/**
 *
 * @author soumiyaroy
 */
public class AdminProfileJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Accounting accounting;
    private Business business;

    /**
     * Creates new form SuperAdminProfileJPanel
     */
    public AdminProfileJPanel(JPanel userProcessContainer, UserAccount userAccount, Accounting accounting, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.accounting = accounting;
        this.business = business;
        
        setAdminToForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        btnSave1 = new javax.swing.JButton();
        btnBack1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnChangePassword1 = new javax.swing.JButton();
        buttonGroupGender = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnSave = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnChangePassword = new javax.swing.JButton();
        txtLastName = new javax.swing.JTextField();
        txtEmailID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jDateChooser = new com.toedter.calendar.JDateChooser();
        txtZipCode = new javax.swing.JTextField();
        txtCity = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtPhoneNo = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        radioBtnMale = new javax.swing.JRadioButton();
        jLabel16 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtCountry = new javax.swing.JTextField();
        radioBtnFemale = new javax.swing.JRadioButton();
        jLabel7 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtFirstName = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jSeparator3.setForeground(new java.awt.Color(255, 204, 0));

        jSeparator4.setForeground(new java.awt.Color(255, 204, 0));

        btnSave1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSave1.setForeground(new java.awt.Color(255, 204, 0));
        btnSave1.setText("Save");

        btnBack1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBack1.setForeground(new java.awt.Color(255, 204, 0));
        btnBack1.setText("Back");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Yuppy SC", 3, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Admin Profile");

        btnChangePassword1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnChangePassword1.setForeground(new java.awt.Color(255, 204, 0));
        btnChangePassword1.setText("Change Password");
        btnChangePassword1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePassword1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(317, 317, 317)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnChangePassword1)
                                        .addGap(18, 18, 18))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(183, 183, 183)))
                                .addComponent(btnSave1)))
                        .addGap(0, 22, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 255, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangePassword1)
                    .addComponent(btnSave1)
                    .addComponent(btnBack1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        setBackground(new java.awt.Color(102, 102, 255));

        jSeparator1.setForeground(new java.awt.Color(255, 153, 0));

        jSeparator2.setForeground(new java.awt.Color(255, 204, 0));

        btnSave.setBackground(new java.awt.Color(255, 255, 255));
        btnSave.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 153, 0));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 153, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Yuppy SC", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Admin Profile");

        btnChangePassword.setBackground(new java.awt.Color(255, 255, 255));
        btnChangePassword.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnChangePassword.setForeground(new java.awt.Color(255, 153, 0));
        btnChangePassword.setText("Change Password");
        btnChangePassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangePasswordActionPerformed(evt);
            }
        });

        txtLastName.setForeground(new java.awt.Color(255, 153, 0));

        txtEmailID.setForeground(new java.awt.Color(255, 153, 0));

        jLabel13.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("State:");

        jLabel11.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("Address:");

        jLabel14.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("Country:");

        jLabel15.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("Zip Code:");

        jDateChooser.setForeground(new java.awt.Color(255, 153, 0));

        txtZipCode.setForeground(new java.awt.Color(255, 153, 0));

        txtCity.setForeground(new java.awt.Color(255, 153, 0));

        jLabel5.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Gender:");

        jLabel3.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("First Name:");

        txtPhoneNo.setForeground(new java.awt.Color(255, 153, 0));

        txtState.setForeground(new java.awt.Color(255, 153, 0));

        radioBtnMale.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnMale.setText("Male");

        jLabel16.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("Phone No:");

        jLabel6.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("Date Of Birth:");

        txtCountry.setForeground(new java.awt.Color(255, 153, 0));

        radioBtnFemale.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnFemale.setText("Female");

        jLabel7.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Email ID:");

        txtAddress.setForeground(new java.awt.Color(255, 153, 0));

        jLabel10.setBackground(new java.awt.Color(255, 204, 0));
        jLabel10.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("Last Name:");

        txtFirstName.setForeground(new java.awt.Color(255, 153, 0));

        jLabel12.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("City:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 670, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(144, 144, 144)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnChangePassword)
                                        .addGap(13, 13, 13)
                                        .addComponent(btnSave))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(radioBtnMale)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(radioBtnFemale)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(30, 30, 30))))
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 656, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 18, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(35, 35, 35)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addGap(31, 31, 31)
                            .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(26, 26, 26)
                            .addComponent(jLabel10)
                            .addGap(30, 30, 30)
                            .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(0, 163, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel5))
                                    .addGap(52, 52, 52)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel14)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                                            .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(51, 51, 51))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel12)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel13)
                                        .addComponent(jLabel15)
                                        .addComponent(jLabel7)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel16)
                                    .addGap(40, 40, 40)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addContainerGap(175, Short.MAX_VALUE)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(radioBtnFemale)
                        .addComponent(jLabel6)
                        .addComponent(radioBtnMale))
                    .addComponent(jDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(187, 187, 187)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChangePassword)
                    .addComponent(btnSave)
                    .addComponent(btnBack))
                .addGap(18, 18, 18)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(126, 126, 126)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(txtFirstName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel10)
                        .addComponent(txtLastName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(21, 21, 21)
                    .addComponent(jLabel5)
                    .addGap(18, 18, 18)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAddress, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel13)
                        .addComponent(txtCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14)
                        .addComponent(jLabel15)
                        .addComponent(txtZipCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(txtPhoneNo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(txtEmailID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(134, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private Boolean validateAdminProfile() {
        int dialogShown = 0;
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("^[a-zA-Z]+$");
        matcher = pattern.matcher(txtFirstName.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 1;
            }
            txtFirstName.setBackground(Color.PINK);
        }
        matcher = pattern.matcher(txtLastName.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 2;
            }
            txtLastName.setBackground(Color.PINK);
        }
        if (buttonGroupGender.getSelection() == null) {
            if (dialogShown <= 0) {
                dialogShown = 3;
            }
        }
        if (jDateChooser.getDate() == null) {
            if (dialogShown <= 0) {
                dialogShown = 4;
            }
        }
        if (txtAddress.getText().trim().length() == 0) {
            if (dialogShown <= 0) {
                dialogShown = 5;
            }
            txtAddress.setBackground(Color.PINK);
        }
        pattern = Pattern.compile("^[a-zA-Z ]+$");
        matcher = pattern.matcher(txtCity.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 6;
            }
            txtCity.setBackground(Color.PINK);
        }

        matcher = pattern.matcher(txtState.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 7;
            }
            txtState.setBackground(Color.PINK);
        }
        matcher = pattern.matcher(txtCountry.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 8;
            }
            txtCountry.setBackground(Color.PINK);
        }
        if (txtZipCode.getText().trim().length() == 0) {
            if (dialogShown <= 0) {
                dialogShown = 9;
            }
            txtZipCode.setBackground(Color.PINK);
        }
        if (!validatePhoneNumber(txtPhoneNo.getText())) {
            if (dialogShown <= 0) {
                dialogShown = 10;
            }
            txtPhoneNo.setBackground(Color.PINK);
        }
        pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        matcher = pattern.matcher(txtEmailID.getText());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 11;
            }
            txtEmailID.setBackground(Color.PINK);
        }
        if (dialogShown == 0) {
            return true;
        } else {
            showValidationDialog(dialogShown);
            return false;
        }
    }

    private static boolean validatePhoneNumber(String phone) {

        //validate phone numbers of format "1234567890"
        if (phone.matches("\\d{10}")) {
            return true;
        } //validating phone number with -, . or spaces
        else if (phone.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
            return true;
        } //validating phone number with extension length from 3 to 5
        else if (phone.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
            return true;
        } //validating phone number where area code is in braces ()
        else if (phone.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
            return true;
        } //return false if nothing matches the input
        else {
            return false;
        }
    }

    private void showValidationDialog(int flag) {
        String errMessage = "";
        switch (flag) {

            case 1:
                errMessage = "Invalid First Name!";
                break;

            case 2:
                errMessage = "Invalid Last Name!";
                break;

            case 3:
                errMessage = "Gender not Selected!";

            case 4:
                errMessage = "Date of birth not entered!";

            case 5:
                errMessage = "Invalid Address!";
                break;

            case 6:
                errMessage = "Invalid City!";
                break;

            case 7:
                errMessage = "Invalid State!";
                break;

            case 8:
                errMessage = "Invalid Country!";
                break;

            case 9:
                errMessage = "Invalid Zip Code!";
                break;

            case 10:
                errMessage = "Invalid Phone Number!";
                break;

            case 11:
                errMessage = "Invalid Email ID!";
                break;
        }

        JOptionPane.showMessageDialog(null, errMessage, "Error Message", JOptionPane.ERROR_MESSAGE);
    }

    private void removeValidationDisplay() {

        txtFirstName.setBackground(Color.white);
        txtLastName.setBackground(Color.white);
        txtAddress.setBackground(Color.white);
        txtCity.setBackground(Color.white);
        txtState.setBackground(Color.white);
        txtCountry.setBackground(Color.white);
        txtZipCode.setBackground(Color.white);
        txtPhoneNo.setBackground(Color.white);
        txtEmailID.setBackground(Color.white);
    }

    private void setAdminProfileToObj() {
        Employee employee = userAccount.getEmployee();
        
        // bind user data
        employee.setFirstName(txtFirstName.getText());
        employee.setLastName(txtLastName.getText());
        
        if(radioBtnMale.isSelected())
            employee.setGender(Person.genderType.Male);
        else if(radioBtnFemale.isSelected())
            employee.setGender(Person.genderType.Female);
        
        employee.setDob(jDateChooser.getDate());
        employee.setAddress(txtAddress.getText());
        employee.setCity(txtCity.getText());
        employee.setState(txtState.getText());
        employee.setCountry(txtCountry.getText());
        employee.setZip(txtZipCode.getText());
        employee.setMobile(txtPhoneNo.getText());
        employee.setEmail(txtEmailID.getText());

        // prompt user data bind success
        JOptionPane.showMessageDialog(null, "Congratulations, your profile is updated successfully!", "Info", JOptionPane.INFORMATION_MESSAGE);    
    }
    
    public void setAdminToForm(){
        Employee employee = userAccount.getEmployee();
        
        txtFirstName.setText(employee.getFirstName());
        txtLastName.setText(employee.getLastName());
        
        if(employee.getGender().toString().equals("Male"))
            radioBtnMale.setSelected(true);
        else if(employee.getGender().toString().equals("Female"))
            radioBtnFemale.setSelected(true);
        
        jDateChooser.setDate(employee.getDob());
        
        txtAddress.setText(employee.getAddress());
        txtCity.setText(employee.getCity());
        txtState.setText(employee.getState());
        txtCountry.setText(employee.getCountry());
        txtZipCode.setText(employee.getZip());
        txtPhoneNo.setText(employee.getMobile());
        txtEmailID.setText(employee.getEmail());
    }

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnChangePassword1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePassword1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnChangePassword1ActionPerformed

    private void btnChangePasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangePasswordActionPerformed
        // TODO add your handling code here:
        ChangePasswordJPanel changePasswordJPanel = new ChangePasswordJPanel(userProcessContainer, userAccount, business);
        userProcessContainer.add("ChangePasswordJPanel", changePasswordJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnChangePasswordActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        removeValidationDisplay();
        Boolean isValid = validateAdminProfile();
        if (isValid) {
            setAdminProfileToObj();
        }
    }//GEN-LAST:event_btnSaveActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnChangePassword;
    private javax.swing.JButton btnChangePassword1;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnSave1;
    private javax.swing.ButtonGroup buttonGroupGender;
    private com.toedter.calendar.JDateChooser jDateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JRadioButton radioBtnFemale;
    private javax.swing.JRadioButton radioBtnMale;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmailID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}
