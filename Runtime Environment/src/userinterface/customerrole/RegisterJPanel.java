/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userinterface.customerrole;

import business.Business;
import business.enterprise.Enterprise;
import business.network.Network;
import business.organization.accounting.membership.Membership;
import business.parentnetwork.ParentNetwork;
import business.person.Person;
import business.person.customer.Customer;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author soumiyaroy
 */
public class RegisterJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Business business;
    private ArrayList<Membership> membershipList;

    /**
     * Creates new form NewMemberLoginJPanel
     */
    public RegisterJPanel(JPanel userProcessContainer, Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.business = business;

        populateCountryCombo();
        passPassword.setText(null);
        passConfirmPassword.setText(null);
    }
    
    public void populateMembershipData(ParentNetwork selectedParentNetwork){
        for(ParentNetwork parentNetwork : business.getParentNetworkDirectory().getParentNetworkList()){
            if(selectedParentNetwork.getId() == parentNetwork.getId()){
                for(Network network : parentNetwork.getNetworkDirectory().getNetworkList()){
                    for(Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()){
                       this.membershipList = enterprise.getOrganizationDirectory().getAccounting().getMembershipDirectory().getMembershipList();
                       for(int i = 0; i < membershipList.size(); i++){
                           Membership membership = membershipList.get(i);
                           int price = 0;
                           switch(i){
                               case 0:
                                   radioBtnPlan1.setText(membership.getName());
                                   radioBtnPlan1.setActionCommand(membership.getName());
                                   price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                                   lblPrice1.setText(membership.getCurrency()+" "+String.valueOf(price));
                                   break;
                               case 1:
                                   radioBtnPlan2.setText(membership.getName());
                                   radioBtnPlan2.setActionCommand(membership.getName());
                                   price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                                   lblPrice2.setText(membership.getCurrency()+" "+String.valueOf(price));
                                   break;
                               case 2:
                                   radioBtnPlan3.setText(membership.getName());
                                   radioBtnPlan3.setActionCommand(membership.getName());
                                   price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                                   lblPrice3.setText(membership.getCurrency()+" "+String.valueOf(price));
                                   break;
                               case 3:
                                   radioBtnPlan4.setText(membership.getName());
                                   radioBtnPlan4.setActionCommand(membership.getName());
                                   price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                                   lblPrice4.setText(membership.getCurrency()+" "+String.valueOf(price));
                                   break;
                               case 4:
                                   radioBtnPlan5.setText(membership.getName());
                                   radioBtnPlan5.setActionCommand(membership.getName());
                                   price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                                   lblPrice5.setText(membership.getCurrency()+" "+String.valueOf(price));
                                   break;
                               case 5:
                                   radioBtnPlan6.setText(membership.getName());
                                   radioBtnPlan6.setActionCommand(membership.getName());
                                   price = Math.round(membership.getPrice() * membership.getCurrencyMultiplier());
                                   lblPrice6.setText(membership.getCurrency()+" "+String.valueOf(price));
                                   break;
                           }
                       }
                       return;
                    }
                }
            }
        }
    }
    
    public void populateCountryCombo(){
        JComboBox countryCombo = comboCountry;
        countryCombo.removeAllItems();
        int counter = 0;
        for(ParentNetwork parentNetwork : business.getParentNetworkDirectory().getParentNetworkList()){
            if(counter == 0){
                populateCityCombo(parentNetwork);
            }
            countryCombo.addItem(parentNetwork);
            counter++;
        }
        countryCombo.setEnabled(true);
    }
    
    public void populateCityCombo(ParentNetwork parentNetwork){
        JComboBox cityCombo = comboCity;
        cityCombo.removeAllItems();
        int counter = 0;
        for(ParentNetwork pn : business.getParentNetworkDirectory().getParentNetworkList()){
            if(parentNetwork.getId() == pn.getId()){
                for(Network network : pn.getNetworkDirectory().getNetworkList()){
                    if(counter == 0)
                        populateBranchCombo(parentNetwork, network);
                    cityCombo.addItem(network);
                    counter++;
                }
                cityCombo.setEnabled(true);
                break;
            } 
        }
    }
    
    public void populateBranchCombo(ParentNetwork parentNetwork, Network network){
        JComboBox branchCombo = comboBranch;
        branchCombo.removeAllItems();
        for(ParentNetwork pn : business.getParentNetworkDirectory().getParentNetworkList()){
            if(parentNetwork.getId() == pn.getId()){
                for(Network n : pn.getNetworkDirectory().getNetworkList()){
                    if(network.getId() == n.getId()){
                        for(Enterprise enterprise : n.getEnterpriseDirectory().getEnterpriseList()){
                           branchCombo.addItem(enterprise);
                        }
                        populateMembershipData(parentNetwork);
                        comboBranch.setEnabled(true);
                        break;
                    }
                }
                break;
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

        buttonGroupMembership = new javax.swing.ButtonGroup();
        buttonGroupGender = new javax.swing.ButtonGroup();
        buttonGroupHasPersonalTraining = new javax.swing.ButtonGroup();
        txtFirstName = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        passPassword = new javax.swing.JPasswordField();
        passConfirmPassword = new javax.swing.JPasswordField();
        txtEmailID = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        comboCity = new javax.swing.JComboBox<>();
        comboBranch = new javax.swing.JComboBox<>();
        comboCountry = new javax.swing.JComboBox();
        txtZipCode = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtPhoneNo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtLastName = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel19 = new javax.swing.JLabel();
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
        btnRegister = new javax.swing.JButton();
        btnDetails6 = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtCity = new javax.swing.JTextField();
        txtState = new javax.swing.JTextField();
        txtCountry = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        txtPromoCode = new javax.swing.JTextField();
        btnPromoCode = new javax.swing.JButton();
        radioBtnMale = new javax.swing.JRadioButton();
        radioBtnFemale = new javax.swing.JRadioButton();
        radioBtnYes = new javax.swing.JRadioButton();
        radioBtnNo = new javax.swing.JRadioButton();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(102, 102, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtFirstName.setForeground(new java.awt.Color(51, 51, 255));
        add(txtFirstName, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 102, 144, -1));

        jSeparator1.setForeground(new java.awt.Color(255, 204, 0));
        add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 55, 1162, 18));

        jLabel1.setFont(new java.awt.Font("Yuppy SC", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 204, 0));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Register  ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1088, -1));

        jLabel3.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 204, 0));
        jLabel3.setText("First Name:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 106, -1, -1));

        jLabel5.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 204, 0));
        jLabel5.setText("Gender:");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 141, -1, -1));

        jLabel6.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 204, 0));
        jLabel6.setText("Date Of Birth:");
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 135, -1, -1));

        jLabel7.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 0));
        jLabel7.setText("Email ID:");
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(365, 170, -1, -1));

        jLabel8.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 204, 0));
        jLabel8.setText("Password:");
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 204, -1, -1));

        jLabel9.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 204, 0));
        jLabel9.setText("Confirm Password:");
        add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 204, -1, -1));

        passPassword.setText("jPasswordField1");
        add(passPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 200, 137, -1));

        passConfirmPassword.setText("jPasswordField2");
        add(passConfirmPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(448, 199, 146, 29));
        add(txtEmailID, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 166, 142, -1));

        jLabel11.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 204, 0));
        jLabel11.setText("Address:");
        add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 242, -1, -1));
        add(txtAddress, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 238, 361, -1));

        jLabel12.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 204, 0));
        jLabel12.setText("City:");
        add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(224, 401, -1, -1));

        jLabel13.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 204, 0));
        jLabel13.setText("Branch:");
        add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(405, 401, -1, -1));

        jLabel14.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 204, 0));
        jLabel14.setText("Country:");
        add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 341, -1, -1));

        jLabel15.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 204, 0));
        jLabel15.setText("Zip Code:");
        add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(258, 341, -1, -1));

        comboCity.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCity.setEnabled(false);
        comboCity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCityActionPerformed(evt);
            }
        });
        add(comboCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(262, 398, 116, -1));

        comboBranch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboBranch.setEnabled(false);
        add(comboBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(462, 398, 121, -1));

        comboCountry.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboCountry.setEnabled(false);
        comboCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCountryActionPerformed(evt);
            }
        });
        add(comboCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(79, 398, 116, -1));
        add(txtZipCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 337, 141, -1));

        jLabel16.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 204, 0));
        jLabel16.setText("Phone No:");
        add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 171, -1, -1));
        add(txtPhoneNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 167, 137, -1));

        jLabel10.setBackground(new java.awt.Color(255, 204, 0));
        jLabel10.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 204, 0));
        jLabel10.setText("Last Name:");
        add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 106, -1, -1));
        add(txtLastName, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 102, 142, -1));

        jLabel17.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 204, 0));
        jLabel17.setText("Please fill all the fields below:");
        add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 79, -1, -1));

        jSeparator3.setForeground(new java.awt.Color(255, 204, 0));
        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);
        add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(594, 79, -1, 346));

        jLabel19.setFont(new java.awt.Font("Lucida Grande", 3, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 204, 0));
        jLabel19.setText("Membership:");
        add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 79, -1, -1));

        buttonGroupMembership.add(radioBtnPlan1);
        radioBtnPlan1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan1.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan1.setText("Membership1 ");
        add(radioBtnPlan1, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 120, -1, -1));

        buttonGroupMembership.add(radioBtnPlan2);
        radioBtnPlan2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan2.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan2.setText("Membership2");
        add(radioBtnPlan2, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 161, -1, -1));

        buttonGroupMembership.add(radioBtnPlan3);
        radioBtnPlan3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan3.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan3.setText("Membership3");
        add(radioBtnPlan3, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 202, -1, -1));

        buttonGroupMembership.add(radioBtnPlan4);
        radioBtnPlan4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan4.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan4.setText("Membership4");
        add(radioBtnPlan4, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 243, -1, -1));

        buttonGroupMembership.add(radioBtnPlan5);
        radioBtnPlan5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan5.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan5.setText("Membership5");
        add(radioBtnPlan5, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 284, -1, -1));

        buttonGroupMembership.add(radioBtnPlan6);
        radioBtnPlan6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        radioBtnPlan6.setForeground(new java.awt.Color(255, 204, 0));
        radioBtnPlan6.setText("Membership6");
        add(radioBtnPlan6, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 325, -1, -1));

        lblPrice2.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice2.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice2.setText("$150");
        add(lblPrice2, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 162, 91, 23));

        lblPrice4.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice4.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice4.setText("$150");
        add(lblPrice4, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 244, 91, 23));

        lblPrice3.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice3.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice3.setText("$150");
        add(lblPrice3, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 203, 91, 23));

        lblPrice5.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice5.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice5.setText("$150");
        add(lblPrice5, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 285, 91, 23));

        lblPrice6.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice6.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice6.setText("$150");
        add(lblPrice6, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 326, 91, 23));

        lblPrice1.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        lblPrice1.setForeground(new java.awt.Color(255, 204, 0));
        lblPrice1.setText("$150");
        add(lblPrice1, new org.netbeans.lib.awtextra.AbsoluteConstraints(968, 121, 91, 23));

        btnDetails3.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails3.setText("Details");
        add(btnDetails3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1065, 201, 96, -1));

        btnDetails1.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails1.setText("Details");
        add(btnDetails1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1065, 119, 96, -1));

        btnDetails2.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails2.setText("Details");
        add(btnDetails2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1065, 160, 96, -1));

        btnDetails4.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails4.setText("Details");
        add(btnDetails4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1065, 242, 96, -1));

        btnDetails5.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails5.setText("Details");
        add(btnDetails5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1066, 283, 96, -1));

        btnRegister.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnRegister.setForeground(new java.awt.Color(255, 204, 0));
        btnRegister.setText("Register");
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(1062, 480, -1, -1));

        btnDetails6.setForeground(new java.awt.Color(102, 102, 255));
        btnDetails6.setText("Details");
        add(btnDetails6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1066, 324, 96, -1));

        btnBack.setFont(new java.awt.Font("Lucida Grande", 1, 13)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 204, 0));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(917, 480, 87, -1));

        jLabel2.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 0));
        jLabel2.setText("Select Branch Details:");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 375, -1, -1));

        jLabel4.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 204, 0));
        jLabel4.setText("Need a trainer? ");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 387, -1, -1));

        jLabel18.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 204, 0));
        jLabel18.setText("$50/day");
        add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 387, -1, -1));

        jLabel20.setFont(new java.awt.Font("Lucida Grande", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 204, 0));
        jLabel20.setText("Total Amount:");
        add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(875, 436, -1, -1));

        jLabel21.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 204, 0));
        jLabel21.setText("$");
        add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(1034, 440, -1, -1));

        jTextField1.setEditable(false);
        add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1049, 436, 113, -1));

        jLabel22.setFont(new java.awt.Font("Lucida Grande", 3, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 204, 0));
        jLabel22.setText("Country:");
        add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 401, -1, -1));
        add(txtCity, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 305, 135, -1));
        add(txtState, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 305, 141, -1));
        add(txtCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(112, 337, 135, -1));

        jLabel23.setBackground(new java.awt.Color(255, 204, 0));
        jLabel23.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 204, 0));
        jLabel23.setText("City:");
        add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(65, 310, -1, -1));

        jLabel24.setFont(new java.awt.Font("Lucida Grande", 3, 13)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 204, 0));
        jLabel24.setText("State");
        add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(292, 310, -1, -1));

        jLabel25.setFont(new java.awt.Font("YuGothic", 3, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 204, 0));
        jLabel25.setText("Promo Code:");
        add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(7, 274, -1, -1));
        add(txtPromoCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 270, 143, -1));

        btnPromoCode.setText("Apply Promo Code");
        add(btnPromoCode, new org.netbeans.lib.awtextra.AbsoluteConstraints(324, 270, -1, -1));

        buttonGroupGender.add(radioBtnMale);
        radioBtnMale.setText("Male");
        add(radioBtnMale, new org.netbeans.lib.awtextra.AbsoluteConstraints(111, 138, -1, -1));

        buttonGroupGender.add(radioBtnFemale);
        radioBtnFemale.setText("Female");
        add(radioBtnFemale, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 138, -1, -1));

        buttonGroupHasPersonalTraining.add(radioBtnYes);
        radioBtnYes.setText("Yes");
        add(radioBtnYes, new org.netbeans.lib.awtextra.AbsoluteConstraints(742, 384, -1, -1));

        buttonGroupHasPersonalTraining.add(radioBtnNo);
        radioBtnNo.setText("No");
        add(radioBtnNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 384, -1, -1));
        add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 135, 142, -1));
    }// </editor-fold>//GEN-END:initComponents

    private Boolean validateRegisterForm() {
        int dialogShown = 0;
        Pattern pattern;
        Matcher matcher;

        pattern = Pattern.compile("^[a-zA-Z]+$");
        matcher = pattern.matcher(txtFirstName.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 2;
            }
            txtFirstName.setBackground(Color.PINK);
        }
        matcher = pattern.matcher(txtLastName.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 3;
            }
            txtLastName.setBackground(Color.PINK);
        }
        if (txtAddress.getText().trim().length() == 0) {
            if (dialogShown <= 0) {
                dialogShown = 4;
            }
            txtAddress.setBackground(Color.PINK);
        }
        if (txtZipCode.getText().trim().length() == 0) {
            if (dialogShown <= 0) {
                dialogShown = 5;
            }
            txtZipCode.setBackground(Color.PINK);
        }
        if (!validatePhoneNumber(txtPhoneNo.getText())) {
            if (dialogShown <= 0) {
                dialogShown = 6;
            }
            txtPhoneNo.setBackground(Color.PINK);
        }
        pattern = Pattern.compile("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
        matcher = pattern.matcher(txtEmailID.getText());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 7;
            }
            txtEmailID.setBackground(Color.PINK);
        }
        
        if(buttonGroupMembership.getSelection() == null){
            if (dialogShown <= 0) {
                dialogShown = 8;
            }
        }
        
        if(buttonGroupGender.getSelection() == null){
            if (dialogShown <= 0) {
                dialogShown = 9;
            }
        }
        
        if(buttonGroupHasPersonalTraining.getSelection() == null){
            if (dialogShown <= 0) {
                dialogShown = 10;
            }
        }
        
        pattern = Pattern.compile("^[a-zA-Z]+$");
        matcher = pattern.matcher(txtCity.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 11;
            }
            txtCity.setBackground(Color.PINK);
        }
            
        matcher = pattern.matcher(txtState.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 12;
            }
            txtState.setBackground(Color.PINK);
        }
            
        matcher = pattern.matcher(txtCountry.getText().trim());
        if (!matcher.matches()) {
            if (dialogShown <= 0) {
                dialogShown = 13;
            }
            txtCountry.setBackground(Color.PINK);
        }
        
        if (passPassword.getPassword().length == 0 || passPassword.getPassword().length < 6) {
            if (dialogShown <= 0) {
                dialogShown = 14;
            }
            passPassword.setBackground(Color.PINK);
            passConfirmPassword.setBackground(Color.PINK);
        }
        
        if (passConfirmPassword.getPassword().toString().equals(passPassword.getPassword().toString())) {
            if (dialogShown <= 0) {
                dialogShown = 15;
            }
            passPassword.setBackground(Color.PINK);
            passConfirmPassword.setBackground(Color.PINK);
        }
        

        if (dialogShown == 0) {
            return true;
        } else {
            showValidationDialog(dialogShown);
            return false;
        }
    
    }
    
    private void showValidationDialog(int flag) {
        String errMessage = "";
        switch (flag) {
            
            case 2:
                errMessage = "Invalid First Name!";
                break;

            case 3:
                errMessage = "Invalid Last Name!";
                break;

            case 4:
                errMessage = "Invalid Address";

            case 5:
                errMessage = "Invalid Zip Code";

            case 6:
                errMessage = "Invalid Mobile number!";
                break;

            case 7:
                errMessage = "Invalid Email address!";
                break;

            case 8:
                errMessage = "Membership type not selected!";
                break;
                
            case 9:
                errMessage = "Gender not selected!";
                break;
                
            case 10:
                errMessage = "Personal Training preference not selected!";
                break;
             
            case 11:
                errMessage = "Invalid City!";
                break;
            
            case 12:
                errMessage = "Invalid State!";
                break;
             
            case 13:
                errMessage = "Invalid Country!";
                break; 
              
            case 14:
                errMessage = "Invalid Password!";
                break;   
                
            case 15:
                errMessage = "Passwords do not match!";
                break;   
                
                
        }

        JOptionPane.showMessageDialog(null, errMessage, "Error Message", JOptionPane.ERROR_MESSAGE);
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

    private void removeValidationDisplay() {
        
        txtFirstName.setBackground(Color.white);
        txtLastName.setBackground(Color.white);
        txtAddress.setBackground(Color.white);
        txtZipCode.setBackground(Color.white);
        txtPhoneNo.setBackground(Color.white);
        txtEmailID.setBackground(Color.white);
        txtCity.setBackground(Color.white);
        txtState.setBackground(Color.white);
        txtCountry.setBackground(Color.white);
        txtZipCode.setBackground(Color.white);
    }

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        // TODO add your handling code here:

        removeValidationDisplay();
        Boolean isValid = validateRegisterForm();
        if (isValid) {
            for (ParentNetwork parentNetwork : business.getParentNetworkDirectory().getParentNetworkList()) {
                if (comboCountry.getSelectedItem().toString().equals(parentNetwork.getCountryName())) {
                    for (Network network : parentNetwork.getNetworkDirectory().getNetworkList()) {
                        if (comboCity.getSelectedItem().toString().equals(network.getCity())) {
                            for (Enterprise enterprise : network.getEnterpriseDirectory().getEnterpriseList()) {
                                Enterprise e = (Enterprise)comboBranch.getSelectedItem();
                                if (e.getBranchName().equals(enterprise.getBranchName())) {

                                    setFormData(enterprise, parentNetwork);

                                    
                                }
                            }
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void setFormData(Enterprise enterprise, ParentNetwork parentNetwork) {
        
        String membershipString = buttonGroupMembership.getSelection().getActionCommand();
        Membership.membershipType type = getMembershipType(membershipString);
        Membership membership = new Membership(type, parentNetwork);
        if(radioBtnYes.isSelected())
            membership.setHasPersonalTraining(Boolean.TRUE);
        else if(radioBtnNo.isSelected())
            membership.setHasPersonalTraining(Boolean.FALSE);
        
        Customer customer = enterprise.getCustomerDirectory().addCustomer(membership);
        // bind user data
        
        customer.setName(txtFirstName.getText()+" "+txtLastName.getText());
        
        if(radioBtnMale.isSelected())
            customer.setGender(Person.genderType.Male);
        else if(radioBtnFemale.isSelected())
            customer.setGender(Person.genderType.Female);
        
        customer.setAddress(txtAddress.getText());
        customer.setZip(txtZipCode.getText());
        customer.setMobile(txtPhoneNo.getText());
        customer.setEmail(txtEmailID.getText());

        // prompt user data bind success
        JOptionPane.showMessageDialog(null, "Congratulations, you are now a member of Runtime Environment!", "Info", JOptionPane.INFORMATION_MESSAGE);

        // remove all field values
        
        txtFirstName.setText(null);
        txtLastName.setText(null);
        radioBtnMale.setSelected(false);
        radioBtnFemale.setSelected(false);
        txtAddress.setText(null);
        comboCity.setSelectedItem(false);
        comboBranch.setSelectedItem(false);
        comboCountry.setSelectedItem(false);
        txtZipCode.setText(null);
        txtPhoneNo.setText(null);
        txtEmailID.setText(null);
        txtState.setText(null);
        radioBtnYes.setSelected(false);
        radioBtnNo.setSelected(false);
    }
    
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

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void comboCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCountryActionPerformed
        // TODO add your handling code here:
        if(comboCountry.isEnabled()){
            comboCity.setEnabled(false);
            comboBranch.setEnabled(false);
            ParentNetwork parentNetwork = (ParentNetwork)comboCountry.getSelectedItem();
            populateCityCombo(parentNetwork);
            comboCity.setEnabled(true);
        }
    }//GEN-LAST:event_comboCountryActionPerformed

    private void comboCityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCityActionPerformed
        // TODO add your handling code here:
        if(comboCity.isEnabled()){
            ParentNetwork parentNetwork = (ParentNetwork)comboCountry.getSelectedItem();
            Network network = (Network)comboCity.getSelectedItem();
            populateBranchCombo(parentNetwork, network);
            comboBranch.setEnabled(true);
        }
    }//GEN-LAST:event_comboCityActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDetails1;
    private javax.swing.JButton btnDetails2;
    private javax.swing.JButton btnDetails3;
    private javax.swing.JButton btnDetails4;
    private javax.swing.JButton btnDetails5;
    private javax.swing.JButton btnDetails6;
    private javax.swing.JButton btnPromoCode;
    private javax.swing.JButton btnRegister;
    private javax.swing.ButtonGroup buttonGroupGender;
    private javax.swing.ButtonGroup buttonGroupHasPersonalTraining;
    private javax.swing.ButtonGroup buttonGroupMembership;
    private javax.swing.JComboBox<String> comboBranch;
    private javax.swing.JComboBox<String> comboCity;
    private javax.swing.JComboBox comboCountry;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblPrice1;
    private javax.swing.JLabel lblPrice2;
    private javax.swing.JLabel lblPrice3;
    private javax.swing.JLabel lblPrice4;
    private javax.swing.JLabel lblPrice5;
    private javax.swing.JLabel lblPrice6;
    private javax.swing.JPasswordField passConfirmPassword;
    private javax.swing.JPasswordField passPassword;
    private javax.swing.JRadioButton radioBtnFemale;
    private javax.swing.JRadioButton radioBtnMale;
    private javax.swing.JRadioButton radioBtnNo;
    private javax.swing.JRadioButton radioBtnPlan1;
    private javax.swing.JRadioButton radioBtnPlan2;
    private javax.swing.JRadioButton radioBtnPlan3;
    private javax.swing.JRadioButton radioBtnPlan4;
    private javax.swing.JRadioButton radioBtnPlan5;
    private javax.swing.JRadioButton radioBtnPlan6;
    private javax.swing.JRadioButton radioBtnYes;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtCity;
    private javax.swing.JTextField txtCountry;
    private javax.swing.JTextField txtEmailID;
    private javax.swing.JTextField txtFirstName;
    private javax.swing.JTextField txtLastName;
    private javax.swing.JTextField txtPhoneNo;
    private javax.swing.JTextField txtPromoCode;
    private javax.swing.JTextField txtState;
    private javax.swing.JTextField txtZipCode;
    // End of variables declaration//GEN-END:variables
}
