/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.accountantrole;

import business.Business;
import business.enterprise.Enterprise;
import business.person.customer.Customer;
import business.person.employee.Employee;
import business.role.Role;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import userinterface.message.MessageJPanel;

/**
 *
 * @author Skull
 */
public class AccountantWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Business business;
    
    /**
     * Creates new form AccountantWorkAreaJPanel
     */
    public AccountantWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.business = business;
        
        setValues();
    }
    
    private void setValues(){
        String currency = enterprise.getOrganizationDirectory().getAccounting().getCurrency();
        float currencyMultiplier = enterprise.getOrganizationDirectory().getAccounting().getCurrencyMultiplier();
        int totalCustomers = enterprise.getCustomerDirectory().getCustomerList().size();
        txtTotalCustomers.setText(String.valueOf(totalCustomers));
        
        float totalIncome = 0;
        for (Customer customer: enterprise.getCustomerDirectory().getCustomerList()){
            totalIncome += (enterprise.getOrganizationDirectory().getAccounting().getCustomerFees(customer) * currencyMultiplier);
        }
        lblCurrency.setText(currency);
        txtTotalRevenue.setText(String.valueOf(Math.round(totalIncome)));
        
        lblCurrency1.setText(currency);
        txtAvgRevenue.setText(String.valueOf(Math.round(totalIncome/totalCustomers)));
        
        int totalTrainers = 0;
        float totalSalary = 0;
        for(Employee employee : enterprise.getEmployeeDirectory().getEmployeeList()){
            if(employee.getRole().getRoleType() == Role.RoleType.RegularTrainer || employee.getRole().getRoleType() == Role.RoleType.MasterTrainer){
                totalTrainers++;
                totalSalary += (employee.getRole().getSalary() * currencyMultiplier);
            }
        }
        txtTotalTrainers.setText(String.valueOf(totalTrainers));
        lblCurrency2.setText(currency);
        txtTotalSalary.setText(String.valueOf(totalSalary));
        lblCurrency3.setText(currency);
        txtAvgSalary.setText(String.valueOf(totalSalary/totalTrainers));
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTotalCustomers = new javax.swing.JTextField();
        txtTotalRevenue = new javax.swing.JTextField();
        txtAvgRevenue = new javax.swing.JTextField();
        txtTotalTrainers = new javax.swing.JTextField();
        txtTotalSalary = new javax.swing.JTextField();
        txtAvgSalary = new javax.swing.JTextField();
        btnMessage = new javax.swing.JButton();
        lblCurrency = new javax.swing.JLabel();
        lblCurrency1 = new javax.swing.JLabel();
        lblCurrency2 = new javax.swing.JLabel();
        lblCurrency3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 238));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Accounts Dashboard");

        jLabel6.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("Average Fees Generated per Customer:");

        jLabel7.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Total Income by Customers:");

        jLabel8.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("No. of customers:");

        jLabel12.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("No. of trainers:");

        jLabel14.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("Total Salary for Trainers:");

        jLabel16.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("Average Salary per Customer:");

        txtTotalCustomers.setEditable(false);
        txtTotalCustomers.setText("jTextField1");

        txtTotalRevenue.setEditable(false);
        txtTotalRevenue.setText("jTextField2");

        txtAvgRevenue.setEditable(false);
        txtAvgRevenue.setText("jTextField3");

        txtTotalTrainers.setEditable(false);
        txtTotalTrainers.setText("jTextField4");

        txtTotalSalary.setEditable(false);
        txtTotalSalary.setText("jTextField5");

        txtAvgSalary.setEditable(false);
        txtAvgSalary.setText("jTextField6");

        btnMessage.setBackground(new java.awt.Color(255, 255, 255));
        btnMessage.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMessage.setForeground(new java.awt.Color(255, 153, 0));
        btnMessage.setText("Message");
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        lblCurrency.setText("jLabel2");

        lblCurrency1.setText("jLabel3");

        lblCurrency2.setText("jLabel4");

        lblCurrency3.setText("jLabel5");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(132, 132, 132)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(lblCurrency1)
                        .addGap(6, 6, 6)
                        .addComponent(txtAvgRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtTotalCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7)
                        .addGap(28, 28, 28)
                        .addComponent(lblCurrency)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTotalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblCurrency3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtAvgSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtTotalTrainers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel14)))
                        .addGap(18, 18, 18)
                        .addComponent(lblCurrency2)
                        .addGap(6, 6, 6)
                        .addComponent(txtTotalSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalCustomers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrency))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtAvgRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCurrency1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalTrainers, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTotalSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrency2))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAvgSalary, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCurrency3))
                .addGap(98, 98, 98)
                .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(106, 106, 106))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
        MessageJPanel messageJPanel = new MessageJPanel(userProcessContainer, userAccount, business);
        userProcessContainer.add("MessageJPanel",messageJPanel);
        CardLayout layout = (CardLayout)userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCurrency;
    private javax.swing.JLabel lblCurrency1;
    private javax.swing.JLabel lblCurrency2;
    private javax.swing.JLabel lblCurrency3;
    private javax.swing.JTextField txtAvgRevenue;
    private javax.swing.JTextField txtAvgSalary;
    private javax.swing.JTextField txtTotalCustomers;
    private javax.swing.JTextField txtTotalRevenue;
    private javax.swing.JTextField txtTotalSalary;
    private javax.swing.JTextField txtTotalTrainers;
    // End of variables declaration//GEN-END:variables
}
