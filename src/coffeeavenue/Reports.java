/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coffeeavenue;

import java.awt.CardLayout;
import java.util.List;
import javax.persistence.Query;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Reports extends javax.swing.JFrame {

    /**
     * Creates new form Reports
     */
    public Reports() {
        initComponents();
        showPanel("card2");
    }
     void showPanel(String cname){
        CardLayout cl = (CardLayout)jPanel2.getLayout();
        cl.show(jPanel2, cname);
    }
    
    void updateTable2(List orderlogList){
        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderlogList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${time}"));
        columnBinding.setColumnName("Time");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employee}"));
        columnBinding.setColumnName("Employee");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${customer}"));
        columnBinding.setColumnName("Customer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pointsdiscountsclaimed}"));
        columnBinding.setColumnName("Pointsdiscountsclaimed");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bill}"));
        columnBinding.setColumnName("Bill");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(jTable1);
    }
    void updateTable(List salesList){
        org.jdesktop.swingbinding.JTableBinding  jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, salesList, jTable2);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateitem}"));
        columnBinding.setColumnName("Dateitem");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amount}"));
        columnBinding.setColumnName("Amount");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding); 
        jTableBinding.bind();

        jScrollPane2.setViewportView(jTable2);
    }
    
     void updateTable3(List employeesalesList){
      org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, employeesalesList, jTable3);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeeitem}"));
        columnBinding.setColumnName("Employeeitem");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amount}"));
        columnBinding.setColumnName("Amount");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane3.setViewportView(jTable3);
     }
     void update(){
         updateTable(salesList);
         updateTable2(orderlogList);
         updateTable3(employeesalesList);
     }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("coffeeavenue/Bundle"); // NOI18N
        CoffeeAvenuePUEntityManager = java.beans.Beans.isDesignTime() ? null : javax.persistence.Persistence.createEntityManagerFactory(bundle.getString("Reports.CoffeeAvenuePUEntityManager.persistenceUnit")).createEntityManager(); // NOI18N
        orderlogQuery = java.beans.Beans.isDesignTime() ? null : CoffeeAvenuePUEntityManager.createQuery(bundle.getString("Reports.orderlogQuery.query")); // NOI18N
        orderlogList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : orderlogQuery.getResultList();
        salesQuery = java.beans.Beans.isDesignTime() ? null : CoffeeAvenuePUEntityManager.createQuery(bundle.getString("Reports.salesQuery.query")); // NOI18N
        salesList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : salesQuery.getResultList();
        employeesalesQuery = java.beans.Beans.isDesignTime() ? null : CoffeeAvenuePUEntityManager.createQuery(bundle.getString("Reports.employeesalesQuery.query")); // NOI18N
        employeesalesList = java.beans.Beans.isDesignTime() ? java.util.Collections.emptyList() : employeesalesQuery.getResultList();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(216, 100, 17));

        jButton1.setBackground(new java.awt.Color(216, 100, 17));
        jButton1.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jButton1.setForeground(new java.awt.Color(206, 179, 122));
        jButton1.setText(bundle.getString("Reports.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(216, 100, 17));
        jButton2.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jButton2.setForeground(new java.awt.Color(206, 179, 122));
        jButton2.setText(bundle.getString("Reports.jButton2.text")); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(216, 100, 17));
        jButton3.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jButton3.setForeground(new java.awt.Color(206, 179, 122));
        jButton3.setText(bundle.getString("Reports.jButton3.text")); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton7.setBackground(new java.awt.Color(216, 100, 17));
        jButton7.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jButton7.setForeground(new java.awt.Color(206, 179, 122));
        jButton7.setText(bundle.getString("Reports.jButton7.text")); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 294, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jButton3))
                .addGap(37, 37, 37))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(206, 179, 122));
        jPanel2.setLayout(new java.awt.CardLayout());

        jPanel3.setBackground(new java.awt.Color(206, 179, 122));

        org.jdesktop.swingbinding.JTableBinding jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, orderlogList, jTable1);
        org.jdesktop.swingbinding.JTableBinding.ColumnBinding columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${orderid}"));
        columnBinding.setColumnName("Orderid");
        columnBinding.setColumnClass(Integer.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${date}"));
        columnBinding.setColumnName("Date");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${time}"));
        columnBinding.setColumnName("Time");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employee}"));
        columnBinding.setColumnName("Employee");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${total}"));
        columnBinding.setColumnName("Total");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${customer}"));
        columnBinding.setColumnName("Customer");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${pointsdiscountsclaimed}"));
        columnBinding.setColumnName("Pointsdiscountsclaimed");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${bill}"));
        columnBinding.setColumnName("Bill");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(216, 100, 17));
        jLabel1.setText(bundle.getString("Reports.jLabel1.text")); // NOI18N

        jTextField1.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(216, 100, 17));
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jRadioButton1.setForeground(new java.awt.Color(216, 100, 17));
        jRadioButton1.setText(bundle.getString("Reports.jRadioButton1.text")); // NOI18N

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        jRadioButton2.setForeground(new java.awt.Color(216, 100, 17));
        jRadioButton2.setText(bundle.getString("Reports.jRadioButton2.text")); // NOI18N

        jLabel2.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(216, 100, 17));
        jLabel2.setText(bundle.getString("Reports.jLabel2.text")); // NOI18N

        jTextField2.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(216, 100, 17));
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(216, 100, 17));
        jButton4.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton4.setForeground(new java.awt.Color(206, 179, 122));
        jButton4.setText(bundle.getString("Reports.jButton4.text")); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(216, 100, 17));
        jLabel3.setText(bundle.getString("Reports.jLabel3.text")); // NOI18N

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, jTable1, org.jdesktop.beansbinding.ELProperty.create("${selectedElement.bill}"), jTextArea1, org.jdesktop.beansbinding.BeanProperty.create("text"));
        bindingGroup.addBinding(binding);

        jScrollPane4.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(425, 425, 425)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(145, 145, 145)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1366, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(319, 319, 319)
                                .addComponent(jLabel1)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(28, 28, 28)
                                        .addComponent(jRadioButton2)
                                        .addGap(103, 103, 103)
                                        .addComponent(jRadioButton1))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGap(37, 37, 37)
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 774, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 111, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1))
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jRadioButton2))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
                        .addGap(76, 76, 76))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4)
                        .addContainerGap())))
        );

        jPanel2.add(jPanel3, "card2");

        jPanel4.setBackground(new java.awt.Color(206, 179, 122));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, salesList, jTable2);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${dateitem}"));
        columnBinding.setColumnName("Dateitem");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amount}"));
        columnBinding.setColumnName("Amount");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane2.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(216, 100, 17));
        jLabel4.setText(bundle.getString("Reports.jLabel4.text")); // NOI18N

        jTextField3.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField3.setForeground(new java.awt.Color(216, 100, 17));
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(216, 100, 17));
        jLabel5.setText(bundle.getString("Reports.jLabel5.text")); // NOI18N

        jTextField4.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(216, 100, 17));
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(216, 100, 17));
        jButton5.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton5.setForeground(new java.awt.Color(206, 179, 122));
        jButton5.setText(bundle.getString("Reports.jButton5.text")); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(285, 285, 285)
                        .addComponent(jLabel4)
                        .addGap(37, 37, 37)
                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(259, 259, 259)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1081, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(206, 206, 206)
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(294, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addGap(84, 84, 84))
        );

        jPanel2.add(jPanel4, "card3");

        jPanel5.setBackground(new java.awt.Color(206, 179, 122));

        jTableBinding = org.jdesktop.swingbinding.SwingBindings.createJTableBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, employeesalesList, jTable3);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${employeeitem}"));
        columnBinding.setColumnName("Employeeitem");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${quantity}"));
        columnBinding.setColumnName("Quantity");
        columnBinding.setColumnClass(String.class);
        columnBinding = jTableBinding.addColumnBinding(org.jdesktop.beansbinding.ELProperty.create("${amount}"));
        columnBinding.setColumnName("Amount");
        columnBinding.setColumnClass(String.class);
        bindingGroup.addBinding(jTableBinding);
        jTableBinding.bind();

        jScrollPane3.setViewportView(jTable3);

        jLabel6.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(216, 100, 17));
        jLabel6.setText(bundle.getString("Reports.jLabel6.text")); // NOI18N

        jTextField5.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField5.setForeground(new java.awt.Color(216, 100, 17));
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jTextField6.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jTextField6.setForeground(new java.awt.Color(216, 100, 17));
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Bell MT", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(216, 100, 17));
        jLabel7.setText(bundle.getString("Reports.jLabel7.text")); // NOI18N

        jButton6.setBackground(new java.awt.Color(216, 100, 17));
        jButton6.setFont(new java.awt.Font("Bell MT", 0, 24)); // NOI18N
        jButton6.setForeground(new java.awt.Color(206, 179, 122));
        jButton6.setText(bundle.getString("Reports.jButton6.text")); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(71, 71, 71)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1016, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(298, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jButton6)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel2.add(jPanel5, "card4");

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        bindingGroup.bind();

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
       
        if (jRadioButton2.isSelected()) {
            Query y = CoffeeAvenuePUEntityManager.createQuery("SELECT o FROM Orderlog o WHERE o.customer like :customer");
            y.setParameter("customer", "%" + jTextField1.getText() + "%");
            orderlogList.clear();
            orderlogList = y.getResultList();
            updateTable2(orderlogList);
           jTextField2.setText("");

        } else if (jRadioButton1.isSelected()) {
            Query y = CoffeeAvenuePUEntityManager.createQuery("SELECT o FROM Orderlog o WHERE o.bill like :bill");
            y.setParameter("bill", "%" + jTextField1.getText() + "%");
            orderlogList.clear();
            orderlogList = y.getResultList();
            updateTable2(orderlogList);
            jTextField2.setText("");

        } else {
            JOptionPane.showMessageDialog(rootPane, "Select A Search Criteria", "Warning", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2KeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
     
        int sum = 0;
        for(int i =0;i<jTable1.getRowCount();i++){
            sum = sum +Integer.parseInt(jTable1.getValueAt(i,4 ).toString());
        }
        jTextField2.setText(Integer.toString(sum));
   
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
         showPanel("card2");
         update();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
         showPanel("card3");
          update();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        updateTable3(employeesalesList);
        showPanel("card4");
          update();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        Query y = CoffeeAvenuePUEntityManager.createQuery("SELECT s FROM Sales s WHERE s.dateitem like :dateitem");
            y.setParameter("dateitem", "%" + jTextField3.getText() + "%");
            salesList.clear();
            salesList = y.getResultList();
            updateTable(salesList);
           jTextField4.setText("");
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
          int sum = 0;
        for(int i =0;i<jTable2.getRowCount();i++){
            sum = sum +Integer.parseInt(jTable2.getValueAt(i,2 ).toString());
        }
        jTextField4.setText(Integer.toString(sum));
   
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
         Query y = CoffeeAvenuePUEntityManager.createQuery("SELECT e FROM Employeesales e WHERE e.employeeitem like :employeeitem");
            y.setParameter("employeeitem", "%" + jTextField5.getText() + "%");
            employeesalesList.clear();
            employeesalesList = y.getResultList();
            updateTable3(employeesalesList);
           jTextField6.setText("");
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6KeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
         int sum = 0;
        for(int i =0;i<jTable3.getRowCount();i++){
            sum = sum +Integer.parseInt(jTable3.getValueAt(i,2 ).toString());
        }
        jTextField6.setText(Integer.toString(sum));
   
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton7ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Reports.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Reports().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.persistence.EntityManager CoffeeAvenuePUEntityManager;
    private javax.swing.ButtonGroup buttonGroup1;
    private java.util.List<coffeeavenue.Employeesales> employeesalesList;
    private javax.persistence.Query employeesalesQuery;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable jTable3;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private java.util.List<coffeeavenue.Orderlog> orderlogList;
    private javax.persistence.Query orderlogQuery;
    private java.util.List<coffeeavenue.Sales> salesList;
    private javax.persistence.Query salesQuery;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
