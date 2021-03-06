/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.customerrole;

import business.Business;
import business.enterprise.Enterprise;
import business.network.Network;
import business.parentnetwork.ParentNetwork;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import userinterface.groupclasses.ViewGroupClassesJPanel;
import userinterface.message.MessageJPanel;
import business.organization.groupclasses.GroupClasses;

/**
 *
 * @author Skull
 */
public class CustomerRoleWorkAreaJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Enterprise enterprise;
    private Business business;

    /**
     * Creates new form CustomerRoleWorkAreaJPanel
     */
    public CustomerRoleWorkAreaJPanel(JPanel userProcessContainer, UserAccount userAccount, Enterprise enterprise, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.enterprise = enterprise;
        this.business = business;
        
        populateTable();
    }
    
    private void populateTable(){
        jTable1.removeAll();
        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
        dtm.setRowCount(0);
        
        for(ParentNetwork pn: business.getParentNetworkDirectory().getParentNetworkList()){
            for(Network n: pn.getNetworkDirectory().getNetworkList()){
                for(Enterprise e: n.getEnterpriseDirectory().getEnterpriseList()){
                    if(e.getBranchName().equals(enterprise.getBranchName())){
                        for(GroupClasses gc: e.getOrganizationDirectory().getGroupClassesDirectory().getGroupClassesList()){
                            Object row[] = new Object[4];
                            row[0] = gc;
                            row[1] = gc.getTime();
                            row[2] = gc.getTrainer().getFirstName()+" "+gc.getTrainer().getLastName();
                            row[3] = gc.getDescription();
                            dtm.addRow(row);
                        }
                    }
                }
            }
        }
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
        btnMessage = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Yuppy SC", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Member Dashboard");

        btnMessage.setBackground(new java.awt.Color(255, 255, 255));
        btnMessage.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        btnMessage.setForeground(new java.awt.Color(255, 153, 0));
        btnMessage.setText("Message");
        btnMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMessageActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Your scheduled class(es) today:");

        jTable1.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jTable1.setForeground(new java.awt.Color(255, 153, 0));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Group Class Name", "Time", "Trainer", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(109, 109, 109))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(44, 44, 44)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(98, 98, 98)
                .addComponent(btnMessage, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnMessageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMessageActionPerformed
        // TODO add your handling code here:
        MessageJPanel messageJPanel = new MessageJPanel(userProcessContainer, userAccount, business);
        userProcessContainer.add("MessageJPanel", messageJPanel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnMessageActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnMessage;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
