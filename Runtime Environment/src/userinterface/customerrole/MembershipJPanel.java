/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.customerrole;

import business.Business;
import business.enterprise.Enterprise;
import business.organization.accounting.Accounting;
import business.organization.accounting.membership.Membership;
import business.organization.accounting.membership.MembershipDirectory;
import business.useraccount.UserAccount;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;

/**
 *
 * @author soumiyaroy
 */
public class MembershipJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private UserAccount userAccount;
    private Accounting accounting;
    private Business business;
    private ArrayList<Membership> membershipList;
    private float totalPrice = 0;
    private float currencyMultiplier = 0;
    private Membership.membershipType selectedType;
    private Boolean selectedTraining = false;
    private Enterprise selectedEnterprise;

    /**
     * Creates new form MembershipJPanel
     */
    public MembershipJPanel(JPanel userProcessContainer, UserAccount userAccount, Accounting accounting, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.userAccount = userAccount;
        this.accounting = accounting;
        this.business = business;
        membershipList = accounting.getMembershipDirectory().getMembershipList();
        
        populateMembershipData();
        
        if(userAccount.getCustomer().getMembership().getHasPersonalTraining()){
            radioBtnYes.setSelected(true);
            totalPrice += 50*currencyMultiplier;
            selectedTraining = true;
        }else
            radioBtnNo.setSelected(true);
        
        txtTotalPrice.setText(String.valueOf(Math.round(totalPrice)));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel9 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        buttonGroupMembership = new javax.swing.ButtonGroup();
        buttonGroupHasPersonalTraining = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnRegister = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        radioBtnPlan1 = new javax.swing.JRadioButton();
        radioBtnPlan2 = new javax.swing.JRadioButton();
        radioBtnPlan3 = new javax.swing.JRadioButton();
        radioBtnPlan4 = new javax.swing.JRadioButton();
        radioBtnPlan5 = new javax.swing.JRadioButton();
        radioBtnPlan6 = new javax.swing.JRadioButton();
        lblPrice2 = new javax.swing.JLabel();
        lblPrice4 = new javax.swing.JLabel();
        lblPrice3 = new javax.swing.JLabel();
        lblPrice5 = new javax.swing.JLabel();
        lblPrice6 = new javax.swing.JLabel();
        lblPrice1 = new javax.swing.JLabel();
        btnDetails3 = new javax.swing.JButton();
        btnDetails1 = new javax.swing.JButton();
        btnDetails2 = new javax.swing.JButton();
        btnDetails4 = new javax.swing.JButton();
        btnDetails5 = new javax.swing.JButton();
        btnDetails6 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        txtTotalPrice = new javax.swing.JTextField();
        radioBtnYes = new javax.swing.JRadioButton();
        radioBtnNo = new javax.swing.JRadioButton();

        jLabel9.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("$150");

        jCheckBox1.setText("jCheckBox1");

        setBackground(new java.awt.Color(102, 102, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator1.setForeground(new java.awt.Color(255, 204, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 97, 642, -1));

        jSeparator2.setForeground(new java.awt.Color(255, 204, 0));
        add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 528, 643, 30));

        btnRegister.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 204, 0));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(575, 493, -1, -1));

        btnBack.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 204, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 493, 87, -1));

        jLabel1.setFont(new java.awt.Font("Yuppy SC", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setText("Membership");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(257, 36, 261, -1));
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 28, 63, 69));

        jLabel3.setFont(new java.awt.Font("YuGothic", 3, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("Choose Membership Plan:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 121, -1, -1));

        buttonGroupMembership.add(radioBtnPlan1);
        radioBtnPlan1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan1.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan1.setText("Weekly Gym Membership- ");
        radioBtnPlan1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPlan1ActionPerformed(evt);
            }
        });
        add(radioBtnPlan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 156, -1, -1));

        buttonGroupMembership.add(radioBtnPlan2);
        radioBtnPlan2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan2.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan2.setText("Monthly Gym Membership-");
        radioBtnPlan2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPlan2ActionPerformed(evt);
            }
        });
        add(radioBtnPlan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 197, -1, -1));

        buttonGroupMembership.add(radioBtnPlan3);
        radioBtnPlan3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan3.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan3.setText("Yearly Gym Membership-");
        radioBtnPlan3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPlan3ActionPerformed(evt);
            }
        });
        add(radioBtnPlan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 238, -1, -1));

        buttonGroupMembership.add(radioBtnPlan4);
        radioBtnPlan4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan4.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan4.setText("Weekly Gym Membership with Special Classes-");
        radioBtnPlan4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPlan4ActionPerformed(evt);
            }
        });
        add(radioBtnPlan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 279, -1, -1));

        buttonGroupMembership.add(radioBtnPlan5);
        radioBtnPlan5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan5.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan5.setText("Monthly Gym Membership with Special Classes-");
        radioBtnPlan5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPlan5ActionPerformed(evt);
            }
        });
        add(radioBtnPlan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 320, -1, -1));

        buttonGroupMembership.add(radioBtnPlan6);
        radioBtnPlan6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan6.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan6.setText("Yearly Gym Membership with Special Classes-");
        radioBtnPlan6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnPlan6ActionPerformed(evt);
            }
        });
        add(radioBtnPlan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(58, 361, -1, -1));

        lblPrice2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice2.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice2.setText("$150");
        add(lblPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 198, 91, 23));

        lblPrice4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice4.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice4.setText("$150");
        add(lblPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, 91, 23));

        lblPrice3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice3.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice3.setText("$150");
        add(lblPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 239, 91, 23));

        lblPrice5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice5.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice5.setText("$150");
        add(lblPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 321, 91, 23));

        lblPrice6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice6.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice6.setText("$150");
        add(lblPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 362, 91, 23));

        lblPrice1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice1.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice1.setText("$150");
        add(lblPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 157, 91, 23));

        btnDetails3.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails3.setText("Details");
        btnDetails3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails3ActionPerformed(evt);
            }
        });
        add(btnDetails3, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 237, 96, -1));

        btnDetails1.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails1.setText("Details");
        btnDetails1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails1ActionPerformed(evt);
            }
        });
        add(btnDetails1, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 155, 96, -1));

        btnDetails2.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails2.setText("Details");
        btnDetails2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails2ActionPerformed(evt);
            }
        });
        add(btnDetails2, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 196, 96, -1));

        btnDetails4.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails4.setText("Details");
        btnDetails4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails4ActionPerformed(evt);
            }
        });
        add(btnDetails4, new org.netbeans.lib.awtextra.AbsoluteConstraints(517, 278, 96, -1));

        btnDetails5.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails5.setText("Details");
        btnDetails5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails5ActionPerformed(evt);
            }
        });
        add(btnDetails5, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 319, 96, -1));

        btnDetails6.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails6.setText("Details");
        btnDetails6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDetails6ActionPerformed(evt);
            }
        });
        add(btnDetails6, new org.netbeans.lib.awtextra.AbsoluteConstraints(518, 360, 96, -1));

        jLabel11.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("Need a trainer? ");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 398, -1, -1));

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 204, 0));
        jLabel18.setText("$50/day");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(421, 398, -1, -1));

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 204, 0));
        jLabel20.setText("Total Amount:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 440, -1, -1));

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 0));
        jLabel21.setText("$");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 440, -1, -1));

        txtTotalPrice.setEditable(false);
        add(txtTotalPrice, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 440, 113, -1));

        buttonGroupHasPersonalTraining.add(radioBtnYes);
        radioBtnYes.setText("Yes");
        radioBtnYes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnYesActionPerformed(evt);
            }
        });
        add(radioBtnYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(204, 395, -1, -1));

        buttonGroupHasPersonalTraining.add(radioBtnNo);
        radioBtnNo.setText("No");
        radioBtnNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioBtnNoActionPerformed(evt);
            }
        });
        add(radioBtnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 395, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
        
    public void populateMembershipData(){
        this.membershipList = accounting.getMembershipDirectory().getMembershipList();
        for(int i = 0; i < membershipList.size(); i++){
            Membership membership = membershipList.get(i);
            currencyMultiplier = membership.getCurrencyMultiplier();
            int price = 0;
            switch(i){
                case 0:
                    if(userAccount.getCustomer().getMembership().getName().equals(membership.getName())){
                        radioBtnPlan1.setSelected(true);
                        selectedType = getMembershipType(membership.getName());
                        totalPrice = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    }
                    radioBtnPlan1.setText(membership.getName());
                    radioBtnPlan1.setActionCommand(membership.getName());
                    price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    lblPrice1.setText(membership.getCurrency()+" "+String.valueOf(price));
                    break;
                case 1:
                    if(userAccount.getCustomer().getMembership().getName().equals(membership.getName())){
                        radioBtnPlan2.setSelected(true);
                        selectedType = getMembershipType(membership.getName());
                        totalPrice = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    }
                    radioBtnPlan2.setText(membership.getName());
                    radioBtnPlan2.setActionCommand(membership.getName());
                    price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    lblPrice2.setText(membership.getCurrency()+" "+String.valueOf(price));
                    break;
                case 2:
                    if(userAccount.getCustomer().getMembership().getName().equals(membership.getName())){
                        radioBtnPlan3.setSelected(true);
                        selectedType = getMembershipType(membership.getName());
                        totalPrice = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    }
                    radioBtnPlan3.setText(membership.getName());
                    radioBtnPlan3.setActionCommand(membership.getName());
                    price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    lblPrice3.setText(membership.getCurrency()+" "+String.valueOf(price));
                    break;
                case 3:
                    if(userAccount.getCustomer().getMembership().getName().equals(membership.getName())){
                        radioBtnPlan4.setSelected(true);
                        selectedType = getMembershipType(membership.getName());
                        totalPrice = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    }
                    radioBtnPlan4.setText(membership.getName());
                    radioBtnPlan4.setActionCommand(membership.getName());
                    price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    lblPrice4.setText(membership.getCurrency()+" "+String.valueOf(price));
                    break;
                case 4:
                    if(userAccount.getCustomer().getMembership().getName().equals(membership.getName())){
                        radioBtnPlan5.setSelected(true);
                        selectedType = getMembershipType(membership.getName());
                        totalPrice = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    }
                    radioBtnPlan5.setText(membership.getName());
                    radioBtnPlan5.setActionCommand(membership.getName());
                    price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    lblPrice5.setText(membership.getCurrency()+" "+String.valueOf(price));
                    break;
                case 5:
                    if(userAccount.getCustomer().getMembership().getName().equals(membership.getName())){
                        radioBtnPlan6.setSelected(true);
                        selectedType = getMembershipType(membership.getName());
                        totalPrice = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    }
                    radioBtnPlan6.setText(membership.getName());
                    radioBtnPlan6.setActionCommand(membership.getName());
                    price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                    lblPrice6.setText(membership.getCurrency()+" "+String.valueOf(price));
                    break;
            }
            jLabel21.setText(membership.getCurrency());
            jLabel18.setText(membership.getCurrency() + " " + String.valueOf(Math.round(50*currencyMultiplier)) + "/month");
        }
    }
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:
        String selectedPlan = buttonGroupMembership.getSelection().getActionCommand();
        Membership.membershipType type = getMembershipType(selectedPlan);
        
        MembershipDirectory membershipDirectory = accounting.getMembershipDirectory();
        Membership parentMembership = null;
        for(Membership membership: membershipDirectory.getMembershipList()){
            if(membership.getName().equals(type.toString())){
                parentMembership = membership;
                break;
            }
        }
        
        userAccount.getCustomer().getMembership().setName(type);
        userAccount.getCustomer().getMembership().setPrice(parentMembership.getPrice());
        userAccount.getCustomer().getMembership().setDescription(parentMembership.getDescription());
        userAccount.getCustomer().getMembership().setDurationInDays(parentMembership.getDurationInDays());
        userAccount.getCustomer().getMembership().setHasSpecialServicesAccess(parentMembership.getHasSpecialServicesAccess());

        if(radioBtnYes.isSelected())
            userAccount.getCustomer().getMembership().setHasPersonalTraining(Boolean.TRUE);
        else if(radioBtnNo.isSelected())
            userAccount.getCustomer().getMembership().setHasPersonalTraining(Boolean.FALSE);
        
        JOptionPane.showMessageDialog(null, "Congratulations, your membership is renewed!", "Info", JOptionPane.INFORMATION_MESSAGE);    
    }//GEN-LAST:event_btnRegisterActionPerformed

    private Membership.membershipType getMembershipType(String str){
        Membership.membershipType type = null;
        if(str.equals(Membership.membershipType.Bronze.toString()))
            type = Membership.membershipType.Bronze;
        else if(str.equals(Membership.membershipType.Diamond.toString()))
            type = Membership.membershipType.Diamond;
        else if(str.equals(Membership.membershipType.Gold.toString()))
            type = Membership.membershipType.Gold;
        else if(str.equals(Membership.membershipType.Platinum.toString()))
            type = Membership.membershipType.Platinum;
        else if(str.equals(Membership.membershipType.Silver.toString()))
            type = Membership.membershipType.Silver;
        else if(str.equals(Membership.membershipType.Steel.toString()))
            type = Membership.membershipType.Steel;
        
        return type;
    }
    
    private void displayTotalPrice(float price, Membership.membershipType type){
        if(selectedType != null){
            if(!type.toString().equals(selectedType.toString())){
                float oldPrice = 0;
                for(Membership m: membershipList){
                    if(m.getName().equals(selectedType.toString())){
                        oldPrice = m.getPrice();
                        break;
                    }
                }
                totalPrice -= oldPrice*currencyMultiplier;
            }
        }
            
        totalPrice += price*currencyMultiplier;
        this.selectedType = type;
        
        txtTotalPrice.setText(String.valueOf(Math.round(totalPrice)));
    }
    
    private void membershipRadioButtonClicked(JRadioButton button){
        Membership.membershipType type = getMembershipType(button.getText());
        if(type != selectedType){
            for(Membership membership: membershipList){
                if(membership.getName().equals(type.toString())){
                    displayTotalPrice(membership.getPrice(), type);
                    break;
                }
            }
        }
    }
    
    private String getDescriptionFromMembershipList(int index, String flag){
        int count = 1;
        for(Membership membership: membershipList){
            if(count == index){
                if(flag.equals("Desc"))
                    return membership.getDescription();
                if(flag.equals("Header"))
                    return membership.getName() + " Membership";
            }
            count++;
        }
        return null;
    }
    
    private void btnDetails1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails1ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, getDescriptionFromMembershipList(1,"Desc"), getDescriptionFromMembershipList(1,"Header"), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDetails1ActionPerformed

    private void btnDetails2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails2ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, getDescriptionFromMembershipList(2,"Desc"), getDescriptionFromMembershipList(2,"Header"), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDetails2ActionPerformed

    private void btnDetails3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails3ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, getDescriptionFromMembershipList(3,"Desc"), getDescriptionFromMembershipList(3,"Header"), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDetails3ActionPerformed

    private void btnDetails4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails4ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, getDescriptionFromMembershipList(4,"Desc"), getDescriptionFromMembershipList(4,"Header"), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDetails4ActionPerformed

    private void btnDetails5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails5ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, getDescriptionFromMembershipList(5,"Desc"), getDescriptionFromMembershipList(5,"Header"), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDetails5ActionPerformed

    private void btnDetails6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDetails6ActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, getDescriptionFromMembershipList(6,"Desc"), getDescriptionFromMembershipList(6,"Header"), JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_btnDetails6ActionPerformed

    private void radioBtnPlan1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPlan1ActionPerformed
        // TODO add your handling code here:
        membershipRadioButtonClicked(radioBtnPlan1);
    }//GEN-LAST:event_radioBtnPlan1ActionPerformed

    private void radioBtnPlan2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPlan2ActionPerformed
        // TODO add your handling code here:
        membershipRadioButtonClicked(radioBtnPlan2);
    }//GEN-LAST:event_radioBtnPlan2ActionPerformed

    private void radioBtnPlan3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPlan3ActionPerformed
        // TODO add your handling code here:
        membershipRadioButtonClicked(radioBtnPlan3);
    }//GEN-LAST:event_radioBtnPlan3ActionPerformed

    private void radioBtnPlan4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPlan4ActionPerformed
        // TODO add your handling code here:
        membershipRadioButtonClicked(radioBtnPlan4);
    }//GEN-LAST:event_radioBtnPlan4ActionPerformed

    private void radioBtnPlan5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPlan5ActionPerformed
        // TODO add your handling code here:
        membershipRadioButtonClicked(radioBtnPlan5);
    }//GEN-LAST:event_radioBtnPlan5ActionPerformed

    private void radioBtnPlan6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnPlan6ActionPerformed
        // TODO add your handling code here:
        membershipRadioButtonClicked(radioBtnPlan6);
    }//GEN-LAST:event_radioBtnPlan6ActionPerformed

    private void radioBtnYesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnYesActionPerformed
        // TODO add your handling code here:
        if(!selectedTraining){
            totalPrice += 50*currencyMultiplier;
            txtTotalPrice.setText(String.valueOf(Math.round(totalPrice)));
            selectedTraining = true;
        }
    }//GEN-LAST:event_radioBtnYesActionPerformed

    private void radioBtnNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioBtnNoActionPerformed
        // TODO add your handling code here:
        if(selectedTraining){
            totalPrice -= 50*currencyMultiplier;
            txtTotalPrice.setText(String.valueOf(Math.round(totalPrice)));
            selectedTraining = false;
        }
    }//GEN-LAST:event_radioBtnNoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDetails1;
    private javax.swing.JButton btnDetails2;
    private javax.swing.JButton btnDetails3;
    private javax.swing.JButton btnDetails4;
    private javax.swing.JButton btnDetails5;
    private javax.swing.JButton btnDetails6;
    private javax.swing.JButton btnRegister;
    private javax.swing.ButtonGroup buttonGroupHasPersonalTraining;
    private javax.swing.ButtonGroup buttonGroupMembership;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblPrice1;
    private javax.swing.JLabel lblPrice2;
    private javax.swing.JLabel lblPrice3;
    private javax.swing.JLabel lblPrice4;
    private javax.swing.JLabel lblPrice5;
    private javax.swing.JLabel lblPrice6;
    private javax.swing.JRadioButton radioBtnNo;
    private javax.swing.JRadioButton radioBtnPlan1;
    private javax.swing.JRadioButton radioBtnPlan2;
    private javax.swing.JRadioButton radioBtnPlan3;
    private javax.swing.JRadioButton radioBtnPlan4;
    private javax.swing.JRadioButton radioBtnPlan5;
    private javax.swing.JRadioButton radioBtnPlan6;
    private javax.swing.JRadioButton radioBtnYes;
    private javax.swing.JTextField txtTotalPrice;
    // End of variables declaration//GEN-END:variables
}